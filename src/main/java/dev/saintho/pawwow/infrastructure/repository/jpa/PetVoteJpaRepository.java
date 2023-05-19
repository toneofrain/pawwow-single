package dev.saintho.pawwow.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.saintho.pawwow.domain.model.PetVote;

public interface PetVoteJpaRepository extends JpaRepository<PetVote, Long> {
}
