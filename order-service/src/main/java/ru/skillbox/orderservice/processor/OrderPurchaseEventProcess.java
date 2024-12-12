package ru.skillbox.orderservice.processor;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import ru.skillbox.orderservice.domain.Order;
import ru.skillbox.orderservice.domain.event_for_sream_cloud.OrderPurchaseEvent;
import ru.skillbox.orderservice.processor.stream_cloud_channel.OrderChannel;

@Component
@Getter
@EnableBinding(OrderChannel.class)
@Slf4j
public class OrderPurchaseEventProcess {

    @Autowired
    private OrderChannel orderChannel;


    public void process(Order order) {
        OrderPurchaseEvent orderPurchaseEvent = OrderPurchaseEvent.builder()
                .orderId(order.getId())
                .cost(Double.valueOf(order.getCost()))
                .status(order.getStatus())
                .userId(null).build();

        orderChannel.output().send(MessageBuilder.withPayload(orderPurchaseEvent).build());

        log.info("OrderPurchaseEventProcess  process ====>>> {}",orderPurchaseEvent);
    }


}
