package com.example.LibrarySpringBoot.exception;

public class InvalidIdException extends RuntimeException{

    public InvalidIdException(String message){
        super(message);
    }
}
