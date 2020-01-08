###web服务器软件：

- 服务器：安装了服务器软件的计算机

- 服务器软件：接收用户的请求，处理请求，做出响应

- web服务器软件：接收用户的请求，处理请求，做出响应。
  - 在web服务器软件中，可以部署web项目，让用户通过浏览器来访问这些项目
  - web容器

- 常见的java相关的web服务器软件：
  - **webLogic**：oracle公司，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
  - **webSphere**：IBM公司，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
  - **JBOSS**：JBOSS公司的，大型的JavaEE服务器，支持所有的JavaEE规范，收费的。
  - **Tomcat**：Apache基金组织，中小型的JavaEE服务器，仅仅支持少量的JavaEE规范servlet/jsp。开源的，免费的。

- JavaEE：Java语言在企业级开发中使用的技术规范的总和，一共规定了13项大的规范

---

#### Tomcat：web服务器软件

- 下载：http://tomcat.apache.org/

- 安装：解压压缩包即可。

  > 注意：安装目录建议不要有中文和空格

- 卸载：删除目录就行了

- 启动：

  - bin/startup.bat ,双击运行该文件即可

  - 可能遇到的问题：
    - 黑窗口一闪而过：
      - 原因： 没有正确配置JAVA_HOME环境变量
      -  解决方案：正确配置JAVA_HOME环境变量

- 启动报错：

  - 暴力：找到占用的端口号，并且找到对应的进程，杀死该进程

    - netstat -ano

  - 温柔：修改自身的端口号

    ```
    # conf/server.xml
    
    <Connector port="8888" protocol="HTTP/1.1"
    connectionTimeout="20000"
    redirectPort="8445" />
    ```

    > 一般会将tomcat的默认端口号修改为80。80端口号是http协议的默认端口号。
    >
    > 好处：在访问时，就不用输入端口号

- 关闭：
  - 正常关闭：
    - bin/shutdown.bat
    - ctrl+c
  - 强制关闭：
    - 点击启动窗口的×

- 配置:
  - 部署项目的方式：
    - 直接将项目放到webapps目录下即可。
      -  /hello：项目的访问路径-->虚拟目录
      - 简化部署：将项目打成一个war包，再将war包放置到webapps目录下。
      - war包会自动解压缩
    - 配置conf/server.xml文件
      - 在<Host>标签体中配置
        - <Context docBase="D:\hello" path="/hehe" />
        - docBase:项目存放的路径
        - path：虚拟目录
    - 在conf\Catalina\localhost创建任意名称的xml文件。在文件中编写<Context docBase="D:\hello" />
      - 虚拟目录：xml文件的名称

- **静态项目和动态项目：**
  - 目录结构
    -  java动态项目的目录结构：
      - 项目的根目录
        - WEB-INF目录：
          - web.xml：web项目的核心配置文件
          - classes目录：放置字节码文件的目录
          -  lib目录：放置依赖的jar包

- 将Tomcat集成到IDEA中，并且创建JavaEE的项目，部署项目。