package ru.skillbox.orderservice.domain.event_for_sream_cloud;

import lombok.Builder;
import lombok.Data;
import ru.skillbox.orderservice.domain.OrderStatus;

@Data
@Builder
public class OrderPurchaseEvent implements Event {

    private Long orderId;

    private Long userId;

    private Long cost;

    private OrderStatus status;


}
