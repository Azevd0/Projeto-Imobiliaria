package com.imobiliaria.Desafio_Imobiliaria.exceptions;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException exception, HttpServletRequest request){
        StandardError standardError = new StandardError(LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> illegalArgumentException(IllegalArgumentException exception, HttpServletRequest request){
        StandardError standardError = new StandardError(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException exception, HttpServletRequest request){
        StandardError standardError = new StandardError(LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                "Erro! Violação na integridade de dados!",
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(standardError);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request){
        ValidationError validationError = new ValidationError(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Erro na validação dos campos: Um ou mais campos estão inválidos.",
                request.getRequestURI());
            for(FieldError error : exception.getBindingResult().getFieldErrors()){
                validationError.addError(error.getDefaultMessage(), error.getField());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);
    }
}
