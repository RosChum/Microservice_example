package ru.skillbox.orderservice.domain.event_for_sream_cloud;

public interface EventProducer <T extends Event>{

    T getEvent();
}
