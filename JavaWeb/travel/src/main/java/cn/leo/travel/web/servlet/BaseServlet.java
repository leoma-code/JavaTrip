package cn.leo.travel.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Leo on 2020/1/16.
 * Description :
 */
public class BaseServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取访问路径
        String uri = req.getRequestURI();
        //System.out.println("【uri】- " + uri); // /travel/user/add

        // 截取方法名称
        String methodName = uri.substring(uri.lastIndexOf('/') + 1);
        //System.out.println("【Method】- " + methodName); // add

        try {
            // 获取对应servlet的方法
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 执行方法
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected void writeValue(HttpServletResponse response, Object obj) throws IOException {

        response.setContentType("applciation/json;charset=utf-8");

        new ObjectMapper().writeValue(response.getOutputStream(), obj);
    }
}
