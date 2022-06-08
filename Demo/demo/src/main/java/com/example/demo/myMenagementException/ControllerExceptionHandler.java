package com.example.demo.myMenagementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler( MyHttpException.class )
    public ResponseEntity<ErrorMessage> myMyHttpExceptionMethod( MyHttpException e, WebRequest request ) {

        ErrorMessage message = new ErrorMessage( e.getMessage() , e.getHttpStatus().value() );

        return new ResponseEntity<ErrorMessage>( message, e.getHttpStatus() );
    }


}
