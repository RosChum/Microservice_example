package org.example.paymentservice.event_hendler.stream_cloud_channel;

import org.springframework.messaging.SubscribableChannel;

public interface OrderChannel {

    String INPUT = "orderEventIn";


    SubscribableChannel input();
}
