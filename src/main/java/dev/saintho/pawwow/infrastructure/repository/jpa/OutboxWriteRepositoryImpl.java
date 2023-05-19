package dev.saintho.pawwow.infrastructure.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.saintho.pawwow.domain.model.Outbox;
import dev.saintho.pawwow.domain.repository.write.OutboxWriteRepository;
import lombok.RequiredArgsConstructor;

@Repository
@Transactional
@RequiredArgsConstructor
public class OutboxWriteRepositoryImpl implements OutboxWriteRepository {
	private final OutboxJpaRepository outboxJpaRepository;
	@Override
	public void save(Outbox outbox) {
		outboxJpaRepository.save(outbox);
	}
}
