package dev.saintho.pawwow.domain.repository.write;

import java.util.Optional;

import dev.saintho.pawwow.domain.model.Pet;

public interface PetWriteRepository {
	Optional<Pet> findById(Long id);
}
