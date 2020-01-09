### web概述

- JavaWeb:

  使用Java语言开发基于互联网的项目

- 软件架构：

  - C/S ：Client/Server 客户端/服务器端
    - 在用户本地有一个客户端程序，在远程有一个服务器端程序
    - 优点：
      - 用户体验好
    - 缺点：
      -  开发、安装、部署、维护麻烦
  - B/S: Browser/Server 浏览器/服务器端
    - 只需要一个浏览器，用户通过不同的网址(URL)，客户访问不同的服务器端程序
    - 优点：
      -  开发、安装，部署，维护 简单
    -  缺点：
      -  如果应用过大，用户的体验可能会受到影响
      -  对硬件要求过高

  ---

-  **B/S架构详解**

  - 资源分类：

    -  静态资源：使用静态网页开发技术发布的资源。

      - 特点：

        所有用户访问，得到的结果是一样的。

        如：文本，图片，音频、视频, HTML,CSS,JavaScript

        如果用户请求的是静态资源，那么服务器会直接将静态资源发送给浏览器。浏览器中内置了静态资源的解析引擎，可以展示静态资源

    - 动态资源：使用动态网页及时发布的资源。

      -  特点：
        -  所有用户访问，得到的结果可能不一样。
        - 如：jsp/servlet,php,asp...
        -  如果用户请求的是动态资源，那么服务器会执行动态资源，转换为静态资源，再发送给浏览器

    > 我们要学习动态资源，必须先学习静态资源！

---

- **静态资源：**
  -  HTML：用于搭建基础网页，展示页面的内容
  -  CSS：用于美化页面，布局页面
  -  JavaScript：控制页面的元素，让页面有一些动态的效果

---

### HTML

- 概念：`Hyper Text Markup Language` 超文本标记语言
  - 超文本:
    - 超文本是用超链接的方法，将各种不同空间的文字信息组织在一起的网状文本.
  -  标记语言:
    -  由标签构成的语言。<标签名称> 如 html，xml
    - 标记语言不是编程语言

- 标签学习：

  - 文件标签：构成html最基本的标签
    -  html:html文档的根标签
    - head：头标签。用于指定html文档的一些属性。引入外部的资源
    - title：标题标签
    - body：体标签
    -  <!DOCTYPE html>：html5中定义该文档是html文档

  - 文本标签：和文本有关的标签

  ​			* 注释：<!-- 注释内容 -->

  ​			* <h1> to <h6>：标题标签

  ​			* h1~h6:字体大小逐渐递减

  ​			* <p>：段落标签

  ​			* `<br>`换行标签

  ​			* `<hr>`：展示一条水平线

  * 属性：
    * color：颜色
    *  width：宽度
    *  size：高度
    * align：对其方式
    * center：居中
    *  left：左对齐
    *  right：右对齐
    *  `<b>`：字体加粗
    * `<i>`：字体斜体
    *  <font>:字体标签
    *  <center>:文本居中

  ​				* 属性：

  ​					* color：颜色

  ​					* size：大小

  ​					* face：字体

  - 属性定义：

    -  color：
      -  英文单词：red,green,blue
      -  rgb(值1，值2，值3)：值的范围：0~255 如 rgb(0,0,255)
      - 值1值2值3：值的范围：00~FF之间。如： #FF00FF
    -  width：
      -  数值：width='20' ,数值的单位，默认是 px(像素)
      -  数值%：占比相对于父元素的比例

  - 图片标签：

    -  img：展示图片

      - 属性：

         src：指定图片的位置

       - 代码：

    ```
     <!--展示一张图片 img-->
     <img src="image/jingxuan_2.jpg" align="right" alt="古镇" width="500" height="500"/>
     <!--
    	相对路径
    		* 以.开头的路径
    	  * ./：代表当前目录 ./image/1.jpg
    	  * ../:代表上一级目录
     -->			
    <img src="./image/jiangwai_1.jpg">
    <img src="../image/jiangwai_1.jpg">
    ```

  - 列表标签：

    -  有序列表：
      -  ol:
      -  li:
    - 无序列表：
      - ul:
      - li:

  - 链接标签：

    - `a`:定义一个超链接
      - 属性：
        -  href：指定访问资源的URL(统一资源定位符)
        -  target：指定打开资源的方式
          - _self:默认值，在当前页面打开
          -  _blank：在空白页面打开

  - `div`和`span`：

    - `div`:每一个`div`占满一整行。块级标签

    - `span`：文本信息在一行展示，行内标签 内联标签

  - 语义化标签：html5中为了提高程序的可读性，提供了一些标签。

    - `<header>`：页眉

    - `<footer>`：页脚

  - 表格标签：

    -  table：定义表格
      - width：宽度
      -  border：边框
      - cellpadding：定义内容和单元格的距离
      - cellspacing：定义单元格之间的距离。如果指定为0，则单元格的线会合为一条
      - bgcolor：背景色
      - align：对齐方式

    - tr：定义行
      - bgcolor：背景色
      - align：对齐方式
    - td：定义单元格
      - colspan：合并列
      - rowspan：合并行

    - th：定义表头单元格
    - <caption>：表格标题
    -  <thead>：表示表格的头部分
    -  <tbody>：表示表格的体部分
    -  <tfoot>：表示表格的脚部分

---

#### HTML标签：表单标签

-  表单：

  概念：用于采集用户输入的数据的。用于和服务器进行交互。

  `form`：用于定义表单的。可以定义一个范围，范围代表采集用户数据的范围

  - 属性：

    -  `action`：指定提交数据的URL
    - `method`:指定提交方式
      - 分类：一共7种，2种比较常用
      -  get：
        - 请求参数会在地址栏中显示。会封装到请求行中(HTTP协议后讲解)。
        -  请求参数大小是有限制的。
        -  不太安全。
      - post：
        -  请求参数不会再地址栏中显示。会封装在请求体中(HTTP协议后讲解)
        -  请求参数的大小没有限制。
        - 较为安全。

    > 表单项中的数据要想被提交：必须指定其name属性

  - 表单项标签：

    - input：可以通过type属性值，改变元素展示的样式

      -  type属性：

        - text：文本输入框，默认值
          
          - placeholder：指定输入框的提示信息，当输入框的内容发生变化，会自动清空提示信息
        - password：密码输入框
  - radio:单选框
        
  -  checkbox：复选框
        
          > **radio**    **checkbox**
          >
          > 注意：
          >
          > 1. 要想让多个单选框实现单选的效果，则多个单选框的name属性值必须一样
          > 2. 一般会给每一个单选框提供value属性，指定其被选中后提交的值
    > 3.  checked属性，可以指定默认值
        
  - file：文件选择框
        
        - hidden：隐藏域，用于提交一些信息。
        - 按钮：
          - submit：提交按钮。可以提交表单
          - button：普通按钮
          - image：图片提交按钮
        - src属性指定图片的路径	
    
- label：指定输入项的文字描述信息
    
      > 注意：
      >
      > label的for属性一般会和 input 的 id属性值 对应。如果对应了，则点击label区域，会让input输入框获取焦点。
      >
      > ```
      > <label for="username">用户名：<label><input id="username" type="text" placeholder="请输入用户名">
  > ```
    
    - select: 下拉列表
      
      - 子元素：option，指定列表项
    -  textarea：文本域
      - cols：指定列数，每一行有多少个字符
      -  rows：默认多少行。

---

#### CSS：页面美化和布局控制

- 概念：` Cascading Style Sheets `层叠样式表

  层叠：多个样式可以作用在同一个html的元素上，同时生效

- CSS的使用：CSS与html结合方式

  - 内联样式

    -  在标签内使用style属性指定css代码
    - 如：<div style="color:red;">hello css</div>

  - 内部样式

    - 在head标签内，定义style标签，style标签的标签体内容就是css代码

  - 外部样式

    - 定义css资源文件。
    - 在head标签内，定义link标签，引入外部的资源文件
    - `<link rel="stylesheet" href="css/a.css">

    > 注意：
    >
    > 1. 3种方式 css作用范围越来越大
    >
    > 2. 1方式不常用，后期常用2,3
    >
    > 3. 3种格式可以写为：
    >
    >    ```
    >    <style>
    >    	@import "css/a.css";
    >    </style>
    >    ```

- css语法：

  -  格式：

    ```
    选择器 {
    	属性名1:属性值1;
    	属性名2:属性值2;
    	...
    
    }
    ```

  - 选择器: 筛选具有相似特征的元素

    > 注意：
    >
    > 每一对属性需要使用`；`隔开，最后一对属性可以不加`；`

-  选择器：筛选具有相似特征的元素
  - 分类：

    - 基础选择器

      -  id选择器：选择具体的id属性值的元素.建议在一个html页面中id值唯一
      - 语法：`#id属性值`{ }

    - 元素选择器：选择具有相同标签名称的元素

      - 语法： `标签名称`{ }

        > 注意：id选择器优先级高于元素选择器

    - 类选择器：选择具有相同的class属性值的元素。

      - 语法：`.class属性值`{ }

        > 注意：类选择器选择器优先级高于元素选择器

  - 扩展选择器：

    - 选择所有元素：
      -  语法： `*` { }
    - 并集选择器：
      - `选择器1`,`选择器2`{ }

    - 子选择器：筛选选择器1元素下的选择器2元素
      - 语法： `选择器1` `选择器2`{ }
    - 父选择器：筛选选择器2的父元素选择器1
      -  语法： `选择器1` >` 选择器2`{ }

    - 属性选择器：选择元素名称，属性名=属性值的元素
      -  语法： `元素名称[属性名="属性值"]`{ }
    -  伪类选择器：选择一些元素具有的状态
      - 语法： `元素:状态`{}
      - 如： <a>
        - 状态：
          - link：初始化的状态
          - visited：被访问过的状态
          -  active：正在访问状态
          - hover：鼠标悬浮状态

- 属性
  - 字体、文本
    - font-size：字体大小
    -  color：文本颜色
    - text-align：对其方式
    - line-height：行高 
  -  背景
    - background：
  -  边框
    -  border：设置边框，符合属性
  -  尺寸
    -  width：宽度
    -  height：高度
  -  盒子模型：控制布局
    - margin：外边距
    - padding：内边距
      -  默认情况下内边距会影响整个盒子的大小
      -  box-sizing: border-box; 设置盒子的属性，让width和height就是最终盒子的大小
    -  float：浮动
      -  left
      - right

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <style>
        * {
            margin: 0px;
            padding: 0px;
            box-sizing: border-box;
        }

        body {
            background: url("img/register_bg.png") no-repeat center;
            padding-top: 25px;
        }

        .rg_layout {
            width: 900px;
            height: 500px;
            border: 8px solid #EEEEEE;
            background-color: white;
            /*让div水平居中*/
            margin: auto;
        }

        .rg_left {
            /*border: 1px solid red;*/
            float: left;
            margin: 15px;
        }

        .rg_left > p:first-child {
            color: #FFD026;
            font-size: 20px;
        }

        .rg_left > p:last-child {
            color: #A6A6A6;
            font-size: 20px;
        }

        .rg_center {
            float: left;
            /* border: 1px solid red;*/

        }

        .rg_right {
            /*border: 1px solid red;*/
            float: right;
            margin: 15px;
        }

        .rg_right > p:first-child {
            font-size: 15px;

        }

        .rg_right p a {
            color: pink;
        }

        .td_left {
            width: 100px;
            text-align: right;
            height: 45px;
        }

        .td_right {
            padding-left: 50px;
        }

        #username, #password, #email, #name, #tel, #birthday, #checkcode {
            width: 251px;
            height: 32px;
            border: 1px solid #A6A6A6;
            /*设置边框圆角*/
            border-radius: 5px;
            padding-left: 10px;
        }

        #checkcode {
            width: 110px;
        }

        #img_check {
            height: 32px;
            vertical-align: middle;
        }

        #btn_sub {
            width: 150px;
            height: 40px;
            background-color: #FFD026;
            border: 1px solid #FFD026;
        }

    </style>

</head>
<body>
<div class="rg_layout">
    <div class="rg_left">
        <p>新用户注册</p>
        <p>USER REGISTER</p>
    </div>
    <div class="rg_center">
        <div class="rg_form">
            <!--定义表单 form-->
            <form action="#" method="post">
                <table>
                    <tr>
                        <td class="td_left"><label for="username">用户名</label></td>
                        <td class="td_right"><input type="text" name="username" id="username" placeholder="请输入用户名"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="password">密码</label></td>
                        <td class="td_right"><input type="password" name="password" id="password" placeholder="请输入密码">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="email">Email</label></td>
                        <td class="td_right"><input type="email" name="email" id="email" placeholder="请输入邮箱"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="name">姓名</label></td>
                        <td class="td_right"><input type="text" name="name" id="name" placeholder="请输入姓名"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="tel">手机号</label></td>
                        <td class="td_right"><input type="text" name="tel" id="tel" placeholder="请输入手机号"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label>性别</label></td>
                        <td class="td_right">
                            <input type="radio" name="gender" value="male"> 男
                            <input type="radio" name="gender" value="female"> 女
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="birthday">出生日期</label></td>
                        <td class="td_right"><input type="date" name="birthday" id="birthday" placeholder="请输入出生日期">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="checkcode">验证码</label></td>
                        <td class="td_right"><input type="text" name="checkcode" id="checkcode" placeholder="请输入验证码">
                            <img id="img_check" src="img/verify_code.jpg">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" id="btn_sub" value="注册"></td>
                    </tr>
                </table>

            </form>
        </div>
    </div>
    <div class="rg_right">
        <p>已有账号?<a href="#">立即登录</a></p>
    </div>
</div>
</body>
</html>

```

