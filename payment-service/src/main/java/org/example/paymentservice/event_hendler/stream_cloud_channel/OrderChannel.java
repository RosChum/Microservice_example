package org.example.paymentservice.event_hendler.stream_cloud_channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface OrderChannel {

    String OUTPUT = "orderEventOut"; //
    String INPUT = "orderEventIn";

    @Output(OUTPUT)
    MessageChannel output();

    @Input(INPUT)
    SubscribableChannel input();
}
