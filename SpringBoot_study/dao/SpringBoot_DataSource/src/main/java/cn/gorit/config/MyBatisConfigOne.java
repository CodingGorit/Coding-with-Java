package cn.gorit.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "cn.gorit.mapper.map1",sqlSessionFactoryRef = "sqlSessionFactoryBean1")
public class MyBatisConfigOne {

    @Autowired
    @Qualifier("dataSource1")
    DataSource db1;

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(db1);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:./mapper/map1/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean1());
    }
}
