package com.lucasjosino.parkingcontrolapi.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(metadata())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lucasjosino.parkingcontrolapi"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Parking Control API")
                .description("Parking Control API built with Spring Boot + PostgreSQL")
                .version("1.0.0")
                .license("BSD 3-Clause \"New\" or \"Revised\" License")
                .licenseUrl("https://github.com/LucJosin/parking-control-api/blob/main/LICENSE")
                .contact(
                        new Contact(
                                "Lucas Josino",
                                "https://lucasjosino.com",
                                "mauriurraco@gmail.com"
                        )
                )
                .build();
    }
}
