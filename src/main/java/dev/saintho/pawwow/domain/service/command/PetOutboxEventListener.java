package dev.saintho.pawwow.domain.service.command;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import dev.saintho.pawwow.domain.event.outbox.OutboxableListener;
import dev.saintho.pawwow.domain.event.outbox.PetOutboxEvent;

@Service
public class PetOutboxEventListener extends OutboxableListener<PetOutboxEvent> {
	public PetOutboxEventListener(OutboxCommandService outboxCommandService) {
		super(outboxCommandService);
	}

	@Override
	@EventListener(PetOutboxEvent.class)
	public void handle(PetOutboxEvent event) {
		createOutboxEntity(event);
	}
}
