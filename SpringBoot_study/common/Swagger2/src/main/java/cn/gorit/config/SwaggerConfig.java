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
