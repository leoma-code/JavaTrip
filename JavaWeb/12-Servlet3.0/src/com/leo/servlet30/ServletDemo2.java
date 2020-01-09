package com.leo.servlet30;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Leo on 2020/1/9.
 * Description :
 */


//@WebServlet({"/d2", "/dd2", "/ddd2"})
//@WebServlet("/demo/d2")
@WebServlet("*.do")
public class ServletDemo2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        System.out.println("doGet ....");
        System.out.println(req);
        System.out.println(resp);
    }
}
