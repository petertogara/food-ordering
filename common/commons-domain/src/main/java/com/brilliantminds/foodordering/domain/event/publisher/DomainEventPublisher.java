package com.brilliantminds.foodordering.domain.event.publisher;

import com.brilliantminds.foodordering.domain.event.DomainEvent;

public interface DomainEventPublisher <T extends DomainEvent> {

    void publish(T domainEvent);
}
