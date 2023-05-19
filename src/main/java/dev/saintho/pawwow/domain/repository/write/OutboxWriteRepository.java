package dev.saintho.pawwow.domain.repository.write;

import dev.saintho.pawwow.domain.model.Outbox;

public interface OutboxWriteRepository {
	void save(Outbox outbox);
}
