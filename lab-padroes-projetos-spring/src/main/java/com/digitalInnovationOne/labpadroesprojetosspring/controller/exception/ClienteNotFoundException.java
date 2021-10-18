package com.digitalInnovationOne.labpadroesprojetosspring.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNotFoundException extends Exception {
    public ClienteNotFoundException(Long id){
        super("Não foi possível entrar o cliente de id: " + id);
    }
}
