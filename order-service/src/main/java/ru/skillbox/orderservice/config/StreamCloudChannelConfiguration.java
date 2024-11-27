package ru.skillbox.orderservice.config;

import ru.skillbox.orderservice.processor.OrderPurchaseEventProcess;

//@Configuration
public class StreamCloudChannelConfiguration {

    OrderPurchaseEventProcess orderPurchaseEventProcess;

//    @Bean
//    public Supplier<OrderPurchaseEvent> orderPurchaseEvent() {
//        return () -> {
//            return null;
//
//        };
//
//    }


}
