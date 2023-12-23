package com.dians.museumapi.models.exception;

public class InvalidArgumentException extends RuntimeException{
    public InvalidArgumentException() {
        super("Invalid argument.");
    }
}
