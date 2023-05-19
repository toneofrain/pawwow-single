package dev.saintho.pawwow.domain.service.command;

import static dev.saintho.pawwow.domain.event.outbox.OutboxEventType.PET_VOTE_CREATE;
import static dev.saintho.pawwow.domain.exception.ExceptionCode.PET_NOT_FOUND;

import java.util.Optional;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.saintho.pawwow.domain.dto.command.PetVoteCommand;
import dev.saintho.pawwow.domain.dto.result.PetVoteResult;
import dev.saintho.pawwow.domain.event.outbox.PetOutboxEvent;
import dev.saintho.pawwow.domain.exception.DomainException;
import dev.saintho.pawwow.domain.model.Pet;
import dev.saintho.pawwow.domain.model.PetVote;
import dev.saintho.pawwow.domain.repository.write.PetWriteRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PetCommandService {
	private final PetWriteRepository petWriteRepository;
	private final PetVoteCommandService petVoteCommandService;
	private final ApplicationEventPublisher eventPublisher;

	@Transactional(readOnly = true)
	public Pet findVerifiedById(Long id) {
		Optional<Pet> petOptional = petWriteRepository.findById(id);

		return petOptional
			.orElseThrow(() -> new DomainException(PET_NOT_FOUND));
	}

	public PetVoteResult voteOrCancelIfPetVoteExist(PetVoteCommand petVoteCommand) {
		Pet verified = findVerifiedById(petVoteCommand.getPetId());

		PetVote petVote = petVoteCommandService.createOrDeleteIfExist(verified, petVoteCommand.getVoter());


		eventPublisher.publishEvent(
			PetOutboxEvent.builder()
				.aggregateId(petVote.getPetId())
				.type(PET_VOTE_CREATE)
				.subject(petVote)
				.build()
			);

		return PetVoteResult.from(petVote);
	}
}
