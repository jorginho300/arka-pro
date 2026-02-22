package com.arkapro.core.ports.events;

public interface DomainEventPublisher {
	void publish(Object event);
}
