@[toc](SpringBoot  配置类整理)  

如下配置类不需要特意去记忆，最新更新地址：[SpringBoot 常用配置类](https://blog.csdn.net/caidewei121/article/details/106383563)
# 一、跨域请求后端解决方案  

```java
package cn.gorit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//解决跨域问题  
@Configuration
public class CrosConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST","HEAD","PUT","DELETE")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
```

# 二、使用 Java 编码解决静态文件不加载  
在 resources 目录下的 static 的静态文件给外部访问  
```java
package cn.gorit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
```

# 三、封装统一返回结果集时，解决返回 null 值问题
当我们想要返回 json 格式数据的时候，难免会出现 null 值得情况，因此加入如下配置即可解决问题，使用默认的 jackson 解决问题。  

```java
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;

/**
 * 使用 SpringBoot 默认的 jackjson 解决 统一结果集为空的情况
 * */

@Configuration
public class NullValueConfiguration {
    
    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, IOException {
                jsonGenerator.writeString("");
            }
        });
        return objectMapper;
    }
}
```

# 四、SpringBoot 整合 swagger2 配置类编写  
SpringBoot 使用 swagger2 需在相对应的 实体类 和 Controller 中配置相对应的注解，就可以在根路径下的 swagger-ui.html 看到生成的在线文档
```java
package cn.gorit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @Author CondingGorit
 * @Date 2020年7月9日15:17:34
 * http://localhost/swagger-ui.htm
 * */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return  new Docket(DocumentationType.SWAGGER_2)
                // 指定构建 api 文档的详细信息放放：apiInfo()
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                // 指定要生成的 API 接口的包路径，这里把 Controller 作为包路径，生成 Controller 中的所有接口
                .apis(RequestHandlerSelectors.basePackage("cn.gorit.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建 API 文档的详细信息
     * @Return
     * */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题
                .title("SpringBoot集成 Swagger2 接口总览")
                // 设置接口描述
                .description("和 Gorit 学习 SpringBoot")
                // 设置联系方式
                .contact("Gorit： gorit@qq.com")
                // 设置版本
                .version("1.0")
                // 构建
                .build();
    }
}  
```  

效果图
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200709161238925.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NhaWRld2VpMTIx,size_16,color_FFFFFF,t_70)
 

