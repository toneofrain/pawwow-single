package dev.saintho.pawwow.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.saintho.pawwow.domain.dto.command.PetVoteCommand;
import dev.saintho.pawwow.domain.dto.result.PetVoteResult;
import dev.saintho.pawwow.domain.service.command.PetCommandService;
import dev.saintho.pawwow.presentation.dto.request.PetVoteRequest;
import dev.saintho.pawwow.presentation.dto.response.PetVoteResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
public class PetCommandController {
	private final PetCommandService petCommandService;

	@PostMapping("/{petId:[0-9]+}/vote")
	public ResponseEntity<PetVoteResponse> voteOrCancel(@PathVariable Long petId, @RequestBody PetVoteRequest request) {
		PetVoteResult result = petCommandService.voteOrCancelIfPetVoteExist(
			PetVoteCommand.of(petId, request.getEmail()));

		return ResponseEntity.ok(
			PetVoteResponse.from(result));
	}
}
