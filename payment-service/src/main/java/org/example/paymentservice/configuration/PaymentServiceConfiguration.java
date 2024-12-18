package org.example.paymentservice.configuration;

import org.example.paymentservice.event_for_sream_cloud.EventHandler;
import org.example.paymentservice.event_for_sream_cloud.OrderPurchaseEvent;
import org.example.paymentservice.event_for_sream_cloud.PaymentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class PaymentServiceConfiguration {

    @Autowired
    EventHandler<OrderPurchaseEvent, PaymentEvent> orderPurchaseEventHandler;

    @Bean
    public Function<OrderPurchaseEvent, PaymentEvent> orderEventProcess() {
        return orderPurchaseEventHandler::handle;

    }

}
