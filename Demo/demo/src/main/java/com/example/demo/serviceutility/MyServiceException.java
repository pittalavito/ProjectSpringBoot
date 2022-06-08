package com.example.demo.serviceutility;

public class MyServiceException extends RuntimeException{
    public MyServiceException( String messageCase ){
        super( messageCase );
    }
}