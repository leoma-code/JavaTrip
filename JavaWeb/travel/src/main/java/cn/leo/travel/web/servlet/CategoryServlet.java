package cn.leo.travel.web.servlet;

import cn.leo.travel.domain.Category;
import cn.leo.travel.service.CategoryService;
import cn.leo.travel.service.impl.CategoryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Leo on 2020/1/16.
 * Description :
 */

@WebServlet("/category/*")  //匹配所有路径
public class CategoryServlet extends BaseServlet {

    private CategoryService categoryService = new CategoryServiceImpl();

    /**
     * 查询所有分类
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Category> list = categoryService.findAll();

        resp.setContentType("application/json;charset=utf-8");
        new ObjectMapper().writeValue(resp.getOutputStream(), list);

    }



}

