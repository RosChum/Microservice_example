package org.example.paymentservice.event_hendler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.paymentservice.domain.UserBalance;
import org.example.paymentservice.dto.OrderStatus;
import org.example.paymentservice.event_for_sream_cloud.EventHandler;
import org.example.paymentservice.event_for_sream_cloud.OrderPurchaseEvent;
import org.example.paymentservice.event_for_sream_cloud.PaymentEvent;
import org.example.paymentservice.event_hendler.stream_cloud_channel.OrderChannel;
import org.example.paymentservice.event_hendler.stream_cloud_channel.PaymentChannel;
import org.example.paymentservice.exception.UserBalanceException;
import org.example.paymentservice.repository.UserBalanceRepository;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
@Slf4j
@EnableBinding({OrderChannel.class, PaymentChannel.class})
public class OrderPurchaseEventHandler implements EventHandler<OrderPurchaseEvent, PaymentEvent> {

    private final UserBalanceRepository userBalanceRepository;

    @Transactional
    @Override
    @StreamListener(OrderChannel.INPUT)
    @SendTo(PaymentChannel.OUTPUT)
    public PaymentEvent handle(@Payload OrderPurchaseEvent event) {


        log.info("Start process OrderPurchaseEventHandler handle =======>>>>>> {}", event);

        System.out.println(" УРАААААААААААААААААААААА!!!!!!!!!!!!");

        UserBalance userBalance = userBalanceRepository.findByUserId(event.getUserId()).orElseThrow(() -> new UserBalanceException("UserBalance not found"));

        PaymentEvent paymentEvent = new PaymentEvent();

        if (checkBalanceForPayment(event.getCost(), userBalance.getBalance())) {

            userBalance.setBalance(userBalance.getBalance() - event.getCost());
            userBalanceRepository.save(userBalance);

            paymentEvent.setStatus(OrderStatus.PAID);
            paymentEvent.setOrderId(event.getOrderId());
            paymentEvent.setUserId(event.getUserId());

        }

        log.info("OrderPurchaseEventHandler handle =======>>>>>> {}", paymentEvent);
        return paymentEvent;
    }


    private boolean checkBalanceForPayment(Double cost, Double balance) {
        return balance >= cost;

    }

}
