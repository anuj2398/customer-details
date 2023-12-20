package com.crio.starter.exception;

public class AgeBelow18Exception extends RuntimeException{
    public AgeBelow18Exception(String msg){
        super(msg);
    }
}
