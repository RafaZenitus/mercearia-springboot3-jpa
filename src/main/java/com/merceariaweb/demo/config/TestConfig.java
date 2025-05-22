package com.merceariaweb.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.merceariaweb.demo.model.Category;
import com.merceariaweb.demo.model.Order;
import com.merceariaweb.demo.model.OrderItem;
import com.merceariaweb.demo.model.Payment;
import com.merceariaweb.demo.model.Product;
import com.merceariaweb.demo.model.User;
import com.merceariaweb.demo.model.enums.OrderStatus;
import com.merceariaweb.demo.repositories.CategoryRepository;
import com.merceariaweb.demo.repositories.OrderItemRepository;
import com.merceariaweb.demo.repositories.OrderRepository;
import com.merceariaweb.demo.repositories.ProductRepository;
import com.merceariaweb.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Armas e Armaduras"); 
		Category cat2 = new Category(null, "Tomos"); 
		Category cat3 = new Category(null, "Comidas da Comarca");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Product p1 = new Product(null, "Espada Andúril", "A espada reforjada de Elendil, brandida por Aragorn.", 1250.0, ""); 
		Product p2 = new Product(null, "Armadura Élfica", "Proteção leve e resistente dos elfos de Lothlórien.", 1200.0, ""); 
		Product p3 = new Product(null, "Palantír", "Pedra vidente usada para comunicação e vigilância.", 2190.0, ""); 
		Product p4 = new Product(null, "O Silmarillion", "Os antigos escritos que narram a criação da Terra Média.", 90.5, ""); 
		Product p5 = new Product(null, "Pão da Comarca", "Pão caseiro típico dos hobbits, saboroso e rústico.", 10.99, ""); 
		Product p6 = new Product(null, "Cerveja do Condado", "Bebida típica dos hobbits para celebrar grandes festas.", 15.99, "");
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
		
		p1.getCategories().add(cat1);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat2);
		p4.getCategories().add(cat2);
		p5.getCategories().add(cat3);
		p6.getCategories().add(cat3); 
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
		
		
		User u1 = new User(null, "Feanor", "feanor@gmail.com", "955555555", "123456"); 
		User u2 = new User(null, "Fingolfin", "fingolfin@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"),OrderStatus.PAID,u1);
		Order o2 = new Order(null, Instant.parse("2025-07-21T03:42:10Z"),OrderStatus.CANCELED, u2);
		Order o3 = new Order(null, Instant.parse("2025-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 1, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p5, 3, p5.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 1, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p6, 4, p6.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
	}
	
}
