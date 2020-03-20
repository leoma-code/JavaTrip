package com.leo.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Created by Leo on 2020/3/20.
 * Description :
 */

@Controller
@RequestMapping("user")
public class UserController {

    /**
     * 跨服务器文件上传
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping("fileupload2")
    public String fileupload2(MultipartFile upload) throws Exception {

        // 图片服务器请求路径
        String path = "http://localhost:8081/uploads/";

        // 获取上传文件文件名
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = filename + "_" + uuid;

        // 向图片服务器上传文件
        // 创建客户端对象
        Client client = Client.create();
        // 连接图片服务器
        WebResource webResource = client.resource(path + filename);
        // 上传文件
        webResource.put(upload.getBytes());

        return "success";
    }



    /**
     * SpringMVC 文件上传
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("fileupload1")
    public String fileupload1(HttpServletRequest request, MultipartFile upload) throws Exception {

        // 获取要上传的文件目录
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        System.out.println(path);
        // 创建file对象，向该路径下上传文件
        File file = new File(path);
        // 判断该路径是否存在，如果不存在创建该路径
        if (!file.exists()) {
            file.mkdirs();
        }

        // 获取上传文件文件名
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = filename + "_" + uuid;
        upload.transferTo(new File(file, filename));

        return "success";
    }


    /**
     * 传统文件上传
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("fileupload")
    public String fileupload(HttpServletRequest request) throws Exception {

        // 获取要上传的文件目录
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        System.out.println(path);
        // 创建file对象，向该路径下上传文件
        File file = new File(path);
        // 判断该路径是否存在，如果不存在创建该路径
        if (!file.exists()) {
            file.mkdirs();
        }
        // 创建磁盘文件项工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        // 解析 request对象
        List<FileItem> fileItems = fileUpload.parseRequest(request);

        for (FileItem fileItem: fileItems) {
            if (fileItem.isFormField()) {
                // 普通项
            } else { // 文件上传项
                String filename = fileItem.getName();
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = filename + "_" + uuid;
                // 上传文件
                fileItem.write(new File(file, filename));
                // 删除临时文件
                fileItem.delete();
            }
        }

        return "success";
    }


}
