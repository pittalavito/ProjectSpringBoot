package com.example.demo.myMenagementException;

import org.springframework.http.HttpStatus;

public class MyHttpException extends RuntimeException{
    private HttpStatus httpStatus;
    public MyHttpException( String msg , HttpStatus httpStatus){
        super( msg );
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }
}
