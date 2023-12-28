package com.eazybytes.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayserverApplication {

    private static final String EAZYBANK_ACCOUNTS = "/eazybank/accounts";
    private static final String EAZYBANK_LOANS    = "/eazybank/loans";
    private static final String EAZYBANK_CARDS    = "/eazybank/cards";

    private static final String X_RESPONSE_TIME = "X-Response-Time";

    public static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication.class, args);
    }

    @Bean
    public RouteLocator eazyBankRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path(EAZYBANK_ACCOUNTS + "/**")
                        .filters(f -> f.rewritePath(EAZYBANK_ACCOUNTS + "/(?<segment>.*)", "/${segment}")

                                        .addResponseHeader(X_RESPONSE_TIME, LocalDateTime.now().toString())
                        )
                        .uri("lb://ACCOUNTS"))
                .route(p -> p.path(EAZYBANK_LOANS + "/**")
                        .filters(f -> f.rewritePath(EAZYBANK_LOANS + "/(?<segment>.*)","/${segment}")
                                .addResponseHeader(X_RESPONSE_TIME, LocalDateTime.now().toString())

                        )
                        .uri("lb://LOANS")
                )
                .route(p -> p.path(EAZYBANK_CARDS + "/**")
                        .filters(f -> f.rewritePath(EAZYBANK_CARDS + "/(?<segment>.*)", "/${segment}")
                                .addResponseHeader(X_RESPONSE_TIME, LocalDateTime.now().toString())

                        )
                        .uri("lb://CARDS")
                )
                .build();
    }
}
