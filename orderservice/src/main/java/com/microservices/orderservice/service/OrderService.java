package com.microservices.orderservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.orderservice.client.InventoryClient;
import com.microservices.orderservice.model.Order;
import com.microservices.orderservice.repository.OrderRepository;
import com.microservices.orderservice.request.OrderRequest;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private InventoryClient inventoryClient;

	public Order placeOrder(OrderRequest orderRequest) {

		var isAvailable = inventoryClient.isInStock(orderRequest.skucode(), orderRequest.quantity());

		if (isAvailable) {
			Order order = new Order();
			order.setOrderNumber(UUID.randomUUID().toString());
			order.setPrice(orderRequest.price());
			order.setSkuCode(orderRequest.skucode());
			order.setQuantity(orderRequest.quantity());
			orderRepository.save(order);
			return order;
		} else {
			throw new RuntimeException("Product with skuCode: " + orderRequest.skucode() + " is not available ");
		}
	}
}
