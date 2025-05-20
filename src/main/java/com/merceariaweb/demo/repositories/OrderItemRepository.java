package com.merceariaweb.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.merceariaweb.demo.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
