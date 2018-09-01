package com.example.demo.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 切controller日志
 * Created by sunxw on 2018-07-26.
 */
@Aspect
@Component
public class LogAspectHandler {

    private Logger logger  = LoggerFactory.getLogger("LogAspectHandler");

    @Pointcut("execution(* com.gocom.webapp.meeting.controller..*.*(..))")
    public void logPointcut(){}

    /**
     * 请求controller开始
     * @param joinPoint
     */
    @Before("logPointcut()")
    public void beforeLogger(JoinPoint joinPoint){
        String targetName = joinPoint.getTarget().getClass().toString();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        logger.info("请求方法【"+targetName+"." + methodName + "】 参数： " + Arrays.asList(joinPoint.getArgs())
                +"请求时间："+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    /**
     * 请求controller结束
     * @param joinPoint
     */
    @After("logPointcut()")
    public void afterLogger(JoinPoint joinPoint){
		String targetName = joinPoint.getTarget().getClass().toString();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
        logger.info("请求方法【"+targetName+"." + methodName + "】 参数： " + Arrays.asList(joinPoint.getArgs())
		+"结束时间："+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

    }

    @AfterReturning(value="logPointcut()",returning="result")
    public void afterReturning(JoinPoint joinPoint,Object result) throws JsonProcessingException {
        String targetName = joinPoint.getTarget().getClass().toString();
        String methodName = joinPoint.getSignature().getName();
        String resultDatas = result == null ? " ": new ObjectMapper().writeValueAsString(result);
        logger.info("↑↑↑请求方法【" + targetName + "." + methodName + "】 参数： " + Arrays.asList(joinPoint.getArgs())
                + "返回结果[" + resultDatas + "]结束时间：" +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"↑↑↑");
    }

}
