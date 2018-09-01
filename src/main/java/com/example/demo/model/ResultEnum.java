package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用于封装返回结果的状态码和状态值
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {
    UNKNOWN_ERROT(-1, "未知错误"),
    SUCCESS(0, "正确"),
    PERM_ERROR(401,"权限错误"),
    ;
    /**
     * 错误码
     */
    private int code;
    /**
     * 错误信息
     */
    private String msg;
}
