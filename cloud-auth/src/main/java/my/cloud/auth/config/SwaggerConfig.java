package my.cloud.auth.config;


import my.cloud.auth.common.config.BaseSwaggerConfig;
import my.cloud.auth.common.domain.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 * Created by macro on 2018/4/26.
 */
@Configuration
//@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("my.cloud.auth.controller")
                .title("認證服務")
                .description("認證服務API文件")
                .contactName("Kevin Chang")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }

//    @Bean
//    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
//        return generateBeanPostProcessor();
//    }

}
