package com.leo.cookie.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Leo on 2020/1/10.
 * Description :
 */

@WebServlet("/cookieDemo")
public class CookieDemo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置响应数据格式
        resp.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = req.getCookies();

        // 获取此处访问时间
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String dateStr = format.format(date);
        // URL编码解决Cookie存储空格的问题
        dateStr = URLEncoder.encode(dateStr, "utf-8");

        // 是否访问过标识
        boolean flag = false;

        if (cookies != null && cookies.length > 0) {

            for (Cookie c: cookies) {

                if ("lastTime".equals(c.getName())) {

                    // URL解码
                    String lastDateStr = URLDecoder.decode(c.getValue(), "utf-8");

                    // 更新Cookie
                    c.setMaxAge(30);
                    c.setValue(dateStr);
                    resp.addCookie(c);

                    resp.getWriter().write("欢迎回来，您上次访问时间为:" + lastDateStr);
                    flag = true;
                    break;
                }
            }
        }


        if (cookies == null || cookies.length == 0 || flag == false) {
            resp.getWriter().write("您好，欢迎您首次访问。");

            Cookie cookie = new Cookie("lastTime", dateStr);
            cookie.setMaxAge(30);
            resp.addCookie(cookie);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
