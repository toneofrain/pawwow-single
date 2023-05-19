package dev.saintho.pawwow.infrastructure.repository.jpa;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.saintho.pawwow.domain.model.Pet;
import dev.saintho.pawwow.domain.model.PetVote;
import dev.saintho.pawwow.domain.repository.write.PetVoteWriteRepository;
import lombok.RequiredArgsConstructor;

@Repository
@Transactional
@RequiredArgsConstructor
public class PetVoteWriteRepositoryImpl implements PetVoteWriteRepository {
	private final PetVoteJpaRepository petVoteJpaRepository;

	@Override
	@Transactional(readOnly = true)
	public Optional<PetVote> findByPetAndVoter(Pet pet, String voter) {
		return petVoteJpaRepository.findByPetAndVoter(pet, voter);
	}

	@Override
	public PetVote save(PetVote petVote) {
		return petVoteJpaRepository.save(petVote);
	}

	@Override
	public void delete(PetVote petVote) {
		petVoteJpaRepository.delete(petVote);
	}
}
