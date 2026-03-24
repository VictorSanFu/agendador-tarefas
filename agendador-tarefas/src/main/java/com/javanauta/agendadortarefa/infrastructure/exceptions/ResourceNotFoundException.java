package com.javanauta.agendadortarefa.infrastructure.exceptions;

import javax.swing.plaf.basic.BasicTreeUI;

public class ResourceNotFoundException extends  RuntimeException{
    public ResourceNotFoundException(String mensagem){
        super(mensagem);
    }

    public ResourceNotFoundException(String mensagem, Throwable throwable){
        super(mensagem, throwable);
    }

}
