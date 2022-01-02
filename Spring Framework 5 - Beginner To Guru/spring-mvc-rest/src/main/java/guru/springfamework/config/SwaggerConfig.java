package guru.springfamework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/");
    }

    private ApiInfo metaData() {

        final Contact contact = new Contact("Fredrik Pedersen", "github.com/fredrikpedersen", "fredrikhp@gmail.com");

        return new ApiInfo(
                "Spring Framework Udemy Course",
                "Spring Framework 5: From Beginner to Guru",
                "1.0",
                "Something something legal stuff",
                contact,
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LISENCE-2.0",
                new ArrayList<>()
        );
    }
}
