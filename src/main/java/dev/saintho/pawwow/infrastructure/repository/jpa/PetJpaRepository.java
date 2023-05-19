package dev.saintho.pawwow.infrastructure.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import dev.saintho.pawwow.domain.model.Pet;

public interface PetJpaRepository extends CrudRepository<Pet, Long> {
}
