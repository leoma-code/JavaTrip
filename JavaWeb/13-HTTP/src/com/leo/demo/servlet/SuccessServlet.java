package com.leo.demo.servlet;

import com.leo.demo.domain.User;

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

@WebServlet("/success")
public class SuccessServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getAttribute("user");
        if (user != null) {

            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("登陆成功，" + user.getUsername() + " 欢迎你！");
        }
    }
}
