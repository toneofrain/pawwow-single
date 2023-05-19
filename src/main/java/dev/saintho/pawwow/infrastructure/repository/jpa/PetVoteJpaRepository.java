package dev.saintho.pawwow.infrastructure.repository.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.saintho.pawwow.domain.model.Pet;
import dev.saintho.pawwow.domain.model.PetVote;

public interface PetVoteJpaRepository extends JpaRepository<PetVote, Long> {
	Optional<PetVote> findByPetAndVoter(Pet pet, String voter);
}
