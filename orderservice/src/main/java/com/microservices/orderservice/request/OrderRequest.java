package com.microservices.orderservice.request;

import java.math.BigDecimal;

public record OrderRequest(Long id, String orderNumber, String skucode, BigDecimal price, Integer quantity) {

}
