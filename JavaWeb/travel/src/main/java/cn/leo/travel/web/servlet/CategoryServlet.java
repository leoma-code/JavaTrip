package cn.leo.travel.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Leo on 2020/1/16.
 * Description :
 */

@WebServlet("/category/*")  //匹配所有路径
public class CategoryServlet extends BaseServlet {

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("CategoryServlet add ....");

    }

    public void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("CategoryServlet find ....");

    }


}

