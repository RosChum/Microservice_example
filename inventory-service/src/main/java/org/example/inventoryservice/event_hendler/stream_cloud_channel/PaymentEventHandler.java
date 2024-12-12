package org.example.inventoryservice.event_hendler.stream_cloud_channel;

import lombok.extern.slf4j.Slf4j;
import org.example.inventoryservice.event_for_sream_cloud.DeliveryEvent;
import org.example.inventoryservice.event_for_sream_cloud.EventHandler;
import org.example.inventoryservice.event_for_sream_cloud.PaymentEvent;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@EnableBinding({PaymentChannel.class, DeliveryChannel.class})
public class PaymentEventHandler implements EventHandler<PaymentEvent, DeliveryEvent> {


    @Transactional
    @StreamListener(PaymentChannel.INPUT)
    @Override
    @SendTo(DeliveryChannel.OUTPUT)
    public DeliveryEvent handle(@Payload PaymentEvent event) {

        log.info("PaymentEventHandler handle {} ", event);

        return new DeliveryEvent();
    }
}
