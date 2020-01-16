package cn.leo.travel.web.servlet;

import cn.leo.travel.domain.ResultInfo;
import cn.leo.travel.domain.User;
import cn.leo.travel.service.UserService;
import cn.leo.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by Leo on 2020/1/15.
 * Description :
 */

@WebServlet("/registerUserServlet")
public class RegisterUserServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // 验证码校验
        boolean codeFlag = checkCode(req);
        if (!codeFlag) {
            ResultInfo info = new ResultInfo(false, "验证码错误");
            String json = new ObjectMapper().writeValueAsString(info);
            System.out.println(json);
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write(json);
            return;
        }


        // 获取数据
        Map<String, String[]> parameterMap = req.getParameterMap();

        // 封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 调用service 注册用户
        UserService service = new UserServiceImpl();
        boolean flag = service.register(user);

        // 响应结果
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setFlag(flag);

        if (!flag) { // 注册失败
            resultInfo.setErrorMsg("注册失败");
        }

        // 转成json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);
        System.out.println(json);

        // 设置响应数据MIME类型
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);

    }

    private boolean checkCode(HttpServletRequest req) {
        String checkcode = req.getParameter("check");
        HttpSession session = req.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        return checkcode_server != null && checkcode_server.equalsIgnoreCase(checkcode);
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
