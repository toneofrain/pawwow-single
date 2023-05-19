package dev.saintho.pawwow.infrastructure.repository.jpa;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dev.saintho.pawwow.domain.repository.write.PetWriteRepository;
import lombok.RequiredArgsConstructor;

@Repository
@Transactional
@RequiredArgsConstructor
public class PetWriteRepositoryImpl implements PetWriteRepository {
	private final PetJpaRepository petJpaRepository;
}
