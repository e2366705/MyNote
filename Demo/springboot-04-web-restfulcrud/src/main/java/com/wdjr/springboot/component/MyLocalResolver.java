package com.wdjr.springboot.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocalResolver implements LocaleResolver {

    //解析区域信息
    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        // Java中用于国际化的locale类

        String l = request.getParameter("lg");
        Locale locale = Locale.getDefault();

        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale = new Locale(split[0], split[1]);
        }
        System.out.println(locale);
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
