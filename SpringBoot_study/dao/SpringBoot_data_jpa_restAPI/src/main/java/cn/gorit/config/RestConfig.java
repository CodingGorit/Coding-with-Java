package cn.gorit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RestConfig extends RepositoryRestConfigurerAdapter {

    /**
     *      配置每页记录数为 5设
     *      分页查询页码参数名，默认为 page
     *
     * */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
          config.setDefaultPageSize(5)
                  .setBasePath("/api/v1/")
                  .setPageParamName("page")
                  .setLimitParamName("size")
                  .setSortParamName("sort")
                  .setReturnBodyOnCreate(true)
                  .setReturnBodyOnUpdate(true);
    }
}
