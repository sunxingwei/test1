package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("消息返回")
@Data
public class JsonResult {

    @ApiModelProperty(value = "状态代码", example = "0")
    private Integer code;
    @ApiModelProperty(value = "返回消息", example = "请求成功")
    private String msg;
    @ApiModelProperty(value = "返回数据")
    private Object obj;

    public JsonResult() {
    }

    public JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(Integer code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }
}
