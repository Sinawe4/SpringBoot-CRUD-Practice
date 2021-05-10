package com.example.member.advice.exception;

public class UserAlreadtExistsException extends RuntimeException{
    public UserAlreadtExistsException(String msg, Throwable t){
        super(msg,t);
    }
    public UserAlreadtExistsException(String msg){
        super(msg);
    }
    public UserAlreadtExistsException(){
        super();
    }
}
