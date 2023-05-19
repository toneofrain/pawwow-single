package dev.saintho.pawwow.domain.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ExceptionCode {
	PET_NOT_FOUND(404, "PET_NOT_FOUND");

	private final int statusCode;
	private final String defaultMessage;
}
