package com.aglcropsystem.exceptions;

public class FarmerNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    
    public FarmerNotFoundException(String message) {
        super(message);
    }
}