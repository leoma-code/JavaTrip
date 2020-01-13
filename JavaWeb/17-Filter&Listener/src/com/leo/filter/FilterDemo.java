package com.leo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by Leo on 2020/1/13.
 * Description :
 */


@WebFilter("/*") // 访问所有资源之前都会执行该过滤器
public class FilterDemo implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 对Request对象的请求消息增强
        System.out.println("Filter Demo invoke ...");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);


        // 对Resonse对象的响应消息增强
        System.out.println("Filter Demo back ...");
    }

    @Override
    public void destroy() {

    }

}
