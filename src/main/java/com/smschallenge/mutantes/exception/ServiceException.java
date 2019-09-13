package com.smschallenge.mutantes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Bad Request!")
public class ServiceException extends Exception {

    public ServiceException() {
        super();
    }

}
