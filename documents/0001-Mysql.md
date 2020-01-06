##### 一、SQL简介
> 结构性查询语言(Structured Query Language)，其实就是定义了操作所有`关系型数据库`的规则。每一种数据库操作方式存在不一样的地方，成为“方言”。

##### 二、SQL分类
###### 1. DDL(Data Definition Language)<br>

    数据定义语言,用来定义数据库对象：数据库、表、列等。
    关键字：`create、drop、 alter等`

###### 2. DML(Data Manipulation Language)<br>

    数据库操作语言，用来对数据库中表的数据进行增删改。
    关键字：`insert、delete、update等`
    
###### 3. DQL(Date Query Language)<br>

    数据库查询语言，用来查询数据表中的数据。
    关键字：`select、where等`

###### 4. DCL(Data Control Language)<br>

    数据控制语言，用来定义数据库访问权限和安全级别，及创建用户。
    关键字：`GRANT、REVOKE等`

##### 三、DDL:操作数据库、表

###### 操作数据库
    
    1. C (Create)：创建
        * 创建数据库
            * create database 数据库名称;
            * create database if not exists db1;
            * create database db2 character set gbk;
            * create database if not exists db3 character set gbk;     
    2. R (Retrieve)：查询
        * 查询所有数据库的名称
            * show databases;
        * 查看某个数据库的字符集：查看某个数据库的创建语句
            * show create database 数据库名称;
    3. U (Update)：修改
        * 修改数据库字符集
            * alter database db1 character set gbk;
    4. D (Delete)：删除
        * 删除数据库
            * drop database db1;
            * drop database if exists db1;
    5. 使用数据库
        * 查询当前正在使用的数据库名称
            * select database();
        * 使用数据库
            * use db1;
---     
###### 操作表
    1. C (Create)：创建
        * 语法
            * create table 表名 (
                列名1 数据类型1，
                列名2 数据类型2，
                ...
                列名n 数据类型n
            );
            * 常用数据库类型
                1. int : 整数类型
                    * age int,
                2. double : 小数类型
                    * score double(5,2) 最多5位，保留两位小数
                3. date : 日期，只包含年月日 yyyy-MM-dd
                4. datetime: 日期，包含年月日时分秒 yyyy-MM-dd HH:mm:ss
                5. timestamp: 时间戳类型 包含年月日时分秒 yyyy-MM-dd HH:mm:ss
                    * 如果将来不给这个字段复制，或复制为null,则默认使用当前系统时间来赋值
                6. varchar : 字符串类型
                    * name varchar(20) 表示姓名最大20个字符
                    * zhangsan 8个字符  张三 2个字符
        * 创建表
            * create table student (
                id int,
                name varchar(32),
                age int,
                score double(4,1),
                birthday date,
                create_time timestamp
            );
            * create table stu like student; 复制表
    
    2. R (Retrieve)：查询
        * 查询某个数据库中所有表
            * show tables;
        * 查询表结构
            * desc 表名;
            
    3. U (Update)：修改
        * 修改表的名称
            * alter table student rename to stu;
        * 修改表的字符集
            * show create table stu; 查看表的字符集
            * alter table stu character set gbk;
        * 添加一列
            * alter table 表名 add 列名 数据类型; 
        * 修改烈的名称、类型
            * alter table 表名 change 列名 新列名 varchar(20);
            * alter table stu modify sex varchar(8);
        * 删除列
            * alter table stu drop sex;
            
    4. D (Delete)：删除
        * 删除表
            * drop table student;
            * drop table if exists student;
---
###### DML：增删改表中数据

    1. 添加数据
        * innsert into 表名 (列名1, 列名2) values (值1,值2);
            * 1. 列名需要和值一一对应
            * 2. 如果表名后，不定义列名，则默认给所有列添加值
            * 3. 除了数字类型，其他类型需要使用引号（单双都可以）
    2. 删除数据
        * delete from 表名 [where 条件];
        * truncate table 表名;
        * 注意：
            1. 如果不加条件会删除所有记录
            2. 如果要删除所有记录
                * delete from 表名； -- 不推荐，有多少条记录就会执行多少次删除操作
                * truncate table 表名; -- 推荐，效率更高，先删除表，然后再创建一张一样的表
    3. 修改数据
        * update 表名 set 列名1 = 值1, 列名2 = 值2 [where 条件];
        * 注意
            如果不加条件将会把表中所有记录修改
---  
##### DQL：查询表中数据
- 语法：<br>
```
    select
        字段列表
    from
        表名
    where
        条件列表
    group by
        分组字段
    having
        分组之后的条件
    order by
        排序
    limit
        分页限定
```    
```
    1. 去重
        * SELECT DISTINCT name FROM stu;
    2. 计算列
        * SELECT name, age, score, age + score FROM stu;
        * SELECT name, age, score, age + IFNULL(score, 0) FROM stu;
    3. 起别名
        * SELECT name AS '姓名', age '年龄', score '分数', age + IFNULL(score, 0) '年龄分数之和' FROM stu;
```
```
    SELECT * FROM stu WHERE age = 18;
    SELECT * FROM stu WHERE age > 18;
    SELECT * FROM stu WHERE age < 18;
    SELECT * FROM stu WHERE age >= 18;
    SELECT * FROM stu WHERE age <= 18;
    SELECT * FROM stu WHERE age <> 18;
    SELECT * FROM stu WHERE age >= 18 AND age <= 30;
    SELECT * FROM stu WHERE age BETWEEN 18 AND 30;
    SELECT * FROM stu WHERE age = 18 OR age = 16;
    SELECT * FROM stu WHERE age IN (18, 16);
    SELECT * FROM stu WHERE score IS NULL;
    SELECT * FROM stu WHERE score IS NOT NULL;
    SELECT * FROM stu WHERE name LIKE '%张%';
    SELECT * FROM stu WHERE name LIKE '__'; # _ 表示任意
```
    

- 1. 排序查询
    * 语法：`order by` 子句
        * `order by` 排序字段1 排序方式1, 排序字段2 排序方式2;
        * `SELECT * FROM stu ORDER BY score ASC, age DESC;`
    * 排序方式：
        * `ASC` 升序，默认
        * `DESC` 降序
    * 注意：
        * 如果有多个排序条件，则当前边的条件值一样时，才会判断第二个条件

- 2. 聚合函数
        - 概念：将一列书奴作为一个整体，进行纵向的计算。
        - `count`：计算个数
            - `select count(列名) from 表名;`
            - 一般选择非空的列，主键
        - `max`：计算最大值
            - `select max(列名) from 表名;`
        - `min`：计算最小值
            - `select min(列名) from 表名;`
        - `sum`：求和
            - `select sum(列名) from 表名;`
        - `avg`：计算平均值
            - `select avg(列名) from 表名;`
    - 注意：
        - 聚合函数会排除`null`值
- 3. 分组查询
    - 语法：
        - `group by` 分组字段;
            - `SELECT sex, AVG(score) '平均分', COUNT(id) '人数' FROM stu GROUP BY sex;`
            - `SELECT sex, AVG(score) '平均分', COUNT(id) '人数' FROM stu where score > 70 GROUP BY sex;`
            - `SELECT sex, AVG(score) '平均分', COUNT(id) '人数' FROM stu where score > 70 GROUP BY sex having COUNT(id) > 2;`
    - 注意：
        - 分组之后查询的字段：分组字段、聚合函数
        - `where`和`having`的区别？
            - `where`在分组之前进行限定，如果不满足条件，则不参与分组。`having`在分组之后进行限定，如果不满足结果，则不会被查询出来
            - `where`后不可以跟聚合函数，`having`可以进行聚合函数的判断
- 4. 分页查询
    - 语法：
        - limit 开始索引, 每页查询的条数;
        - `SELECT * FROM stu LIMIT 0, 2;`


--- 
##### 约束
- 概念：对标中的数据进行限定，保证数据的正确性、有效性和完整性
- 分类：
    - 主键约束 `primary key`
        > 注意：<br>
        >> 1. 非空且唯一
        >> 2. 一张表只能有一个字段为主键
        >> 3. 主键就是标中记录的唯一标识
    <br>
    
        - 创建表时添加
        ```
            CREATE TABLE student (
            	id int PRIMARY KEY, -- 添加主键约束
            	name VARCHAR(20) NOT NULL, -- 添加非空约束
            	phone VARCHAR(11) UNIQUE -- 添加唯一约束
            );
        ```
        - 创建完成后添加
        ```
        ALTER TABLE student MODIFY id INT PRIMARY KEY;
        ```
        - 删除主键
        ```
        ALTER TABLE student DROP PRIMARY KEY;
        ```
        - 自动增长
            - 概念：如果某一列时数值类型的，使用`auto_increment`可以来完成值的自动曾长
            - 在创建表时，添加主键约束，并完成主键自动增长
            ```
            ALTER TABLE student MODIFY id INT AUTO_INCREMENT;
            ```
            - 删除自动增长
            ```
            ALTER TABLE student MODIFY id INT;
            ```
            
    - 非空约束 `not null`
        1. 创建表的时候添加
        ```
        CREATE TABLE student (
        	id int,
        	name VARCHAR(20) NOT NULL, -- 添加非空约束
        );
        ```
        2. 创建完后添加、删除约束
        ```
        alter table student modify name varchar(20); # 删除
        alter table student modify name varchar(20) not null; #添加
        ```
    - 唯一约束 `unique`
       
        1. 创建表的时候添加
        ```
            CREATE TABLE student (
            	id int,
            	name VARCHAR(20) NOT NULL, -- 添加非空约束
            	phone VARCHAR(11) UNIQUE -- 添加唯一约束
            );
        ```
        2. 创建完后添加
        ```
        alter table student modify phone varchar(20) unique;
        ```
        3. 删除
        ```
        alter table student drop index phone;
        ```
        > 注意：<br>
        mysql中唯一约束限定的值，可以有多个null
        <br>
        
    - 外键约束 `foreign key`
        - 概念：在从表中与主表主键对应的那一列
        - 主表: 一方，用来约束别人的表
        - 从表: 多方，被别人约束的表
        - 创建时添加
        ```
        -- 一方，主表
        create table department(
             id int primary key auto_increment,
             dep_name varchar(20),
             dep_location varchar(20)
        );
        -- 多方，从表
        create table employee(
            id int primary key auto_increment, name varchar(20),
            age int,
            dep_id int, -- 外键对应主表的主键
            -- 创建外键约束 emp_depid_fk 外键约束名称
            constraint emp_depid_fk foreign key (dep_id) references department(id)
        )
        
        -- 添加2个部门
        insert into department values(null, '研发部','广州'),(null, '销售部', '深圳');
        
        select * from department;
        
        -- 添加员工,dep_id 表示员工所在的部门
        INSERT INTO employee (NAME, age, dep_id) VALUES ('张三', 20, 1); 
        INSERT INTO employee (NAME, age, dep_id) VALUES ('李四', 21, 1); 
        INSERT INTO employee (NAME, age, dep_id) VALUES ('王五', 20, 1);
        INSERT INTO employee (NAME, age, dep_id) VALUES ('老王', 20, 2); 
        INSERT INTO employee (NAME, age, dep_id) VALUES ('大王', 22, 2); 
        INSERT INTO employee (NAME, age, dep_id) VALUES ('小王', 18, 2);
        ```
        - 删除 employee 表的 emp_depid_fk 外键
        ```
        alter table employee drop foreign key emp_depid_fk;
        ```
        - 在 employee 表情存在的情况下添加外键
        ```
        alter table employee add constraint emp_depid_fk foreign key (dep_id) references department(id);
        ```
        - 级联操作
            - 在修改和删除主表的主键时，同时更新或删除副表的外键值，称为***级联操作***
            - 语法：
                - ON UPDATE CASCADE： 级联更新，只能是创建表的时候创建级联关系。更新主表中的主键，从表中的外键 列也自动同步更新
                - ON DELETE CASCADE：级联删除
                ```
                -- 删除 employee 表，重新创建 employee 表，添加级联更新和级联删除
                drop table employee;
                
                create table employee(
                    id int primary key auto_increment, name varchar(20),
                    age int,
                    dep_id int, -- 外键对应主表的主键
                    -- 创建外键约束
                    constraint emp_depid_fk foreign key (dep_id) references department(id) on update cascade on delete cascade
                )
                ```


---
#### 数据库设计
##### 多表之间的关系
- 一对一：
    - 如：人和身份证
        - 一个人只有一个身份证，一个身份证只能对应一个人
- 一对多（多对一）：
    - 如：部门和员工
        - 一个部门有多个员工，一个员工只能对应一个部门
        ```
        -- 创建旅游线路分类表 tab_category -- cid 旅游线路分类主键，自动增长
        -- cname 旅游线路分类名称非空，唯一，字符串 100 
        create table tab_category (
          cid int primary key auto_increment,
          cname varchar(100) not null unique
        );
        -- 添加旅游线路分类数据:
        insert into tab_category (cname) values ('周边游'), ('出境游'), ('国内游'), ('港澳游');
        
        select * from tab_category;
        
        -- 创建旅游线路表 tab_route
        /*
        rid 旅游线路主键，自动增长
        rname 旅游线路名称非空，唯一，字符串 100 price 价格
        rdate 上架时间，日期类型 cid 外键，所属分类
        */
        create table tab_route(
          rid int primary key auto_increment,
          rname varchar(100) not null unique,
          price double,
          rdate date,
          cid int,
          foreign key (cid) references tab_category(cid)
        );
        
        -- 添加旅游线路数据
        INSERT INTO tab_route VALUES
        (NULL, '【厦门+鼓浪屿+南普陀寺+曾厝垵 高铁 3 天 惠贵团】尝味友鸭面线 住 1 晚鼓浪屿', 1499, '2018-01-27', 1),
        (NULL, '【浪漫桂林 阳朔西街高铁 3 天纯玩 高级团】城徽象鼻山 兴坪漓江 西山公园', 699, '2018-02-22', 3),
        (NULL, '【爆款¥1699 秒杀】泰国 曼谷 芭堤雅 金沙岛 杜拉拉水上市场 双飞六天【含送签费 泰风情 广州 往返 特价团】', 1699, '2018-01-27', 2),
        (NULL, '【经典•狮航 ¥2399秒杀】巴厘岛双飞五天 抵玩【广州往返 特价团】', 2399, '2017-12-23', 2),
        (NULL, '香港迪士尼乐园自由行2天【永东跨境巴士广东至迪士尼去程交通+迪士尼一日门票+香港如心海景酒店 暨会议中心标准房1晚住宿】', 799, '2018-04-10', 4);
        
        select * from tab_route;
        ```
- 多对多：
    - 如：学生和课程
        - 一个学生可以选择很多门课程，一个课程也可以被很多学生选择
        - 对于多对多的关系我们需要增加一张中间表来维护他们之间的关系
        ```
        /*
        创建用户表 tab_user
        uid 用户主键，自增长
        username 用户名长度 100，唯一，非空 password 密码长度 30，非空
        name 真实姓名长度 100
        birthday 生日
        sex 性别，定长字符串 1
        telephone 手机号，字符串 11
        email 邮箱，字符串长度 100
        */
        create table tab_user (
          uid int primary key auto_increment,
          username varchar(100) unique not null,
          password varchar(30) not null,
          name varchar(100),
          birthday date,
          sex char(1) default '男',
          telephone varchar(11),
          email varchar(100)
        );
        
        -- 添加用户数据
        INSERT INTO tab_user VALUES
        (NULL, 'cz110', 123456, '老王', '1977-07-07', '男', '13888888888', '66666@qq.com'), 
        (NULL, 'cz119', 654321, '小王', '1999-09-09', '男', '13999999999', '99999@qq.com');
        
        select * from tab_user;
        
        /*
        创建收藏表 tab_favorite 
        rid 旅游线路 id，外键
        date 收藏时间 
        uid 用户 id，外键
        rid 和 uid 不能重复，设置复合主键，同一个用户不能收藏同一个线路两次 
        */
        create table tab_favorite (
            rid int,
            date datetime,
            uid int,
            -- 创建复合主键
            primary key(rid,uid),
            foreign key (rid) references tab_route(rid), 
            foreign key(uid) references tab_user(uid)
        );
        
        -- 增加收藏表数据
        INSERT INTO tab_favorite VALUES
        (1, '2018-01-01', 1), -- 老王选择厦门
        (2, '2018-02-11', 1), -- 老王选择桂林 
        (3, '2018-03-21', 1), -- 老王选择泰国 
        (2, '2018-04-21', 2), -- 小王选择桂林 
        (3, '2018-05-08', 2), -- 小王选择泰国 
        (5, '2018-06-02', 2); -- 小王选择迪士尼
        
        select * from tab_favorite;
        ```
- 删除关系表
    ```
    SET foreign_key_checks = 0; -- 先设置外键约束检查关闭
     
    DROP TABLE tab_category;
    DROP TABLE tab_route;
    	
    SET foreign_key_checks = 1; -- 开启外键约束检查，以保持表结构完整性
    ```
---
##### 范式
- 什么是范式:
    - 好的数据库设计对数据的存储性能和后期的程序开发，都会产生重要的影响。建立科学的，规范的数据库就需 要满足一些规则来优化数据的设计和存储，这些规则就称为范式。
- 三大范式:
    - 目前关系数据库有六种范式:第一范式(1NF)、第二范式(2NF)、第三范式(3NF)、巴斯-科德范式(BCNF)、 第四范式(4NF)和第五范式(5NF，又称完美范式)。
    - 满足最低要求的范式是第一范式(1NF)。在第一范式的基础上进一步满足更多规范要求的称为第二范式(2NF，) 其余范式以次类推。一般说来，数据库只需满足第三范式(3NF)就行了。
    - 分类：
        - 第一范式(1NF)：原子性:表中每列不可再拆分。
        - 第二范式(2NF)：不产生局部依赖，一张表只描述一件事情
        - 第三范式(3NF)：不产生传递依赖，表中每一列都直接依赖于主键。而不是通过其它列间接依赖于主键。

---
##### 数据库的备份和还原
- 命令行：
    - 备份：
    ```
    mysqldump -uroot -proot db1 > /Users/leo/Desktop/db1.sql
    ```
    - 还原：
        - 登陆mysql
        - 创建数据库
        - 使用数据库
        - 使用source命令还原数据
        ```
        source /Users/leo/Desktop/db1.sql
        ```
- 图形界面方式
    - 备份
        - 选中数据库，右键 ”备份/导出” 指定导出路径，保存成.sql 文件即可。
    - 还原
        - 数据库列表区域右键“执行 SQL 脚本”， 指定要执行的 SQL 文件，执行即可

##### 多表查询
- 数据准备
        
        -- 创建部门表
        create table dept(
            id int primary key auto_increment,
            name varchar(20)
        );
        insert into dept (name) values ('开发部'),('市场部'),('财务部'); 
        -- 创建员工表
        create table emp (
            id int primary key auto_increment, 
            name varchar(10),
            gender char(1),
            salary double,
            join_date date,
            dept_id int,
            foreign key (dept_id) references dept(id) -- 外键，关联部门表(部门表的主键)
        );
    
        insert into emp(name,gender,salary,join_date,dept_id) values('孙悟空','男 ',7200,'2013-02-24',1);
        insert into emp(name,gender,salary,join_date,dept_id) values('猪八戒','男 ',3600,'2010-12-02',2);
        insert into emp(name,gender,salary,join_date,dept_id) values('唐僧','男',9000,'2008-08-08',2);
        insert into emp(name,gender,salary,join_date,dept_id) values('白骨精','女 ',5000,'2015-10-07',3);
        insert into emp(name,gender,salary,join_date,dept_id) values('蜘蛛精','女 ',4500,'2011-03-14',1);
    
        SELECT * FROM dept;
        SELECT * FROM emp;
        SELECT * FROM emp, dept; -- 笛卡尔积现象
      

- 多表查询分类
    - 内连接查询：
        - 查询的是两表交集部分
        - 隐式内连接：使用where条件消除无用数据
         ```
         -- 查询所有员工信息和对应的部门信息
        SELECT * FROM emp, dept WHERE `emp`.`dept_id` = `dept`.`id`;
        
        SELECT emp.id, emp.name, emp.gender, dept.`name`  FROM emp, dept WHERE `emp`.`dept_id` = `dept`.`id`;
        
        SELECT
        	    t1.id, 	-- id
        	    t1.`name` '姓名', -- 姓名
        	    t1.gender '性别', -- 性别
        	    t2.`name` '部门'	 -- 部门
        FROM
            	emp t1, dept t2
        WHERE
            	t1.dept_id = t2.id;
         ```
        - 显示内连接
        ```
        语法：select 字段列表 from 表名1 [inner] join 表名2 on 条件
        
        SELECT
        	* 
        FROM
        	emp
        INNER JOIN
        	dept
        ON
        	emp.dept_id = dept.id;
        ```
    - 外连接查询：
        - 左外连接
        ```
        语法：select 字段列表 from 表1 left [outer] join 表2 on 条件;
        * 查询的是左表所有数据以及其交集部分
        
        -- 查询所有员工信息，如果员工有部门则查询部门名称，如果没有则不显示部门信息
        SELECT 
        	e.*,   -- 员工所有信息
        	d.name -- 部门名称
        FROM
        	emp e
        LEFT JOIN
        	dept d
        ON 
        	e.dept_id = d.id;
        ```
        - 右外连接
        ```
        语法：select 字段列表 from 表1 right [outer] join 表2 on 条件;
        * 查询的是右表所有数据以及其交集部分
        
        SELECT 
        	e.*,   -- 员工所有信息
        	d.name -- 部门名称
        FROM
        	emp e
        RIGHT JOIN
        	dept d
        ON 
        	e.dept_id = d.id;
        ```
    - 子查询：
        - 概念：查询中嵌套查询，称嵌套的查询为子查询
        ```
        -- 工资最高的员工信息
        SELECT MAX(emp.salary) FROM emp;
        SELECT * FROM emp WHERE emp.salary = 9000;
        -- 一条sql查询
        SELECT * FROM emp WHERE emp.salary = (SELECT MAX(emp.salary) FROM emp);

        ```
        - 子查询不同情况
            - 子查询结果是单行单列的：
            ```
            子查询可以作为条件，使用运算符判断
           
            -- 查询工资小于平均工资的人
            SELECT 
            	*
            FROM
            	emp
            WHERE
            	emp.salary < 
            (SELECT AVG(emp.salary) FROM emp);
            ```
            - 子查询的结果是多行单列的：
            ```
            -- 查询 财务部 和 市场部 的所有员工信息
            SELECT id FROM dept WHERE dept.`name` = '财务部' OR dept.`name` = '市场部';
            SELECT * FROM emp WHERE emp.dept_id = 3 OR emp.dept_id = 2;
            SELECT * FROM emp WHERE emp.dept_id IN (2, 3);
            -- 子查询
            SELECT * FROM emp WHERE emp.dept_id IN (SELECT id FROM dept WHERE dept.`name` = '财务部' OR dept.`name` = '市场部');
            ```
            - 子查询的结果是多行多列的：
                - 可以作为虚拟表
            ```
            -- 查询入职日期是2011-11-11之后的员工信息和部门信息
            SELECT * FROM emp WHERE emp.join_date > '2011-11-11';
            -- 子查询
            SELECT 
            	t1.*,
            	t2.name
            FROM 
            	(SELECT * FROM emp WHERE emp.join_date > '2011-11-11') t1,
            	dept t2
            WHERE
            	t1.dept_id = t2.id;
            -- 子查询(内连接)
            SELECT 
            	t1.*,
            	t2.name
            FROM
            	(SELECT * FROM emp WHERE emp.join_date > '2011-11-11') t1
            INNER JOIN
            	dept t2
            ON
            	t1.dept_id = t2.id;
            -- 子查询(左外连接)
            SELECT
            	t1.*, -- 员工信息
            	t2.name -- 部门名称
            FROM 
            	(SELECT * FROM emp WHERE emp.join_date > '2011-11-11') t1
            LEFT JOIN
            	dept t2
            ON
            	t1.dept_id = t2.id;
            ```
            
##### 练习
- 数据准备
```
-- 部门表
CREATE TABLE dept (
  id INT PRIMARY KEY PRIMARY KEY, -- 部门id
  dname VARCHAR(50), -- 部门名称
  loc VARCHAR(50) -- 部门所在地
);

-- 添加4个部门
INSERT INTO dept(id,dname,loc) VALUES 
(10,'教研部','北京'),
(20,'学工部','上海'),
(30,'销售部','广州'),
(40,'财务部','深圳');



-- 职务表，职务名称，职务描述
CREATE TABLE job (
  id INT PRIMARY KEY,
  jname VARCHAR(20),
  description VARCHAR(50)
);

-- 添加4个职务
INSERT INTO job (id, jname, description) VALUES
(1, '董事长', '管理整个公司，接单'),
(2, '经理', '管理部门员工'),
(3, '销售员', '向客人推销产品'),
(4, '文员', '使用办公软件');



-- 员工表
CREATE TABLE emp (
  id INT PRIMARY KEY, -- 员工id
  ename VARCHAR(50), -- 员工姓名
  job_id INT, -- 职务id
  mgr INT , -- 上级领导
  joindate DATE, -- 入职日期
  salary DECIMAL(7,2), -- 工资
  bonus DECIMAL(7,2), -- 奖金
  dept_id INT, -- 所在部门编号
  CONSTRAINT emp_jobid_ref_job_id_fk FOREIGN KEY (job_id) REFERENCES job (id),
  CONSTRAINT emp_deptid_ref_dept_id_fk FOREIGN KEY (dept_id) REFERENCES dept (id)
);

-- 添加员工
INSERT INTO emp(id,ename,job_id,mgr,joindate,salary,bonus,dept_id) VALUES 
(1001,'孙悟空',4,1004,'2000-12-17','8000.00',NULL,20),
(1002,'卢俊义',3,1006,'2001-02-20','16000.00','3000.00',30),
(1003,'林冲',3,1006,'2001-02-22','12500.00','5000.00',30),
(1004,'唐僧',2,1009,'2001-04-02','29750.00',NULL,20),
(1005,'李逵',4,1006,'2001-09-28','12500.00','14000.00',30),
(1006,'宋江',2,1009,'2001-05-01','28500.00',NULL,30),
(1007,'刘备',2,1009,'2001-09-01','24500.00',NULL,10),
(1008,'猪八戒',4,1004,'2007-04-19','30000.00',NULL,20),
(1009,'罗贯中',1,NULL,'2001-11-17','50000.00',NULL,10),
(1010,'吴用',3,1006,'2001-09-08','15000.00','0.00',30),
(1011,'沙僧',4,1004,'2007-05-23','11000.00',NULL,20),
(1012,'李逵',4,1006,'2001-12-03','9500.00',NULL,30),
(1013,'小白龙',4,1004,'2001-12-03','30000.00',NULL,20),
(1014,'关羽',4,1007,'2002-01-23','13000.00',NULL,10);



-- 工资等级表
CREATE TABLE salarygrade (
  grade INT PRIMARY KEY,   -- 级别
  losalary INT,  -- 最低工资
  hisalary INT -- 最高工资
);

-- 添加5个工资等级
INSERT INTO salarygrade(grade,losalary,hisalary) VALUES 
(1,7000,12000),
(2,12010,14000),
(3,14010,20000),
(4,20010,30000),
(5,30010,99990);

-- 需求：

-- 1.查询所有员工信息。查询员工编号，员工姓名，工资，职务名称，职务描述
SELECT
	t1.id,
	t1.ename,
	t1.salary,
	t1.dept_id,
	t2.jname,
	t2.description
FROM
	emp t1
LEFT JOIN
	job t2
ON
	t1.job_id = t2.id;


-- 2.查询员工编号，员工姓名，工资，职务名称，职务描述，部门名称，部门位置
SELECT
	t1.*,
	t2.dname,
	t2.loc
FROM
	(SELECT
	t1.id,
	t1.ename,
	t1.salary,
	t1.dept_id,
	t2.jname,
	t2.description
	FROM
		emp t1
	LEFT JOIN
		job t2
	ON
	t1.job_id = t2.id) t1,
	dept t2
WHERE t1.dept_id = t2.id;

   
-- 3.查询员工姓名，工资，工资等级
SELECT 
	t1.ename,
	t1.salary,
	t2.losalary,
	t2.hisalary
FROM
	emp t1,
	salarygrade t2
WHERE
	t1.salary BETWEEN t2.losalary AND t2.hisalary;

-- 4.查询员工姓名，工资，职务名称，职务描述，部门名称，部门位置，工资等级
SELECT
	t1.*,
	t2.losalary,
	t2.hisalary
FROM
	(SELECT
	t1.ename,
	t1.salary,
	t1.jname,
	t1.description,
	t2.dname,
	t2.loc
	FROM
		(SELECT
		t1.id,
		t1.ename,
		t1.salary,
		t1.dept_id,
		t2.jname,
		t2.description
		FROM
			emp t1
		LEFT JOIN
			job t2
		ON
		t1.job_id = t2.id) t1,
		dept t2
	WHERE t1.dept_id = t2.id) t1
LEFT JOIN
	salarygrade t2
ON
	t1.salary BETWEEN t2.losalary AND t2.hisalary;


-- 5.查询出部门编号、部门名称、部门位置、部门人数
SELECT emp.dept_id, COUNT(id) count FROM emp GROUP BY emp.dept_id;

SELECT
	t1.*,
	t2.count
FROM
	dept t1
LEFT JOIN
	(SELECT emp.dept_id, COUNT(id) count FROM emp GROUP BY emp.dept_id) t2
ON
	t1.id = t2.dept_id;

 
-- 6.查询所有员工的姓名及其直接上级的姓名,没有领导的员工也需要查询
SELECT 
	t1.ename,
	t2.ename
FROM
	emp t1
LEFT JOIN
	(SELECT emp.id, emp.ename, emp.mgr FROM emp) t2
ON
	t1.mgr = t2.id; 


```

##### 事务
- 事务的基本介绍
    - 概念：如果一个包含多个步骤的业务操作被事务管理，那么这些操作要么同时成功，要么同时失败。
    - 操作：
        - 开启事务: start transaction;
        - 回滚: rollback;
        - 提交: commit;
    - MySQL数据库中事务默认自动提交
	    - 事务提交的两种方式：
			- 自动提交：
				- mysql就是自动提交的
			    - 一条DML(增删改)语句会自动提交一次事务。
		    - 手动提交：
			    - Oracle 数据库默认是手动提交事务
			    - 需要先开启事务，再提交
		- 修改事务的默认提交方式：
			- 查看事务的默认提交方式：`SELECT @@autocommit`; -- 1 代表自动提交  0 代表手动提交
			- 修改默认提交方式： `set @@autocommit = 0`;
- 事务的四大特征
    - 原子性：是不可分割的最小操作单位，要么同时成功，要么同时失败
    - 持久性：当事务提交或回滚后，数据库会持久化保存数据
    - 隔离性：多个事务之间互相独立
    - 一致性：事务操作前后，数据总量不变
- 事务的隔离级别（了解）
    - 概念：多个事务之间是隔离的，相互独立的。但是如果多个事务操作同一批数据，则会引发一些问题，设置不同的隔离级别就可以解决这些问题
    - 存在问题：
        - 脏读：一个事务读取到另一个事务中没有提交的数据
        - 不可重复读（虚读）：在同一个事务中，两次读取到的数据不一样
        - 幻读：一个事务操作(DML)数据表中所有记录，另一个事务添加了一条数据，则第一个事务查询不到自己的修改
    - 隔离级别：
        - `read uncommitted`：读未提交
            - 产生的问题：赃读、不可重复读、幻读
        - `read committed`: 读已提交(Oracle)
            - 产生的问题：不可重复读、幻读
        - `repeatable read`: 可重复读(MySql默认)
            - 产生的问题：幻读
        - `serializable`: 串行化
            - 可以解决所有问题
        
        * 注意：隔离级别从小到大安全性越来越高，但是效率越来越低
			* 数据库查询隔离级别：
				* `select @@tx_isolation;`
			* 数据库设置隔离级别：
				* `set global transaction isolation level  级别字符串;`
		* 演示：
		```
            set global transaction isolation level read uncommitted;
			start transaction;
			-- 转账操作
			update account set balance = balance - 500 where id = 1;
			update account set balance = balance + 500 where id = 2;
        ```
        
#### DCL：
	* SQL分类：
		1. DDL：操作数据库和表
		2. DML：增删改表中数据
		3. DQL：查询表中数据
		4. DCL：管理用户，授权

	* DBA：数据库管理员

	* DCL：管理用户，授权
		1. 管理用户
			1. 添加用户：
				* 语法：CREATE USER '用户名'@'主机名' IDENTIFIED BY '密码';
			2. 删除用户：
				* 语法：DROP USER '用户名'@'主机名';
			3. 修改用户密码：
				
				UPDATE USER SET PASSWORD = PASSWORD('新密码') WHERE USER = '用户名';
				UPDATE USER SET PASSWORD = PASSWORD('abc') WHERE USER = 'lisi';
				
				SET PASSWORD FOR '用户名'@'主机名' = PASSWORD('新密码');
				SET PASSWORD FOR 'root'@'localhost' = PASSWORD('123');

				* mysql中忘记了root用户的密码？
					1. cmd -- > net stop mysql 停止mysql服务
						* 需要管理员运行该cmd

					2. 使用无验证方式启动mysql服务： mysqld --skip-grant-tables
					3. 打开新的cmd窗口,直接输入mysql命令，敲回车。就可以登录成功
					4. use mysql;
					5. update user set password = password('你的新密码') where user = 'root';
					6. 关闭两个窗口
					7. 打开任务管理器，手动结束mysqld.exe 的进程
					8. 启动mysql服务
					9. 使用新密码登录。
			4. 查询用户：
				-- 1. 切换到mysql数据库
				USE myql;
				-- 2. 查询user表
				SELECT * FROM USER;
				
				* 通配符： % 表示可以在任意主机使用用户登录数据库

		2. 权限管理：
			1. 查询权限：
				-- 查询权限
				SHOW GRANTS FOR '用户名'@'主机名';
				SHOW GRANTS FOR 'lisi'@'%';

			2. 授予权限：
				-- 授予权限
				grant 权限列表 on 数据库名.表名 to '用户名'@'主机名';
				-- 给张三用户授予所有权限，在任意数据库任意表上
				
				GRANT ALL ON *.* TO 'zhangsan'@'localhost';
			3. 撤销权限：
				-- 撤销权限：
				revoke 权限列表 on 数据库名.表名 from '用户名'@'主机名';
				REVOKE UPDATE ON db3.`account` FROM 'lisi'@'%';
