package org.example.inventoryservice.event_for_sream_cloud;

import lombok.Builder;
import lombok.Data;
import org.example.inventoryservice.dto.OrderStatus;


@Data
@Builder
public class OrderPurchaseEvent implements Event {

    private Long orderId;

    private Long userId;

    private Double cost;

    private OrderStatus status;


}
