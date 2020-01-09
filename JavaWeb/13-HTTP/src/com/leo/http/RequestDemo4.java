package com.leo.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * Created by Leo on 2020/1/9.
 * Description :
 */

@WebServlet("/request/demo4")
public class RequestDemo4 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 解决中文乱码
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username - " + username);
        System.out.println("password - " + password);


        String[] values = req.getParameterValues("username");
        for (String value: values) {
            System.out.println("getParameterValues - " + values);
        }

        System.out.println("---------------------");
        Enumeration<String> parameterNames = req.getParameterNames();
        System.out.println("parameterNames - " + parameterNames);
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = req.getParameter(name);
            System.out.println("name:" + name + ", value:" + value);
        }
        System.out.println("---------------------");

        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for (String key: keySet) {
            String[] keyValues = parameterMap.get(key);
            for (String value: keyValues) {
                System.out.println("name:" + key + ",value:" + value);
            }
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
