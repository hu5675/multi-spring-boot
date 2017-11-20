package com.mars.handler;

import com.mars.exception.GlobalException;
import com.mars.model.DataResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public DataResult handle(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException girlException = (GlobalException) e;
            DataResult result = new DataResult();
            result.setCode(-2);
            result.setMsg("统一异常处理");
            return  result;
        }else {
            logger.error("【系统异常】{}", e);
            DataResult result = new DataResult();
            result.setCode(-1);
            result.setMsg("未知错误");

            return  result;
        }
    }
}
