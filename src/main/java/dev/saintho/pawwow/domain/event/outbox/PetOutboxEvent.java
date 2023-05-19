package dev.saintho.pawwow.domain.event.outbox;

import lombok.Builder;

public class PetOutboxEvent implements Outboxable {
	private final Long aggregateId;
	private final OutboxEventType type;
	private final Object subject;

	@Builder
	private PetOutboxEvent(Long aggregateId, OutboxEventType type, Object subject) {
		this.aggregateId = aggregateId;
		this.type = type;
		this.subject = subject;
	}

	@Override
	public AggregateType getAggregateType() {
		return AggregateType.PET;
	}

	@Override
	public Long getAggregateId() {
		return aggregateId;
	}

	@Override
	public OutboxEventType getType() {
		return type;
	}

	@Override
	public String getPayLoad() {
		return subject.toString();
	}
}