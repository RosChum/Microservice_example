package org.example.inventoryservice.event_for_sream_cloud;

import lombok.Data;
import org.example.inventoryservice.dto.OrderStatus;


@Data
public class PaymentEvent implements Event {

    private Long orderId;

    private Long userId;

    private OrderStatus status;

}
