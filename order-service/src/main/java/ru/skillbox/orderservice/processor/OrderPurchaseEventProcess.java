package ru.skillbox.orderservice.processor;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;
import ru.skillbox.orderservice.domain.Order;
import ru.skillbox.orderservice.domain.event_for_sream_cloud.OrderPurchaseEvent;

@Component
@Getter
public class OrderPurchaseEventProcess {

    @Autowired
    private StreamBridge streamBridge;


    public void getOrderPurchaseEvent(Order order) {
        OrderPurchaseEvent orderPurchaseEvent =  OrderPurchaseEvent.builder()
                .orderId(order.getId())
                .cost(Double.valueOf(order.getCost()))
                .status(order.getStatus())
                .userId(null).build();

         streamBridge.send("orderPurchaseEvent-out-0", orderPurchaseEvent);

    }


}
