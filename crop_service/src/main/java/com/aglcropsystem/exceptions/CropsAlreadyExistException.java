package com.aglcropsystem.exceptions;

public class CropsAlreadyExistException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    
    public CropsAlreadyExistException(String message) {
        super(message);
    }
}