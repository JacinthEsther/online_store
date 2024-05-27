package com.jacinth.online_bookstore.exceptions;

public class InvalidUsernameException extends RuntimeException{
    public InvalidUsernameException(String message){
        super(message);

    }
}
