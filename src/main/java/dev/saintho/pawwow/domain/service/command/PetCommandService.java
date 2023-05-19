package dev.saintho.pawwow.domain.service.command;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.saintho.pawwow.domain.dto.command.PetVoteCommand;
import dev.saintho.pawwow.domain.dto.result.PetVoteResult;
import dev.saintho.pawwow.domain.repository.write.PetWriteRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PetCommandService {
	private final PetWriteRepository petWriteRepository;

	public PetVoteResult voteOrCancelIfPetVoteExist(PetVoteCommand petVoteCommand) {
		return null;
	}
}
