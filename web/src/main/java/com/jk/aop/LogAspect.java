package com.jk.aop;

import com.alibaba.fastjson.JSONObject;
import com.jk.entity.LogBean;
import com.jk.service.LogSenderService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Resource
    LogSenderService logSenderService;

    @Pointcut(value = "execution(* com.jk.controller.*.*(..))")
    public void logCut(){}

    @AfterReturning(pointcut = "logCut()",returning = "obj")
    public void saveLog(JoinPoint joinPoint,Object obj){
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] args = joinPoint.getArgs();
        StringBuffer requestParams = new StringBuffer();
        for (int i =0; i<args.length; i++){
            requestParams.append("|第"+(i+1)+"个参数：" + args[i]);
        }
        String responseParams = obj == null ? "" : obj.toString();

        LogBean log = new LogBean();
        log.setClassName(className);
        log.setMethodName(methodName);
        log.setRequestParam(requestParams.toString());
        log.setResponseParam(responseParams);

        String logJson = JSONObject.toJSONString(log);

        logger.info(logJson);
        logSenderService.send(logJson);
    }
}
