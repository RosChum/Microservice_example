package ru.skillbox.orderservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.skillbox.orderservice.domain.event_for_sream_cloud.OrderPurchaseEvent;
import ru.skillbox.orderservice.processor.OrderPurchaseEventProcess;

@Configuration
public class StreamCloudChannelConfiguration {

    @Autowired
    OrderPurchaseEventProcess orderPurchaseEventProcess;

    @Bean
    public OrderPurchaseEvent orderPurchaseEvent() {
        return orderPurchaseEventProcess::getOrderPurchaseEvent;

    }


}
