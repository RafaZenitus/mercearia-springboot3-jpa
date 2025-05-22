package com.merceariaweb.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.merceariaweb.demo.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
