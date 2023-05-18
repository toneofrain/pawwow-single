package dev.saintho.pawwow.domain.event;

import java.time.LocalDateTime;

public interface Outboxable {
	AggregateType getAggregateType();
	Long getAggregateId();
	OutboxEventType getType();
	String getPayLoad();
}
