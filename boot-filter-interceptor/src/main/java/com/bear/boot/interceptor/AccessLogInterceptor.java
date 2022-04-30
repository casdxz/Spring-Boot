package com.bear.boot.interceptor;

import com.bear.boot.domain.AccessLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-04 20:47
 **/
@Component
@Slf4j
public class AccessLogInterceptor implements HandlerInterceptor {
    /**
     * 进入springMVC的Controller之前开始记录日志实体
     * @param request request
     * @param response  response
     * @param handler handler
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //创建日志实体
        AccessLog accessLog = new AccessLog();
        //设置IP地址
//        accessLog.setIp(AddressIpUtis);
        //设置请求方法 GET POST。。
        accessLog.setHttpMethod(request.getMethod());
        //设置请求路径
        accessLog.setUrl(request.getRequestURI());
        request.setAttribute("sendTime",System.currentTimeMillis());
        request.setAttribute("accessLog",accessLog);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        AccessLog accessLog = (AccessLog) request.getAttribute("accessLog");
        int status = response.getStatus();
        accessLog.setHttpStatus(status);
        accessLog.setUsername(request.getParameter("username"));
        long currentTime = System.currentTimeMillis();
        long endTime = Long.parseLong(request.getAttribute("sendTime").toString());
        accessLog.setDuration(Integer.valueOf((currentTime - endTime) + ""));
        accessLog.setCreateTime(new Date());
        log.info(accessLog.toString());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}