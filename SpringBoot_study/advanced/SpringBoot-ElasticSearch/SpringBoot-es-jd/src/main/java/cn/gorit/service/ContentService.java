package cn.gorit.service;

import cn.gorit.pojo.Content;
import cn.gorit.util.HtmlParseUtil;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Classname ContentService
 * @Description TODO
 * @Date 2020/10/22 18:44
 * @Created by CodingGorit
 * @Version 1.0
 */
@Service
public class ContentService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    // 不能直接使用，只要 Spring 容器
    public static void main(String[] args) throws Exception {
        new ContentService().parseContent("java");
    }

    // 1. 解析数据放入 es 索引中
    public Boolean parseContent (String keywords) throws Exception {
        // 获取查询到的列表的信息
        List<Content> contents = new HtmlParseUtil().parseJD(keywords);
        // 把查询到的数据放入 es 中
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("2m");

        for (int i=0;i < contents.size();++i) {
            bulkRequest.add(
                    new IndexRequest("jd_goods")
                    .source(JSON.toJSONString(contents.get(i)),XContentType.JSON));
        }
        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        return !bulkResponse.hasFailures();
    }

    // 2. 获取这些数据，实现基本的搜索功能
    public List<Map<String,Object>> searchPagehighLight   (String keyword, int pageNo,int pageSize) throws IOException {
        if (pageNo <= 1)
            pageNo = 1;

        // 条件清晰
        SearchRequest searchRequest = new SearchRequest("jd_goods");

        SearchSourceBuilder builder = new SearchSourceBuilder();

        builder.from(pageNo);
        builder.size(pageSize);
        // 精准匹配
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title",keyword);
        builder.query(termQueryBuilder);
        builder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        // 高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("title");
        highlightBuilder.requireFieldMatch(false);
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.postTags("</span>");
        builder.highlighter(highlightBuilder);

        // 执行搜索
        searchRequest.source(builder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        // 解析结果
        ArrayList<Map<String,Object>> list= new ArrayList<>();
        for (SearchHit hit: searchResponse.getHits().getHits()) {
            // 解析高亮的字段
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField title = highlightFields.get("title");
            Map<String,Object> sourceAsMap = hit.getSourceAsMap();// 原来的结果
            // 解析高亮字段，将原来的字段换成我们高亮的字段即可
            if (title != null) {
                Text[] fragments = title.fragments();
                StringBuilder nTitle = new StringBuilder();
                for (Text text:fragments) {
                    nTitle.append(text);
                }
                sourceAsMap.put("title",nTitle);
            }
            list.add(hit.getSourceAsMap()); // 高亮的字段替换为原来的内容即可
        }
        return list;
    }

    // 2. 获取这些数据，实现基本的搜索功能
    public List<Map<String,Object>> searchPage (String keyword, int pageNo,int pageSize) throws IOException {
        if (pageNo <= 1)
            pageNo = 1;

        // 条件清晰
        SearchRequest searchRequest = new SearchRequest("jd_goods");

        SearchSourceBuilder builder = new SearchSourceBuilder();

        builder.from(pageNo);
        builder.size(pageSize);
        // 精准匹配
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title",keyword);
        builder.query(termQueryBuilder);
        builder.timeout(new TimeValue(60, TimeUnit.SECONDS));


        // 执行搜索
        searchRequest.source(builder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        // 解析结果
        ArrayList<Map<String,Object>> list= new ArrayList<>();
        for (SearchHit hit: searchResponse.getHits().getHits()) {

            list.add(hit.getSourceAsMap()); // 高亮的字段替换为原来的内容即可
        }
        return list;
    }
}
