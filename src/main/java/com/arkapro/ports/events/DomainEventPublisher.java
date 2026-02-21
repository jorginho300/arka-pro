package com.arkapro.ports.events;

public interface DomainEventPublisher {
	void publish(Object event);
}
