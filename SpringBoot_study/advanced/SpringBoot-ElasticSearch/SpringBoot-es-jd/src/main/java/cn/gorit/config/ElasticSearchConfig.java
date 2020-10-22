package cn.gorit.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring 步骤
 * 1. 找对象
 * 2. 放到 spring 中使用
 * 3. 分析源码
 *
 * @Classname ElasticSearchConfig
 * @Description TODO
 * @Date 2020/10/21 17:20
 * @Created by CodingGorit
 * @Version 1.0
 */
@Configuration // xml -bean
public class ElasticSearchConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")
                )
        );
        return client;
    }

}
