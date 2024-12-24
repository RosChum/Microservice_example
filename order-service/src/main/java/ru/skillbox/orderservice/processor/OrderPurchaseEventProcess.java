package ru.skillbox.orderservice.processor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;
import ru.skillbox.orderservice.domain.Order;
import ru.skillbox.orderservice.domain.event_for_sream_cloud.EventProducer;
import ru.skillbox.orderservice.domain.event_for_sream_cloud.OrderPurchaseEvent;

@Component
@Getter
@Slf4j
@RequiredArgsConstructor
public class OrderPurchaseEventProcess implements EventProducer<OrderPurchaseEvent> {


    private final StreamBridge streamBridge;
    private OrderPurchaseEvent orderPurchaseEvent;

    @Override
    public OrderPurchaseEvent getEvent() {
        log.info("OrderPurchaseEventProcess  getEvent ====>>> {}", orderPurchaseEvent);
        return orderPurchaseEvent;
    }

    public void process(Order order) {
        this.orderPurchaseEvent = OrderPurchaseEvent.builder()
                .orderId(order.getId())
                .cost(Double.valueOf(order.getCost()))
                .status(order.getStatus())
                .userId(null).build();

        streamBridge.send("ordersEventProducer-out-0", orderPurchaseEvent);

        log.info("OrderPurchaseEventProcess  process ====>>> {}", orderPurchaseEvent);
    }


}
