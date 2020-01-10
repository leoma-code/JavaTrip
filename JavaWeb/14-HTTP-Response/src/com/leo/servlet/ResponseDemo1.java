package com.leo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Leo on 2020/1/10.
 * Description :
 */

@WebServlet("/demo1")
public class ResponseDemo1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo1 .........");

        /*
        // 设置响应行 重定向状态码 302
        resp.setStatus(302);
        // 设置响应头 location
        resp.setHeader("location", "/http-response/demo2");
        */

        // 简单实现
        // 重定向到当前服务资源
//        resp.sendRedirect("/http-response/demo2");

        // 动态获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println("contextPath - " + contextPath);
        resp.sendRedirect(contextPath + "/demo2");


        // 重定向到其他站点资源
//        resp.sendRedirect("https://www.baidu.com");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
