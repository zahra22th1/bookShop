package org.example.bookshop.controller;

import org.example.bookshop.dto.response.ExceptionResponse;
import org.example.bookshop.excepion.RuleException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

    private final MessageSourceAccessor messageSourceAccessor;

    public ExceptionController(MessageSourceAccessor messageSourceAccessor) {
        this.messageSourceAccessor = messageSourceAccessor;
    }

    @ExceptionHandler
    public ResponseEntity <List<ExceptionResponse>> handlerRuleException(RuleException e) {
        //map kardan
     ExceptionResponse build = RuleExceptionToExceptionResponse(e);
     return ResponseEntity
             .status(400)
             .body(Collections.singletonList(build));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity <List<ExceptionResponse>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity
                .status(402)
                .body(MethodArgumentNotValidExceptionToExceptionResponse(e));
    }
    private List<ExceptionResponse> MethodArgumentNotValidExceptionToExceptionResponse(MethodArgumentNotValidException e) {
      return   e.getFieldErrors().stream().map(error ->
            ExceptionResponse.builder()
                    .message(error.getDefaultMessage())
                    .code(error.getField())
                    .build()
        ).collect(Collectors.toList());

    }
    private ExceptionResponse RuleExceptionToExceptionResponse (RuleException e) {
        return  ExceptionResponse.builder()
                .message(messageSourceAccessor.getMessage(e.getMessage()))
                .code(e.getMessage())
                .build();
    }
}
