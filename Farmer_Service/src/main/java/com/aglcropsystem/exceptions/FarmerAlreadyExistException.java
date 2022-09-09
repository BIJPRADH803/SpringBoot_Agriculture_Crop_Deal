package com.aglcropsystem.exceptions;

public class FarmerAlreadyExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FarmerAlreadyExistException(String msg) {
		super(msg);
	}

}