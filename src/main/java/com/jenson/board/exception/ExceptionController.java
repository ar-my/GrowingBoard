package com.jenson.board.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.NoResultException;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NoResultException.class)
    public ResponseEntity noResultExceptionHandler(NoResultException e) {
        log.debug(e.getMessage());
        return ResponseEntity.noContent().build();
    }
}


