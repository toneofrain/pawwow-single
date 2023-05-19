package dev.saintho.pawwow.domain.event.outbox;

import dev.saintho.pawwow.domain.service.command.OutboxCommandService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class OutboxableListener<T extends Outboxable> {
	private final OutboxCommandService outboxCommandService;
	public abstract void handle(T event);

	protected void createOutboxEntity(T event) {
		outboxCommandService.create(event);
	}
}
