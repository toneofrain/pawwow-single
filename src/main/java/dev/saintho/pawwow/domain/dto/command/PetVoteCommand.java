package dev.saintho.pawwow.domain.dto.command;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PetVoteCommand {
	private Long petId;
	private String voter;

	public static PetVoteCommand of(Long petId, String email) {
		PetVoteCommand command = new PetVoteCommand();

		command.petId = petId;
		command.voter = email;

		return command;
	}
}
