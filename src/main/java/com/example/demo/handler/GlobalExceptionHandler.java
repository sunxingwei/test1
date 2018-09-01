
package com.example.demo.handler;

import com.example.demo.exception.CommonException;
import com.example.demo.model.JsonResult;
import com.example.demo.model.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {


    private Logger logger = LoggerFactory.getLogger("GlobalExceptionHandler.class");


    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ExceptionHandler(value=Exception.class)
    public JsonResult exceptionHandler(HttpServletRequest request, CommonException e) {
        e.printStackTrace();
        return ResultUtil.error(e.getCode(),e.getMsg());
    }


    /**
     * 参数绑定异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ExceptionHandler(BindException.class)
    public JsonResult BindExceptionException(BindException e) {
        logger.info("↓↓↓↓↓↓↓↓↓↓↓↓↓↓参数绑定异常↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        e.printStackTrace();

        String resultField = e.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList()).toString();

        return ResultUtil.error(50001,resultField);
    }


    /**
     * 表单校验异常
     * @param ve
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonResult handleMethodArgumentNotValidException(MethodArgumentNotValidException ve) {
        logger.info("↓↓↓↓↓↓↓↓↓↓↓↓↓↓表单校验异常↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        ve.printStackTrace();

        String resultField = ve.getBindingResult().getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList())
                .toString();

        return ResultUtil.error(50002,resultField);

    }

    /**
     * 请求参数解析异常
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public JsonResult handleJSONException(HttpServletRequest request, HttpMessageNotReadableException e){
        logger.info("↓↓↓↓↓↓↓↓↓↓↓↓↓↓请求参数解析异常↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        e.printStackTrace();
        return ResultUtil.error(50003,"请求参数解析异常，请确认传入的参数格式是否正确");
    }



    /**
     * 请求参数异常
     * @param e
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public JsonResult MissingServletRequestParameterExceptionException(MissingServletRequestParameterException e){
        logger.info("↓↓↓↓↓↓↓↓↓↓↓↓↓↓请求参数异常↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        e.printStackTrace();
        return ResultUtil.error(50004,"请求参数"+e.getParameterName()+"不存在");
    }
}
