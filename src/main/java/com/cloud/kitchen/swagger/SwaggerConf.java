// package com.cloud.kitchen.swagger;

// import java.util.Collections;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.service.ApiInfo;
// import springfox.documentation.service.Contact;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spring.web.plugins.Docket;

// @Configuration
// public class SwaggerConf {

//     @Bean
//     public Docket api() {
//         return new Docket(DocumentationType.SWAGGER_2)
//                 .select()
//                 .apis(RequestHandlerSelectors.basePackage("com.cloud.kitchen"))
//                 .paths(PathSelectors.any())
//                 .build().apiInfo(apiDetails());
//     }

//     private ApiInfo apiDetails() {
//         return new ApiInfo(
//             "Cloud Kitchen API",
//             "API Description",
//             "1.0",
//             "Free to use",
//             new Contact("Md Arifur Rahman", "htttps://cloud-Kitchen.arifur", "md-arifur.rahman@stud.uni-bamberg.de"),
//             "API License",
//             "API License URL",
//             Collections.emptyList()
//         );

// }
// }