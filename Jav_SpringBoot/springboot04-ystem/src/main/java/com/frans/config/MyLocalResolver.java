package com.frans.config;

import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String language = httpServletRequest.getParameter("l");
        Locale aDefault = Locale.getDefault();
        if(!StringUtils.isEmpty(language)){
            String[] s = language.split("_");
            aDefault = new Locale(s[0], s[1]);
        }
        return aDefault;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
