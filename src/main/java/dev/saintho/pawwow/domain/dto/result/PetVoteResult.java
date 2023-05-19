package dev.saintho.pawwow.domain.dto.result;

import dev.saintho.pawwow.domain.model.PetVote;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PetVoteResult {
	private Long petVoteId;
	private Long petId;
	private String voter;

	public static PetVoteResult from(PetVote petVote) {
		PetVoteResult result = new PetVoteResult();

		result.petVoteId = petVote.getId();
		result.petId = petVote.getPetId();
		result.voter = petVote.getVoter();

		return result;
	}
}
