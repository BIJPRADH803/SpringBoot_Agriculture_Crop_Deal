package com.aglcropsystem.exceptions;

public class DealerAlreadyExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DealerAlreadyExistException(String msg) {
		super(msg);
	}

}