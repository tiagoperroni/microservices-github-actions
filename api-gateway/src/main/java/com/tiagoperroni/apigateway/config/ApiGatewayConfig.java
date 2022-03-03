// package com.tiagoperroni.apigateway.config;

// import org.springframework.cloud.gateway.route.RouteLocator;
// import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class ApiGatewayConfig {
    
//     @Bean
//     public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

//         return builder.routes()
//             .route(r -> r.path("/get")
//             .filters(f -> f.addRequestHeader("Hello", "World")
//             .addRequestParameter("Hello", "World"))            
//             .uri("http://httpbin.org:80"))
//             // toda chamada para cambio-service/tudo mande pra load balancer cambio-service
//             .route(r -> r.path("/cambio-service/**").uri("lb://cambio-service"))
//             // toda chamada para book-service/tudo mande pra load balancer book-service
//             .route(r -> r.path("/book-service/**").uri("lb://book-service"))
//             .build();        
//     }
// }
