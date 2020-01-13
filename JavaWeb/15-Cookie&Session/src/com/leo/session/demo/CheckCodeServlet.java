package com.leo.session.demo;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Leo on 2020/1/10.
 * Description :
 */

@WebServlet("/checkCode")
public class CheckCodeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int width = 100;
        int height = 44;
        // 1. 创建一个对象，在内存中的图片（验证码图片对象）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

        // 2. 美化图片
        // 2.1 填充背景色
        Graphics g = image.getGraphics(); // 画笔对象
        g.setColor(Color.pink);
        g.fillRect(0, 0, width, height);

        // 2.2 画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);

        // 2.3 随机写文字
        String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        Random random = new Random();

        g.setColor(Color.white);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            g.drawString(ch + "", width/5*i - 5, height/2);

            sb.append(ch);
        }

        // 存储自动生成验证码
        String checkCode_session = sb.toString();
        req.getSession().setAttribute("checkCode_session", checkCode_session);

        // 2.4 画干扰线
        for (int i = 0; i < 6; i++) {
            int x1 = random.nextInt(width - 10) + 5;
            int x2 = random.nextInt(width - 10) + 5;

            int y1 = random.nextInt(height - 10) + 5;
            int y2 = random.nextInt(height - 10) + 5;
            g.drawLine(x1, y1, x2, y2);
        }

        // 3. 将图片输出到页面展示
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
