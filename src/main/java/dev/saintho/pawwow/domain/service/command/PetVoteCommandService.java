package dev.saintho.pawwow.domain.service.command;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.saintho.pawwow.domain.model.Pet;
import dev.saintho.pawwow.domain.model.PetVote;
import dev.saintho.pawwow.domain.repository.write.PetVoteWriteRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PetVoteCommandService {
	private final PetVoteWriteRepository petVoteWriteRepository;

	public PetVote createOrDeleteIfExist(Pet pet, String voter) {

		return petVoteWriteRepository.findByPetAndVoter(pet, voter)
			.map(this::delete)
			.orElseGet(() -> create(pet, voter));
	}

	private PetVote create(Pet pet, String voter) {

		return petVoteWriteRepository.save(
			PetVote.Of(pet, voter));
	}

	private PetVote delete(PetVote petVote) {
		petVoteWriteRepository.delete(petVote);

		return petVote;
	}
}
