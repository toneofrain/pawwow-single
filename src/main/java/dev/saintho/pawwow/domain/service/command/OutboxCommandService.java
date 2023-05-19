package dev.saintho.pawwow.domain.service.command;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.saintho.pawwow.domain.event.outbox.Outboxable;
import dev.saintho.pawwow.domain.model.Outbox;
import dev.saintho.pawwow.domain.repository.write.OutboxWriteRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OutboxCommandService {
	private final OutboxWriteRepository outboxWriteRepository;
	private final ObjectMapper objectMapper;

	public void create(Outboxable event) {
		try {
			final String payload = objectMapper.writeValueAsString(event.getSubject());

			outboxWriteRepository.save(
				Outbox.of(event, payload));

		} catch (JsonProcessingException ignored) {}
	}
}
