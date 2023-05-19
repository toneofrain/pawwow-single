package dev.saintho.pawwow.domain.service.command;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.saintho.pawwow.domain.repository.write.PetVoteWriteRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PetVoteCommandService {
	private final PetVoteWriteRepository petVoteWriteRepository;

}
