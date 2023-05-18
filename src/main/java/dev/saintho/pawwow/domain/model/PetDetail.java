package dev.saintho.pawwow.domain.model;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Getter;

@RedisHash
@Getter
public class PetDetail {
	@Id
	private Long petId;
	@Indexed
	private String name;
	private String profileImage;
	private String briefDescription;
	private String detailDescription;
	private String type;
	@Indexed
	private String voteCount;
	private Set<String> voters;
}
