package com.aglcropsystem.exceptions;
public class CropsNotFoundException extends RuntimeException {

	public CropsNotFoundException() {
		super();

	}

	public CropsNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public CropsNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public CropsNotFoundException(String message) {
		super(message);

	}

	public CropsNotFoundException(Throwable cause) {
		super(cause);

	}

}