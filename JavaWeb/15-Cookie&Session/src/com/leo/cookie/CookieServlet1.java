package com.leo.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by Leo on 2020/1/10.
 * Description :
 */

@WebServlet("/cookie1")
public class CookieServlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置Cookie
        Cookie cookie = new Cookie("AAA", "BBB");
        Cookie cookie1 = new Cookie("CCC", "DDD");
        Cookie cookie2 = new Cookie("TOM", URLEncoder.encode("汤姆", "utf-8"));
        cookie.setMaxAge(60);

        resp.addCookie(cookie);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
