package com.aglcropsystem.exceptions;

public class DealerNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    
    public DealerNotFoundException(String message) {
        super(message);
    }
}