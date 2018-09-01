package com.example.demo.model;

/**
 * 用于restful返回时的统一格式处理
 */
public class ResultUtil {

    /**
     * 正确返回
     * @param data 返回结果
     * @return
     */
    public static JsonResult success(Object data){
        return new JsonResult(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),data);
    }

    /**
     * 不指定错误类型，返回未知错误
     * @return
     */
    public static JsonResult error(){
        return error(ResultEnum.UNKNOWN_ERROT.getCode(),ResultEnum.UNKNOWN_ERROT.getMsg());
    }

    /**
     * 由用户指定code和msg
     * @param code
     * @param msg
     * @return
     */
    public static JsonResult error(Integer code,String msg){
        return new JsonResult(code,msg);
    }

    /**
     * 用户指定errorData，用于更详细的描述错误
     * @param code
     * @param msg
     * @param errorData
     * @return
     */
    public static JsonResult error(Integer code,String msg,Object errorData){
        return new JsonResult(code,msg,errorData);
    }

}
