package com.neoteric.fullstackdemo_31082024.Exception;

public class AtmCreationFailedException extends Exception{
    public  String message;
    public  AtmCreationFailedException(String msg){
        this.message=msg;
    }
}

