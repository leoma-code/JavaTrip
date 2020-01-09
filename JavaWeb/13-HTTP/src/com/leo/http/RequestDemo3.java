package com.leo.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Leo on 2020/1/9.
 * Description :
 */

@WebServlet("/request/demo3")
public class RequestDemo3 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        // 获取字符流 请求体
        BufferedReader reader = req.getReader();

        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }


    }
}
