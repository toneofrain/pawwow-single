package dev.saintho.pawwow.presentation.dto.response;

import dev.saintho.pawwow.domain.dto.result.PetVoteResult;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PetVoteResponse {
	private Long petId;
	private String email;

	public static PetVoteResponse from(PetVoteResult result) {
		PetVoteResponse response = new PetVoteResponse();

		response.petId = result.getPetId();
		response.email = result.getVoter();

		return response;
	}
}
