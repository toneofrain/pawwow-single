package dev.saintho.pawwow.domain.exception;

import lombok.Getter;

@Getter
public class DomainException extends RuntimeException {
	private final ExceptionCode code;

	public DomainException(ExceptionCode code) {
		this.code = code;
	}

	public DomainException(String message, ExceptionCode code) {
		super(message);
		this.code = code;
	}

	public DomainException(String message, Throwable cause, ExceptionCode code) {
		super(message, cause);
		this.code = code;
	}

	public DomainException(Throwable cause, ExceptionCode code) {
		super(cause);
		this.code = code;
	}
}
