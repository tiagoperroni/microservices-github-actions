server.port=8765
spring.application.name=api-gateway

##habilitando a descoberta dos paths
spring.cloud.gateway.discovery.locator.enabled=true
## letras minusculas aceita
##spring.cloud.gateway.discovery.locator.lower-case-service-id=true

## setando as rotas
spring.cloud.gateway.routes.id=cambio-service
spring.cloud.gateway.routes.uri=lb://cambio-service
spring.cloud.gateway.routes.predicates=Path=/cambio-service/**

spring.cloud.gateway.routes.id=book-service
spring.cloud.gateway.routes.uri=lb://book-service
spring.cloud.gateway.routes.predicates=Path=/book-service/**



## url eureka
eureka.client.service-url.defaultZone=http://localhost:8761/eureka

## config client
spring.config.import=optional:configserver: