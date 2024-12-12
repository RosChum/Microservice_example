package org.example.inventoryservice.event_for_sream_cloud;



public interface EventHandler<T extends Event, R extends Event> {

    R handle(T event);
}
