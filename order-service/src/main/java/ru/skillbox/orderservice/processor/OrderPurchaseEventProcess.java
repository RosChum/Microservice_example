package ru.skillbox.orderservice.processor;

import org.springframework.stereotype.Component;
import ru.skillbox.orderservice.domain.Order;
import ru.skillbox.orderservice.domain.event_for_sream_cloud.OrderPurchaseEvent;

@Component
public class OrderPurchaseEventProcess {

    public OrderPurchaseEvent getOrderPurchaseEvent(Order order) {
        return OrderPurchaseEvent.builder()
                .orderId(order.getId())
                .cost(order.getCost())
                .status(order.getStatus())
                .userId(null).build();


    }


}
