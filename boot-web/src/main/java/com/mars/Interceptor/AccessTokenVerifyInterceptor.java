package com.mars.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AccessTokenVerifyInterceptor extends HandlerInterceptorAdapter{
    private final static Logger logger = LoggerFactory.getLogger(AccessTokenVerifyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("这里验证用户accessToken是否有效");
        return super.preHandle(request, response, handler);
    }
}
