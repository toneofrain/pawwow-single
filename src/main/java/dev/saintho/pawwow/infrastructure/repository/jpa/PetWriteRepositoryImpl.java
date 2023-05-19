package dev.saintho.pawwow.infrastructure.repository.jpa;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.saintho.pawwow.domain.model.Pet;
import dev.saintho.pawwow.domain.repository.write.PetWriteRepository;
import lombok.RequiredArgsConstructor;

@Repository
@Transactional
@RequiredArgsConstructor
public class PetWriteRepositoryImpl implements PetWriteRepository {
	private final PetJpaRepository petJpaRepository;

	@Override
	public Optional<Pet> findById(Long id) {
		return petJpaRepository.findById(id);
	}
}
