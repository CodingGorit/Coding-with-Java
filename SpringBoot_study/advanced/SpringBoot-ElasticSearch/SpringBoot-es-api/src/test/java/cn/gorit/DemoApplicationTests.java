package cn.gorit;

import cn.gorit.pojo.User;
import com.alibaba.fastjson.JSON;
import javafx.scene.control.IndexRange;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContent;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * es 7.6.2 API 测试
 */
@SpringBootTest
class DemoApplicationTests {

    // 名称匹配
    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    @Test
    void contextLoads() {

    }

    // 索引的创建
    @Test
    void testCreateIndex() throws IOException {
        // 1. 创建索引请求  等价于 PUT /gorit_index
        CreateIndexRequest request = new CreateIndexRequest("gorit_index");
        // 2. 执行创建请求 IndicesClient, 请求后获得响应
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    // 测试获取索引，判断其是否存在
    @Test
    void testGetIndexExist() throws IOException {
        GetIndexRequest request = new GetIndexRequest("gorit_index");
        boolean exist = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exist);
    }

    // 删除索引
    @Test
    void testDeleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("gorit_index");
        // 删除
        AcknowledgedResponse delete = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }

    // 添加文档
    @Test
    void testAddDocument() throws IOException {
        // 创建对象
        User u = new User("Gorit", 3);
        // 创建请求
        IndexRequest request = new IndexRequest("gorit_index");

        // 规则 PUT /gorit_index/_doc/1
        request.id("1");
        request.timeout(TimeValue.timeValueSeconds(3));
        request.timeout("1s");

        // 将数据放入请求 json
        IndexRequest source = request.source(JSON.toJSONString(u), XContentType.JSON);
        // 客户端发送请求
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);

        System.out.println(response.toString());
        System.out.println(response.status());// 返回对应的状态 CREATED
    }

    // 获取文档，判断存在  get /index/_doc/1
    @Test
    void testIsExists() throws IOException {
        GetRequest getRequest = new GetRequest("gorit_index", "1");

        // 不获取返回的 _source 的上下文了
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");

        boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    // 获取文档信息
    @Test
    void testGetDocument() throws IOException {
        GetRequest getRequest = new GetRequest("gorit_index", "1");
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        // 打印文档的内容
        System.out.println(getResponse.getSourceAsString());
        System.out.println(getResponse); // 返回全部的内容和命令是一样的
    }

    // 更新文档信息
    @Test
    void testUpdateDocument() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("gorit_index", "1");
        updateRequest.timeout("1s");

        User user = new User("CodingGoirt", 18);
        updateRequest.doc(JSON.toJSONString(user), XContentType.JSON);

        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
        // 打印文档的内容
        System.out.println(updateResponse.status());
        System.out.println(updateResponse); // 返回全部的内容和命令是一样的
    }

    // 删除文档记录
    @Test
    void testDeleteDocument() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("gorit_index", "1");
        deleteRequest.timeout("1s");

        DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
        // 打印文档的内容
        System.out.println(deleteResponse.status());
        System.out.println(deleteResponse); // 返回全部的内容和命令是一样的
    }

    // 特殊的，真的项目。 批量插入数据

    @Test
    void testBulkRequest() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("张三1", 1));
        userList.add(new User("张三2", 2));
        userList.add(new User("张三3", 3));
        userList.add(new User("张三4", 4));
        userList.add(new User("张三5", 5));
        userList.add(new User("张三6", 6));
        userList.add(new User("张三7", 7));

        // 批处理请求
        for (int i = 0; i < userList.size(); i++) {
            // 批量更新，批量删除，就在这里修改为对应的请求即可
            bulkRequest.add(new IndexRequest("gorit_index")
                    .id("" + (i + 1))
                    .source(JSON.toJSONString(userList.get(i)), XContentType.JSON));
        }

        BulkResponse bulkItemResponses = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulkItemResponses.hasFailures()); // 是否失败
        System.out.println(bulkItemResponses.status());

    }

    // 查询
    // 	SearchRequest 搜索请求
    //  SearchSourceBuilder条件构造
    // HighlightBuilder 构建高亮
    // TermQueryBuilder 精确查询
    // MatchAllQueryBuilder
    //	xxx QueryBuilder
    @Test
    void testSearch() throws IOException {
        SearchRequest searchRequest = new SearchRequest("gorit_index");
        // 构建搜索的条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        /**
         *   查询条件  使用 QueryBuilders 工具类来实现
         * 	 QueryBuilders.termQuery 精确
         * 	 QueryBuilders.matchAllQueryBuilder() 匹配所有
         */

        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "gorit1");//精确查询
//		MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();

        sourceBuilder.query(termQueryBuilder);
        // 分页
        sourceBuilder.from();
        sourceBuilder.size();
        sourceBuilder.highlighter(); // 设置高亮
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        // 构建搜索
        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(searchResponse.getHits()));
        System.out.println("==========================================");
        for (SearchHit documentFields : searchResponse.getHits().getHits()) {
            System.out.println(documentFields.getSourceAsMap());
        }
    }

}
