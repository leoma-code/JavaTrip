### JQuery 基础：

#### 一：概念： 一个JavaScript框架。简化JS开发

> jQuery是一个快速、简洁的JavaScript框架，是继Prototype之后又一个优秀的JavaScript代码库（或JavaScript框架）。jQuery设计的宗旨	是“write Less，Do More”，即倡导写更少的代码，做更多的事情。它封装JavaScript常用的功能代码，提供一种简便的JavaScript设计模式，优	化HTML文档操作、事件处理、动画设计和Ajax交互。

- **JavaScript框架：本质上就是一些js文件，封装了js的原生代码而已**



#### 二：快速入门

1. 步骤：

   1. 下载JQuery

      - **目前jQuery有三个大版本：**
        - 1.x：兼容ie678,使用最为广泛的，官方只做BUG维护，功能不再新增。因此一般项目来说，使用1.x版本就可以了，最终版本：1.12.4 (2016年5月20日)
        - 2.x：不兼容ie678，很少有人使用，官方只做BUG维护，功能不再新增。如果不考虑兼容低版本的浏览器可以使用2.x，最终版本：2.2.4 (2016年5月20日)
        - 3.x：不兼容ie678，只支持最新的浏览器。除非特殊要求，一般不会使用3.x版本的，很多老的jQuery插件不支持这个版本。目前该版本是官方主要更新维护的版本。最新版本：3.2.1（2017年3月20日）
      - **jquery-xxx.js 与 jquery-xxx.min.js区别：**
        - jquery-xxx.js：开发版本。给程序员看的，有良好的缩进和注释。体积大一些
        - jquery-xxx.min.js：生产版本。程序中使用，没有缩进。体积小一些。程序加载更快

   2. 导入JQuery的js文件：导入min.js文件

   3. 使用

      ```
      var div1 = $("#div1");
      alert(div1.html());
      ```

      

#### 三：JQuery对象和JS对象区别与转换

- JQuery对象在操作时，更加方便。
- JQuery对象和js对象方法不通用的.
- 两者相互转换
  - jq -- > js : jq对象[索引] 或者 jq对象.get(索引)
  - js -- > jq : $(js对象)

#### 四：选择器：筛选具有相似特征的元素(标签)

1. 基本操作学习：

   - **事件绑定**

     ```
     //1.获取b1按钮
     $("#b1").click(function(){
     		alert("abc");
     });
     ```

   - **入口函数**

     ```
     $(function () {
     
     });
     ```

     > window.onload 和 $(function) 区别
     >
     > - window.onload 只能定义一次,如果定义多次，后边的会将前边的覆盖掉
     > - $(function)可以定义多次的。

   - **样式控制：css方法**

     ```
     // $("#div1").css("background-color","red");
     $("#div1").css("backgroundColor","pink");
     ```

     

2. 分类

   - **基本选择器**

     - 标签选择器（元素选择器）

       - 语法：` $("html标签名")` 获得所有匹配标签名称的元素

     - id选择器 

       - 语法：` $("#id的属性值")` 获得与指定id属性值匹配的元素

     - 类选择器

       - 语法： `$(".class的属性值")` 获得与指定的class属性值匹配的元素

     - 并集选择器：

       - 语法： `$("选择器1,选择器2....")` 获取多个选择器选中的所有元素

       ```
       // 1.改变 id 为 one 的元素的背景色为 红色
       $("#b1").click(function () {
        		$("#one").css("backgroundColor", "red");
       });
       // 2.改变元素名为 <div> 的所有元素的背景色为 红色
       $("#b2").click(function () {
        		$("div").css("backgroundColor", "red");
       });
       //3.改变 class 为 mini 的所有元素的背景色为 红色
       $("#b3").click(function () {
       		$(".mini").css("backgroundColor", "red");
       });
       // 4.改变所有的<span>元素和 id 为 two 的元素的背景色为红色
       $("#b4").click(function () {
        		$("span, #two").css("backgroundColor", "red");
       });
       ```

       

   - **层级选择器**

     - 后代选择器

       - 语法： `$("A B ")` 选择A元素内部的所有B元素

     - 子选择器

       - 语法： `$("A > B") `选择A元素内部的所有B子元素

       ```
       // 1. 改变 <body> 内所有 <div> 的背景色为红色
       $("#b1").click(function () {
         $("body div").css("backgroundColor", "red");
       });
       
       // 2.改变 <body> 内子 <div> 的背景色为 红色
       $("#b2").click(function () {
         $("body > div").css("backgroundColor", "red");
       });
       ```

       

   - **属性选择器**

     - 属性名称选择器 

       - 语法：` $("A[属性名]") `包含指定属性的选择器

     - 属性选择器

       - 语法： `$("A[属性名='值']")` 包含指定属性等于指定值的选择器

     - 复合属性选择器

       - 语法： `$("A[属性名='值'][]...")` 包含多个属性条件的选择器

       ```
       // 1.含有属性title 的div元素背景色为红色
        $("#b1").click(function () {
            $("div[title]").css("backgroundColor", "red");
        });
       
        // 2. 属性title值等于test的div元素背景色为红色
        $("#b2").click(function () {
            $("div[title='test']").css("backgroundColor", "red");
        });
       
        // 3. 属性title值不等于test的div元素(没有属性title的也将被选中)背景色为红色
        $("#b3").click(function () {
            $("div[title!='test']").css("backgroundColor", "red");
        });
       
        // 4. 属性title值 以te开始 的div元素背景色为红色
        $("#b4").click(function () {
            $("div[title^='te']").css("backgroundColor", "red");
        });
       
        // 5. 属性title值 以est结束 的div元素背景色为红色
        $("#b5").click(function () {
            $("div[title$='est']").css("backgroundColor", "red");
        });
       
        // 6. 属性title值 含有es的div元素背景色为红色
        $("#b6").click(function () {
            $("div[title*='es']").css("backgroundColor", "red");
        });
       
        // 7. 选取有属性id的div元素，然后在结果中选取属性title值含有“es”的 div 元素背景色为红色
        $("#b7").click(function () {
            $("div[id][title*='es']").css("backgroundColor", "red");
        });
       ```

       

   - **过滤选择器**

     - 首元素选择器 

       - 语法： `:first `获得选择的元素中的第一个元素

     - 尾元素选择器 

       - 语法：` :last `获得选择的元素中的最后一个元素

     - 非元素选择器

       - 语法：` :not(selector) `不包括指定内容的元素

     - 偶数选择器

       - 语法：` :even `偶数，从 0 开始计数

     - 奇数选择器

       - 语法： `:odd `奇数，从 0 开始计数

     - 等于索引选择器

       - 语法： `:eq(index) `指定索引元素

     - 大于索引选择器 

       - 语法：` :gt(index)` 大于指定索引元素

     - 小于索引选择器 

       - 语法： `:lt(index)` 小于指定索引元素

     - 标题选择器

       - 语法：` :header` 获得标题（h1~h6）元素，固定写法

       ```
       // 1.改变第一个 div 元素的背景色为 红色
       $("#b1").click(function () {
         $("div:first").css("backgroundColor", "red");
       });
       
       // 2. 改变最后一个 div 元素的背景色为 红色
       $("#b2").click(function () {
         $("div:last").css("backgroundColor", "red");
       });
       
       // 3. 改变class不为 one 的所有 div 元素的背景色为 红色
       $("#b3").click(function () {
         $("div:not(.one)").css("backgroundColor","red");
       });
       
       // 4. 改变索引值为偶数的 div 元素的背景色为 红色
       $("#b4").click(function(){
         $("div:even").css("backgroundColor", "red");
       });
       
       // 5. 改变索引值为奇数的 div 元素的背景色为 红色
       $("#b5").click(function () {
         $("div:odd").css("backgroundColor", "red");
       });
       
       // 6.改变索引值为大于 3 的 div 元素的背景色为 红色
       $("#b6").click(function () {
         $("div:gt(3)").css("backgroundColor", "red");
       });
       
       // 7.改变索引值为等于 3 的 div 元素的背景色为 红色
       $("#b7").click(function () {
         $("div:eq(3)").css("backgroundColor", "red");
       });
       
       // 8.改变索引值为小于 3 的 div 元素的背景色为 红色
       $("#b8").click(function () {
         $("div:lt(3)").css("backgroundColor", "red");
       });
       
       // 9.改变所有的标题元素的背景色为 红色
       $("#b9").click(function () {
         $(":header").css("backgroundColor", "red");
       });
       
       ```

       

   - **表单过滤选择器**

     - 可用元素选择器 

       - 语法： `:enabled` 获得可用元素

     - 不可用元素选择器 

       - 语法： `:disabled `获得不可用元素

     - 选中选择器 

       - 语法：` :checked` 获得单选/复选框选中的元素

     - 选中选择器 

       - 语法：` :selected` 获得下拉框选中的元素

       ```
       // 1. 利用 jQuery 对象的 val() 方法改变表单内可用 <input> 元素的值
       $("#b1").click(function () {
         $("input[type='text']:enabled").val("aaaaaa");
       });
       
       // 2.利用 jQuery 对象的 val() 方法改变表单内不可用 <input> 元素的值
       $("#b2").click(function () {
         $("input[type='text']:disabled").val("bbbb");
       });
       
       // 3.利用 jQuery 对象的 length 属性获取复选框选中的个数
       $("#b3").click(function () {
         var length = $("input[type='checkbox']:checked").length;
         alert(length);
       });
       
       // 4. 利用 jQuery 对象的 length 属性获取下拉框选中的个数
       $("#b4").click(function () {
         var length = $("#job > option:selected").length;
         alert(length);
       });
       ```

       

#### 五：DOM操作

- **内容操作**
  1. `html()`: 获取/设置元素的标签体内容  <a><font>内容</font></a> --> <font>内容
  2. `text()`: 获取/设置元素的标签体纯文本内容  <a><font>内容</font></a> --> 内容
  3. `val()`： 获取/设置元素的value属性值

- **属性操作**

  - 通用属性操作
    - `attr()`: 获取/设置元素的属性
    - `removeAttr()`:删除属性
    - `prop()`:获取/设置元素的属性
    - `removeProp()`:删除属性

  > attr和prop区别？
  >
  > 1. 如果操作的是元素的固有属性，则建议使用prop
  > 2. 如果操作的是元素自定义的属性，则建议使用attr

  - 对class属性操作
    - `addClass()`:添加class属性值
    - `removeClass()`:删除class属性值
    - `toggleClass()`:切换class属性
      - `toggleClass("one")`: 
        - 判断如果元素对象上存在`class="one"`，则将属性值one删除掉。 如果元素对象上不存在`class="one"`，则添加

    - `css()`:

- **CRUD操作**
  - `append()`:父元素将子元素追加到末尾
    - 对象1.append(对象2): 将对象2添加到对象1元素内部，并且在末尾
  - `prepend()`:父元素将子元素追加到开头
    - 对象1.prepend(对象2):将对象2添加到对象1元素内部，并且在开头
  - `appendTo()`:
    - 对象1.appendTo(对象2):将对象1添加到对象2内部，并且在末尾
  - `prependTo()`：
    -  对象1.prependTo(对象2):将对象1添加到对象2内部，并且在开头
  - `after()`:添加元素到元素后边
    - 对象1.after(对象2)： 将对象2添加到对象1后边。对象1和对象2是兄弟关系
  - `before()`:添加元素到元素前边
    - 对象1.before(对象2)： 将对象2添加到对象1前边。对象1和对象2是兄弟关系
  - `insertAfter()`
    - 对象1.insertAfter(对象2)：将对象2添加到对象1后边。对象1和对象2是兄弟关系
  - `insertBefore()`
    - 对象1.insertBefore(对象2)： 将对象2添加到对象1前边。对象1和对象2是兄弟关系
  -  `remove()`:移除元素
    - 对象.remove():将对象删除掉
  - `empty()`:清空元素的所有后代元素。
    - 对象.empty():将对象的后代元素全部清空，但是保留当前对象以及其属性节点



---

### JQuery 高级

#### 动画

- **三种方式显示和隐藏元素**
  - 默认显示和隐藏方式

    - `show([speed,[easing],[fn]])`
      - 参数：
      - `speed`：动画的速度。三个预定义的值("slow","normal", "fast")或表示动画时长的毫秒数值(如：1000)
      - `easing`：用来指定切换效果，默认是"swing"，可用参数"linear"
        - swing：动画执行时效果是 先慢，中间快，最后又慢
        - linear：动画执行时速度是匀速的
      - `fn`：在动画完成时执行的函数，每个元素执行一次。

    - `hide([speed,[easing],[fn]])`
    - `toggle([speed],[easing],[fn])`	

  - 滑动显示和隐藏方式

    - `slideDown([speed],[easing],[fn])`
    - `slideUp([speed,[easing],[fn]])`
    - `slideToggle([speed],[easing],[fn])`

  - 淡入淡出显示和隐藏方式

    - `fadeIn([speed],[easing],[fn])`
    - `fadeOut([speed],[easing],[fn])`
    - `fadeToggle([speed,[easing],[fn]])`

#### 遍历

- js的遍历方式
  - for(初始化值;循环结束条件;步长)

- jq的遍历方式
  - `jq对象.each(callback)`
    - 语法：
      - `jquery对象.each(function(index,element){})`;
        - index:就是元素在集合中的索引
        - element：就是集合中的每一个元素对象
        - this：集合中的每一个元素对象
    - 回调函数返回值：
      - true:如果当前function返回为false，则结束循环(break)。
      - false:如果当前function返回为true，则结束本次循环，继续下次循环(continue)
  - `$.each(object, [callback])`
  - `for..of: `jquery 3.0 版本之后提供的方式

​				`for(元素对象 of 容器对象)`

​		

#### 事件绑定

- jquery标准的绑定方式

  1. jq对象.事件方法(回调函数)；

     > 注：如果调用事件方法，不传递回调函数，则会触发浏览器默认行为。
     >
     > 表单对象.submit();//让表单提交

  2. on绑定事件/off解除绑定

     - jq对象.on("事件名称",回调函数)
     - jq对象.off("事件名称")
       - 如果off方法不传递任何参数，则将组件上的所有事件全部解绑

  3. 事件切换：toggle

     - `jq对象.toggle(fn1,fn2...)`
       - 当单击jq对象对应的组件后，会执行fn1.第二次点击会执行fn2.....

     > 注意：1.9版本 .toggle() 方法删除,jQuery Migrate（迁移）插件可以恢复此功能。
     >
     > ```
     > <script src="../js/jquery-migrate-1.0.0.js" type="text/javascript" charset="utf-8"></script>
     > ```



#### 插件：增强JQuery的功能

​		1. 实现方式：

​			1. $.fn.extend(object) 

​				* 增强通过Jquery获取的对象的功能 $("#id")

​			2. $.extend(object)

​				* 增强JQeury对象自身的功能 $/jQuery



​			