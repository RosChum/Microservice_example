package ru.skillbox.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.skillbox.orderservice.domain.event_for_sream_cloud.OrderPurchaseEvent;
import ru.skillbox.orderservice.processor.OrderPurchaseEventProcess;

import java.util.function.Supplier;

@Configuration
public class StreamCloudChannelConfiguration {

    OrderPurchaseEventProcess orderPurchaseEventProcess;

    @Bean
    public Supplier<OrderPurchaseEvent> orderPurchaseEvent() {
        return () -> {
            return null;

        };

    }


}
