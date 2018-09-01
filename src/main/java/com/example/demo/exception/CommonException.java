package com.example.demo.exception;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CommonException extends RuntimeException{
    private Integer code = 400;
    private String msg;

    public CommonException(String msg){
        this.msg = msg;
    }
}
