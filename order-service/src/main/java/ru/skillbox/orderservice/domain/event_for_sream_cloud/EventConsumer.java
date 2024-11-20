package ru.skillbox.orderservice.domain.event_for_sream_cloud;

public interface EventConsumer<T extends Event> {

    void consume(T event);
}
