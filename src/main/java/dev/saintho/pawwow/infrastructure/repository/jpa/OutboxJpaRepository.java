package dev.saintho.pawwow.infrastructure.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import dev.saintho.pawwow.domain.model.Outbox;

public interface OutboxJpaRepository extends CrudRepository<Outbox, Long> {
}
