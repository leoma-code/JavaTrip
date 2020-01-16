package cn.leo.travel.web.servlet;

import cn.leo.travel.domain.ResultInfo;
import cn.leo.travel.domain.User;
import cn.leo.travel.service.UserService;
import cn.leo.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by Leo on 2020/1/16.
 * Description :
 */

@WebServlet("/user/*")  //匹配所有路径
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    /** 用户注册
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
        boolean flag = userService.register(user);

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

    /**
     * 校验验证码
     * @param req
     * @return
     */
    private boolean checkCode(HttpServletRequest req) {
        String checkcode = req.getParameter("check");
        HttpSession session = req.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        return checkcode_server != null && checkcode_server.equalsIgnoreCase(checkcode);
    }

    /** 用户激活
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void active(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String code = req.getParameter("code");

        if (code != null) {
            boolean flag = userService.active(code);

            String msg = null;
            if (flag) {
                msg = "<a href='login.html'>激活成功，请登录</>";
            } else {
                msg = "激活失败，请联系管理员";
            }
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write(msg);
        }
    }

    /**
     * 用户登陆
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        User u = userService.login(user);

        ResultInfo info = new ResultInfo();
        if (u == null) {
            info.setFlag(false);
            info.setErrorMsg("用户或密码错误");
        } else {

            if ("Y".equals(u.getStatus())) { // 用户已激活 登陆成功
                info.setFlag(true);

                // 将用户信息存储在Session中
                req.getSession().setAttribute("USER", u);

            } else {

                info.setFlag(false);
                info.setErrorMsg("用户未激活，请先激活");
            }
        }

        ObjectMapper mapper = new ObjectMapper();

        resp.setContentType("application/json;charset=utf-8");
        mapper.writeValue(resp.getOutputStream(), info);
    }


    /**
     * 查询Session中用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object user = req.getSession().getAttribute("USER");

        resp.setContentType("application/json;charset=utf-8");
        new ObjectMapper().writeValue(resp.getOutputStream(), user);
    }

    /**
     * 退出登陆
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void exit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 销毁Session
        req.getSession().invalidate();

        // 重定向到登陆页面
        resp.sendRedirect(req.getContextPath() + "/login.html");
    }


}
