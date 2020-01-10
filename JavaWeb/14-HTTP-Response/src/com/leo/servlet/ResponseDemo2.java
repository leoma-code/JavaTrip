package com.leo.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Leo on 2020/1/10.
 * Description :
 */

@WebServlet("/demo2")
public class ResponseDemo2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("demo2 .........");

        // 设置解码方式
        resp.setContentType("text/html;charset=utf-8");
        // 获取字节流
        ServletOutputStream outputStream = resp.getOutputStream();
        // 输出数据
        outputStream.write("你好".getBytes());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
