package ru.skillbox.orderservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.skillbox.orderservice.domain.event_for_sream_cloud.EventProducer;
import ru.skillbox.orderservice.domain.event_for_sream_cloud.OrderPurchaseEvent;

import java.util.function.Supplier;

@Configuration
public class OrderServiceConfiguration {

    @Autowired
    EventProducer<OrderPurchaseEvent> orderPurchaseEventProducer;

    @Bean
    public Supplier<OrderPurchaseEvent> ordersEventProducer() {
        return orderPurchaseEventProducer::getEvent;
    }

}
