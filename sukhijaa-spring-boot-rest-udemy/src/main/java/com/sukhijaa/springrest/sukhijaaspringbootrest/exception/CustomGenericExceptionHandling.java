package com.sukhijaa.springrest.sukhijaaspringbootrest.exception;

import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomGenericExceptionHandling extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> genericExceptionHandler(Exception ex, WebRequest wb) {
    ExceptionFormat ef = new ExceptionFormat(new Date(), ex.getMessage(), wb.getDescription(false));
    return new ResponseEntity(ef, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(UserNotFoundException.class)
  public final ResponseEntity<Object> userNotFoundHandler(UserNotFoundException ex, WebRequest wb) {
    ExceptionFormat ef = new ExceptionFormat(new Date(), ex.getMessage(), wb.getDescription(false));
    return new ResponseEntity(ef, HttpStatus.NOT_FOUND);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    ExceptionFormat ef = new ExceptionFormat(new Date(), "Validation Failed",
        ex.getBindingResult().toString());
    return new ResponseEntity(ef, HttpStatus.BAD_REQUEST);
  }
}
