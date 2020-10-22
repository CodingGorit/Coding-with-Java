package cn.gorit.util;

import cn.gorit.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname HtmlParseUtil
 * @Description TODO
 * @Date 2020/10/21 23:17
 * @Created by CodingGorit
 * @Version 1.0
 */
@Component
public class HtmlParseUtil {

//    public static void main(String[] args) throws Exception {
//        new HtmlParseUtil().parseJD("英语").forEach(System.out::println);
//    }

    public List<Content> parseJD(String keyword) throws Exception {
        // 请求 url
        // 联网，不能获取 ajax 数据
        String url = "https://search.jd.com/Search?keyword=wd&enc=utf-8";
        // 解析网页 (返回的  Document 对象）
        Document document = Jsoup.parse(new URL(url.replace("wd",keyword)),30000);
        // 获取所有节点标签
        Element element = document.getElementById("J_goodsList");
        // 获取所有的 li 元素
        Elements elements = element.getElementsByTag("li");
        // 获取元素中的内容
        List<Content> goodsList = new ArrayList<>();
        for (Element e: elements) {
            String img = e.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = e.getElementsByClass("p-price").eq(0).text();
            String title = e.getElementsByClass("p-name").eq(0).text();

            goodsList.add(new Content(title,img,price));
//            System.out.println(img);
//            System.out.println(price);
//            System.out.println(title);
        }
        return goodsList;
    }
}
