package cn.gorit.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * DataSourceConfig 中提供了两个数据源：database1 和 database2，默认方法名即实例名
 * @ConfigurationProperties  使用不同的前缀配置文件
 */
@Configuration
public class DataSourceConfig {

    @Bean("dataSource1")
    @ConfigurationProperties(prefix = "spring.datasource.druid.db1")
    DataSource database1() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource.druid.db2")
    DataSource database2() {
        return DruidDataSourceBuilder.create().build();
    }
}
