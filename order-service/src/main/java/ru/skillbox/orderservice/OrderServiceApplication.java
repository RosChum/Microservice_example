package ru.skillbox.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories
public class OrderServiceApplication {

	//TODO своя база данных для pymentService, проверка отправки и приема сообщений в кафку между orderService и  paymentService

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
