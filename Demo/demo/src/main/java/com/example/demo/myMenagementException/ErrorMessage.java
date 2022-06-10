package com.example.demo.myMenagementException;

public class ErrorMessage {
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
