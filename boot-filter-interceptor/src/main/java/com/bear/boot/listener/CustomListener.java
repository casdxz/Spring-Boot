package com.bear.boot.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: bear
 * @create: 2022-04-04 10:48
 **/
@Slf4j
//@WebListener
public class CustomListener implements ServletContextListener, HttpSessionListener, ServletRequestListener, ServletRequestAttributeListener, HttpSessionAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("==============context创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("===============context销毁");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("===============request监听器:销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("===============request监听器:创建");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("===============session监听器:创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("===============session监听器:销毁");
    }


    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        if("a".equals(srae.getName())) {
            log.info("------------attribute Added");
        }
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        if("a".equals(srae.getName())) {
            log.info("------------attribute removed");
        }
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        if("a".equals(srae.getName())) {
            log.info("------------attribute replace");
        }
    }


    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        if("b".equals(se.getName())) {
            log.info("------------session Added");
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        if("b".equals(se.getName())) {
            log.info("------------session removed");
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        if("b".equals(se.getName())) {
            log.info("------------session replace");
        }
    }
}
