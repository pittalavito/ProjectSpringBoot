package com.example.demo.myMenagementException;

import org.springframework.http.HttpStatus;

public class ErrorMessage <T>{
    private final String msg;
    private final int statusCode;

    public ErrorMessage( String msg , int statusCode){
        this.msg = msg;
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public int getStatusCode() {
        return statusCode;
    }

}
