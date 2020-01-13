package com.leo.session.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Leo on 2020/1/13.
 * Description :
 */


@WebServlet("/login")
public class LoginDemo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");

        // 获取Session中的验证码
        HttpSession session = req.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        // 移除Session中的验证码
        session.removeAttribute("checkCode_session");

        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)) { // 验证码一致
            if ("Tom".equals(username) && "1234".equals(password)) {
                req.getSession().setAttribute("user", username);
                resp.sendRedirect(req.getContextPath() + "/success.jsp");
            } else {
                req.setAttribute("user_error", "用户名或密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }

        } else {
            req.setAttribute("cc_error", "验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
