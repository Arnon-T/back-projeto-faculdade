package com.faculdade.faculdade.nota;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotaNaoEncontradaException extends Exception {
    public NotaNaoEncontradaException(String message) {
        super(message);
    }
}
