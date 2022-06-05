package me.kdshim.kdd_j.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.lang.reflect.Parameter;

public class SwaggerConfig extends WebMvcConfigurationSupport {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("build/swagger/codegen/api"))
//                .paths(PathSelectors.any())
//                .build();
//    }

//    public ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("KDD's API")
//                .version("0.0.1")
//                .description("Swagger for KDD")
//                .build();
//    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui")
//                .addResourceLocations("/spec/kdd.yaml");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
}
