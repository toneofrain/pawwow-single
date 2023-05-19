package dev.saintho.pawwow.domain.event.outbox;

public interface Outboxable {
	AggregateType getAggregateType();
	Long getAggregateId();
	OutboxEventType getType();
	Object getSubject();
}
