package com.leo.downloadDemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Leo on 2020/1/10.
 * Description :
 */

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1.获取参数
        String filename = req.getParameter("filename");
        // 2.使用字节输入流加载文件到内存中
        // 2.1 获取文件路径
        ServletContext servletContext = this.getServletContext();
        String path = servletContext.getRealPath("/res/" + filename);
        // 2.2 创建字节输入流
        FileInputStream fis = new FileInputStream(path);

        // 3.设置response响应头
        String mimeType = servletContext.getMimeType(path);
        // 3.1 设置响应头类型  content-type
        resp.setHeader("content-type", mimeType);


        // 解决中文文件名编码问题
        String agent = req.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent, filename);

        // 3.2 设置响应头打开方式  content-disposition
        resp.setHeader("content-disposition", "attachment;filename=" + filename);

        // 4.将输入流写入到输出流中
        ServletOutputStream sos = resp.getOutputStream();

        byte[] bytes = new byte[1024 * 10];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            sos.write(bytes, 0, len);
        }

        fis.close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
