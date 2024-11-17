package com.microservices.orderservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.orderservice.model.Order;
import com.microservices.orderservice.repository.OrderRepository;
import com.microservices.orderservice.request.OrderRequest;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		order.setPrice(orderRequest.price());
		order.setSkuCode(orderRequest.skucode());
		order.setQuantity(orderRequest.quantity());
		orderRepository.save(order);
	}
}
