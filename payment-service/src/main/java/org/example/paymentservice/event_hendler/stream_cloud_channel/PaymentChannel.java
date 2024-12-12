package org.example.paymentservice.event_hendler.stream_cloud_channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PaymentChannel {
    String OUTPUT = "paymentsEventOut";
    String INPUT = "paymentsEventIn";

    @Input(INPUT)
    SubscribableChannel paymentsEventOut();

    @Output(OUTPUT)
    MessageChannel output();
}
