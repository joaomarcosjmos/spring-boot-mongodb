package com.projeto.springmongo.services.exception;

public class ObjectNotFoundException  extends RuntimeException{

    public ObjectNotFoundException(String msg){
        super(msg);
    }

}
