package dev.saintho.pawwow.presentation.dto.response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import dev.saintho.pawwow.domain.exception.DomainException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {
	private String message;
	private List<FieldErrorResponse> fieldErrors;

	public static ErrorResponse from(DomainException domainException) {
		ErrorResponse response = new ErrorResponse();

		response.message = domainException.getMessage();
		response.fieldErrors = new ArrayList<>();

		return null;
	}

	public static ErrorResponse from(MethodArgumentNotValidException validationError) {
		ErrorResponse response = new ErrorResponse();

		response.message = "VALIDATION_FAILED";
		response.fieldErrors = validationError.getBindingResult().getFieldErrors()
			.stream()
			.map(FieldErrorResponse::from)
			.collect(Collectors.toList());

		return response;
	}

	public String getMessage() {
		return message;
	}

	public List<FieldErrorResponse> getFieldErrors() {
		return Collections.unmodifiableList(fieldErrors);
	}

	@Getter
	public static class FieldErrorResponse {
		private String field;
		private String value;
		private String reason;

		public static FieldErrorResponse from(FieldError fieldError) {
			FieldErrorResponse response = new FieldErrorResponse();

			response.field = fieldError.getField();
			response.value = String.valueOf(fieldError.getRejectedValue());
			response.reason = fieldError.getDefaultMessage();

			return response;
		}
	}
}
