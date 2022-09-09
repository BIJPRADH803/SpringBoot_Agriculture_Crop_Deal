package com.aglcropsystem.exceptions;

public class CropsAlreadyExistException extends RuntimeException {

	public CropsAlreadyExistException() {
		super();

	}

	public CropsAlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public CropsAlreadyExistException(String message, Throwable cause) {
		super(message, cause);

	}

	public CropsAlreadyExistException(String message) {
		super(message);

	}

	public CropsAlreadyExistException(Throwable cause) {
		super(cause);

	}

}