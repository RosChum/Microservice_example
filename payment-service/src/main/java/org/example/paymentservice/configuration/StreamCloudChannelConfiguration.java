package org.example.paymentservice.configuration;

import lombok.RequiredArgsConstructor;
import org.example.paymentservice.event_for_sream_cloud.EventHandler;
import org.example.paymentservice.event_for_sream_cloud.OrderPurchaseEvent;
import org.example.paymentservice.event_for_sream_cloud.PaymentEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@RequiredArgsConstructor
public class StreamCloudChannelConfiguration {


    private final EventHandler<OrderPurchaseEvent, PaymentEvent> orderPurchaseEventHandler;



    @Bean
    public Function<OrderPurchaseEvent, PaymentEvent> orderPurchaseEventProcess() {
        return orderPurchaseEventHandler::handle;
    }


}
