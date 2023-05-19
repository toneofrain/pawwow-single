package dev.saintho.pawwow.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import dev.saintho.pawwow.domain.event.outbox.AggregateType;
import dev.saintho.pawwow.domain.event.outbox.OutboxEventType;
import dev.saintho.pawwow.domain.event.outbox.Outboxable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Outbox {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, updatable = false)
	@Enumerated(EnumType.STRING)
	private AggregateType aggregateType;
	@Column(nullable = false, updatable = false)
	private Long aggregateId;
	@Column(nullable = false, updatable = false)
	@Enumerated(EnumType.STRING)
	private OutboxEventType eventType;
	@Column(columnDefinition = "TEXT", nullable = false, updatable = false)
	private String payLoad;
	@CreatedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime occurredAt;

	public static Outbox of(Outboxable event, String payLoad) {
		Outbox outbox = new Outbox();

		outbox.aggregateType = event.getAggregateType();
		outbox.aggregateId = event.getAggregateId();
		outbox.eventType = event.getType();
		outbox.payLoad = payLoad;

		return outbox;
	}
}
