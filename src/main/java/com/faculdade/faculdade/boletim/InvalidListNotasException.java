package com.faculdade.faculdade.boletim;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidListNotasException extends Exception {
    public InvalidListNotasException(String message) {
        super(message);
    }
}
