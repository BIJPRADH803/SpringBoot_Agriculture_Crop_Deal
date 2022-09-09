package com.aglcropsystem.exceptions;

public class CropsNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    
    public CropsNotFoundException(String message) {
        super(message);
    }
}