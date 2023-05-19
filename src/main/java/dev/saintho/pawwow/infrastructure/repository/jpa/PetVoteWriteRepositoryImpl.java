package dev.saintho.pawwow.infrastructure.repository.jpa;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dev.saintho.pawwow.domain.repository.write.PetVoteWriteRepository;
import lombok.RequiredArgsConstructor;

@Repository
@Transactional
@RequiredArgsConstructor
public class PetVoteWriteRepositoryImpl implements PetVoteWriteRepository {
	private final PetVoteJpaRepository petVoteJpaRepository;
}
