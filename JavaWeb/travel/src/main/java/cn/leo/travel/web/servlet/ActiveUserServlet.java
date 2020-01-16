package cn.leo.travel.web.servlet;

import cn.leo.travel.service.UserService;
import cn.leo.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Leo on 2020/1/16.
 * Description :
 */
@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String code = request.getParameter("code");

        if (code != null) {
            UserService service = new UserServiceImpl();
            boolean flag = service.active(code);

            String msg = null;
            if (flag) {
                msg = "<a href='login.html'>激活成功，请登录</>";
            } else {
                msg = "激活失败，请联系管理员";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
