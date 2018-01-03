package com.adams.cursomc.resources.exceptions;

import com.adams.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(
      ObjectNotFoundException e, HttpServletRequest request) {
    final StandardError standardError =
        StandardError.builder()
            .status(HttpStatus.NOT_FOUND.value())
            .msg(e.getMessage())
            .timeStamp(System.currentTimeMillis())
            .build();

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
  }
}
