package org.example.paymentservice.event_hendler.stream_cloud_channel;

import org.springframework.messaging.MessageChannel;

public interface PaymentChannel {

    String OUTPUT = "paymentsEventOut";


    MessageChannel output();
}
