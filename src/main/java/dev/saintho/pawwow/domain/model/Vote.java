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
public class Vote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, updatable = false)
	private String voter;
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

	public static Vote Of(String voter, Pet pet) {
		validateVoter(voter);
		validatePet(pet);

		Vote vote = new Vote();
		vote.voter = voter;
		vote.pet = pet;

		return vote;
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
