package com.smschallenge.mutantes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "No se reconoce Adn Mutante")
public class MutanteException extends Exception {

    public MutanteException() {
        super();
    }

}
