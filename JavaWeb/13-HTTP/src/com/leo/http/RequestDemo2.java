package com.leo.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Leo on 2020/1/9.
 * Description :
 */

@WebServlet("/request/demo2")
public class RequestDemo2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        String userAgent = req.getHeader("User-Agent");
        System.out.println(userAgent);


        Enumeration<String> headerNames = req.getHeaderNames();
        System.out.println(headerNames);
    }
}
