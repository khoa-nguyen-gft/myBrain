package com.eazybytes.gatewayserver.filters;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
public class FilterUtility {
    public static final String CORRELATION_ID = "eazybank-correlation-id";

    public String getCorrelationId(HttpHeaders httpHeaders) {
        if (httpHeaders.get(CORRELATION_ID) != null) {
            List<String> requestHeaderList = httpHeaders.get(CORRELATION_ID);
            assert requestHeaderList != null;
            return requestHeaderList.stream().findFirst().get();
        }

        return null;
    }

    boolean isCorrelationIdPresent(HttpHeaders httpHeaders) {
        if (getCorrelationId(httpHeaders) != null) {
            return true;
        }
        return false;
    }

    public String generateCorrelationId() {
        return java.util.UUID.randomUUID().toString();
    }

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
        return this.setRequestHeader(exchange, CORRELATION_ID, correlationId);
    }

    private ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String value) {
        return exchange.mutate().request(exchange.getRequest().mutate().header(name, value).build()).build();
    }
}
