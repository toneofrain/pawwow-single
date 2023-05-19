package dev.saintho.pawwow.domain.dto.result;

import lombok.Getter;

@Getter
public class PetVoteResult {
	private Long petVoteId;
	private Long petId;
	private String voter;
}
