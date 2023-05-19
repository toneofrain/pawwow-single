package dev.saintho.pawwow.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.saintho.pawwow.domain.exception.DomainException;
import dev.saintho.pawwow.presentation.dto.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionAdvice {
	@ExceptionHandler(DomainException.class)
	public ResponseEntity<ErrorResponse> handleDomainException(DomainException domainError) {
		ErrorResponse response = ErrorResponse.from(domainError);

		return ResponseEntity
			.status(domainError.getCode().getStatusCode())
			.body(response);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
		MethodArgumentNotValidException validationError) {

		ErrorResponse response = ErrorResponse.from(validationError);

		return ResponseEntity
			.badRequest()
			.body(response);
	}
}
