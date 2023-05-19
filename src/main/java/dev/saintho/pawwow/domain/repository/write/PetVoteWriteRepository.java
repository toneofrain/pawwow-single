package dev.saintho.pawwow.domain.repository.write;

import java.util.Optional;

import dev.saintho.pawwow.domain.model.Pet;
import dev.saintho.pawwow.domain.model.PetVote;

public interface PetVoteWriteRepository {
	Optional<PetVote> findByPetAndVoter(Pet pet, String voter);

	PetVote save(PetVote petVote);

	void delete(PetVote petVote);
}
