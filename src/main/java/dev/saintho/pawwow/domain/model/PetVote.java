package dev.saintho.pawwow.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.StringUtils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PetVote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, updatable = false)
	private String voter;
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

	public Long getPetId() {
		return pet.getId();
	}

	public static PetVote Of(Pet pet, String voter) {
		validateVoter(voter);
		validatePet(pet);

		PetVote petVote = new PetVote();
		petVote.voter = voter;
		petVote.pet = pet;

		return petVote;
	}

	private static void validateVoter(String voter) {
		if (!StringUtils.hasText(voter) || voter.length() > 255) {
			throw new IllegalArgumentException("Voter Must Be A Email Address With A Length Less Than 256");
		}
	}

	private static void validatePet(Pet pet) {
		if (pet == null || !pet.hasId()) {
			throw new IllegalArgumentException("Pet Must Be A Non Null Entity With A Non Null Id");
		}
	}
}
