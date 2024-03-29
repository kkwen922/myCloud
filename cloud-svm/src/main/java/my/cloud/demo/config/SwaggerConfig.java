package my.cloud.demo.config;


import my.cloud.demo.common.config.BaseSwaggerConfig;
import my.cloud.demo.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文檔相關配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("my.project.modules")
                .title("API文件(Demo)")
                .description("unknown@gmail.com")
                .contactName("unknown")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
