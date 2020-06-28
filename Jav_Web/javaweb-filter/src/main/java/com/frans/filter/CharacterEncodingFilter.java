package com.frans.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    //初始化:web服务器启动，随时等待过滤器对象出现
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("init");
//        filterConfig.getServletContext().setAttribute();
    }

    /**
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html; charset = utf-8");

        //让我们的请求继续走，如果没有，程序到这里被拦截停止！
        filterChain.doFilter(servletRequest, servletResponse);
    }
    //销毁：web服务器关闭的时候销毁
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
