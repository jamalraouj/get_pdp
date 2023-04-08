package com.get_pdp.get_pdp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationExceptionHandler  {//extends ResponseEntityExceptionHandler

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity< Map<String  , List<String>>> handleExceptionNotValid(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(this.getErrorMap(errors) , new HttpHeaders(),HttpStatus.BAD_REQUEST);
    }
    private Map<String, List<String>> getErrorMap(List<String> errors){
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors" , errors);
        return errorResponse;
    }



//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//        BindingResult bindingResult = ex.getBindingResult();
//        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//
//        Map<String, String> errors = new HashMap<>();
//
//        for (FieldError fieldError : fieldErrors) {
//            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
//        }
//
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }
}
