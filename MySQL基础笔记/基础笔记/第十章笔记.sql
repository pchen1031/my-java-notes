#创建表和管理表
#1. 创建和管理数据库:
#1.1 如何创建数据库:
#方式1：
CREATE DATABASE mytest1;#创建的此数据库使用的是默认的字符集
#查看创建数据库的结构
SHOW CREATE DATABASE mytest1;
#方式2：显式了指名了要创建的数据库的字符集
CREATE DATABASE mytest2 CHARACTER SET 'gbk';
SHOW CREATE DATABASE mytest2;
#方式3（推荐）：如果要创建的数据库已经存在，则创建不成功，但不会报错。
CREATE DATABASE IF NOT EXISTS mytest2 CHARACTER SET 'utf8';
#如果要创建的数据库不存在，则创建成功
CREATE DATABASE IF NOT EXISTS mytest3 CHARACTER SET 'utf8';
SHOW DATABASES;

#1.2 管理数据库
#查看当前连接中的数据库都有哪些
SHOW DATABASES;
#切换数据库
USE mytest2;
USE atguigudb;
#查看当前数据库中保存的数据表
SHOW TABLES;
#查看当前使用的数据库
SELECT DATABASE()
FROM DUAL;
#查看指定数据库下保存的数据表
SHOW TABLES FROM mysql;

#1.3 修改数据库
#更改数据库字符集
SHOW CREATE DATABASE mytest2;

ALTER DATABASE mytest2 CHARACTER SET 'utf8';
#注意:DATABASE不能改名.一些可视化工具可以改名,它是建新库,把所有表复制到新库,再删旧库完成的。

#1.4 删除数据库
#方式1:
DROP DATABASE mytest1;

SHOW DATABASES;
#方式2:推荐
DROP DATABASE IF EXISTS mytest1;
DROP DATABASE IF EXISTS mytest2;
DROP DATABASE IF EXISTS mytest3;
#2. 如何创建数据表
#需要用户具备创建表的权限
USE aiguigudb;
SHOW CREATE DATABASE atguigudb;
SHOW TABLES;
#方式1:
CREATE TABLE IF NOT EXISTS myemp1(
id INT,
emp_name VARCHAR(15),#使用VARCHAR来定义字符串,必须在使用VARCHAR时指明其长度。
hire_date DATE
);
#查看表结构
DESC myemp1;
#查看创建表的语句结构
SHOW CREATE TABLE myemp1;#如果创建表时没有指明使用的字符集,则默认使用表所在的数据库的字符集。

SHOW TABLES;

SELECT * FROM myemp1;
#方式2:基于现有的表,同时导入数据
CREATE TABLE myemp2
AS
SELECT employee_id,last_name,salary
FROM employees;

DESC myemp2;
DESC employees;

SELECT * FROM myemp2;

#说明1:查询语句中字段的别名,可以作为新创建的表的字段的名称。
#说明2:此时的查询语句可以结构比较丰富,使用前面章节讲过的各种SELECT
CREATE TABLE myemp3
AS
SELECT e.employee_id AS emp_id, e.last_name ,e.department_id
FROM employees e JOIN departments d
ON e.department_id = d.department_id;

SELECT *
FROM myemp3;

CREATE TABLE myemp4
AS
SELECT e.employee_id AS emp_id, e.last_name ,e.department_id
FROM employees e JOIN departments d
ON e.department_id = d.department_id;

DESC myemp4;

#练习:创建一个表employees_copy,实现对employees表的复制,包括表数据
CREATE TABLE IF NOT EXISTS employees_copy
AS
SELECT *
FROM employees;

SELECT*
FROM employees_copy;
#练习:创建一个表employees_blank,实现对employees表的复制,不包括表数据
CREATE TABLE IF NOT EXISTS employees_blank
AS
SELECT *
FROM employees
#where department_id > 100000;
WHERE 1 = 2;

DESC employees_blank;

#3. 修改表 --->ALTER TABLE
DESC myemp1;
#3.1 添加一个字段 使用 ADD 添加新列时,必须指定列的数据类型
ALTER TABLE myemp1
ADD salary DOUBLE(10,2);#10表示一共有10位,2表示小数部分有2位

ALTER TABLE myemp1
ADD phone_number VARCHAR(20) FIRST;#phone_number排在第一

ALTER TABLE myemp1
ADD email VARCHAR(45) AFTER emp_name;#email在emp_name后面

#3.2 修改一个字段:修改数据类型、长度、默认值等
#一般不会修改数据类型
#修改长度:
ALTER TABLE myemp1
MODIFY emp_name VARCHAR(25);

ALTER TABLE myemp1
MODIFY emp_name VARCHAR(35) DEFAULT 'aaa';#修改的时候还可以添加默认值

/*
ALTER TABLE myemp1 
ALTER COLUMN emp_name SET DEFAULT 'aaa'; 仅修改默认值
*/
#3.3 重命名一个字段
ALTER TABLE myemp1
CHANGE salary monthly_salary DOUBLE(10,2);

ALTER TABLE myemp1
CHANGE email my_email VARCHAR(50);

#3.3 删除一个字段
ALTER TABLE myemp1
DROP COLUMN my_email;

#4.重命名表
#方式1:RENAME
RENAME TABLE myemp1
TO myemp111;

SHOW TABLES;
#方式2:ALTER
ALTER TABLE myemp2
RENAME TO myemp22222;

SHOW TABLES;
#5.删除表
#删除表不光把表结构删除掉了,同时表中的数据也删除掉释放空间
DROP TABLE IF EXISTS myemp2;

#6.清空表
#清空表会清空表中的所有数据,但是表结构保留
SELECT * FROM employees_copy;

TRUNCATE TABLE employees_copy;

SELECT * FROM employees_copy;

DESC employees_copy;

#7. DCL中COMMIT和ROLLBACK
# COMMIT:提交数据,一旦执行COMMIT,则数据就被永久的保存在了数据库中,意味着数据不可以回滚.
# ROLLBACK:回滚数据.一旦执行ROLLBACK,则可以实现数据的回滚.回滚到最近的一次COMMIT之后.

#8. 对比TRUNCATE TABLE和DELETE FROM 
# 相同点:都可以实现对表中所有数据的删除,同时保留表结构。
# 不同点:TRUNCATE TABLE:一旦执行此操作,表数据全部清除.同时,数据是不可以回滚的.
#	DELETE FROM:一旦执行此操作,表数据可以全部清除（不带WHERE）同时,数据是可以实现回滚的.

/*
9. DDL 和 DML 的说明
  ① DDL的操作一旦执行,就不可回滚.指令SET autocommit = FALSE对DDL操作失效.(因为在执行完DDL
    操作之后,一定会执行一次COMMIT.而此COMMIT操作不受SET autocommit = FALSE影响的)
  
  ② DML的操作默认情况,一旦执行,也是不可回滚的.但是,如果在执行DML之前,执行了 
    SET autocommit = FALSE,则执行的DML操作就可以实现回滚.
*/

# 演示:DELETE FROM 
#1)
COMMIT;
#2)
SELECT *
FROM myemp3;
#3)
SET autocommit = FALSE;
#4)
DELETE FROM myemp3;
#5)
SELECT *
FROM myemp3;
#6)
ROLLBACK;
#7)
SELECT *
FROM myemp3;

# 演示：TRUNCATE TABLE
#1)
COMMIT;
#2)
SELECT *
FROM myemp3;
#3)
SET autocommit = FALSE;
#4)
TRUNCATE TABLE myemp3;
#5)
SELECT *
FROM myemp3;
#6)
ROLLBACK;
#7)
SELECT *
FROM myemp3;

/*
阿里开发规范：
【参考】TRUNCATE TABLE比DELETE速度快,且使用的系统和事务日志资源少,
但TRUNCATE无事务且不触发 TRIGGER,有可能造成事故,故不建议在开发代码中使用此语句. 
说明:TRUNCATE TABLE在功能上与不带WHERE子句的DELETE语句相同.
*/

#######################
#9.测试MySQL8.0的新特性：DDL的原子化
CREATE DATABASE mytest;

USE mytest;

CREATE TABLE book1(
book_id INT ,
book_name VARCHAR(255)
);

SHOW TABLES;

DROP TABLE book1,book2;

SHOW TABLES;

#练习:
#1. 创建数据库test01_office,指明字符集为utf8.并在此数据库下执行下述操作
CREATE DATABASE IF NOT EXISTS test01_office CHARACTER SET 'utf8';
#2. 创建表dept01
/*
字段      类型
id        INT(7)  
NAME   VARCHAR(25)
*/
USE test01_office;
CREATE TABLE IF NOT EXISTS dept01(
id INT(7),
`name` VARCHAR(25)
);
#3. 将表departments中的数据插入新表dept02中
CREATE TABLE IF NOT EXISTS dept02
AS
SELECT *
FROM atguigudb.departments;

SELECT *
FROM dept02;
#4.创建表emp01
/*
字段            类型
id		INT(7)
first_name	VARCHAR (25)
last_name	VARCHAR(25)
dept_id		INT(7)
*/
CREATE TABLE IF NOT EXISTS emp01(
id INT(7),
first_name VARCHAR(25),
last_name VARCHAR(25),
dept_id INT(7)
);
#5. 将列last_name的长度增加到50
ALTER TABLE emp01
MODIFY last_name VARCHAR(50);

DESC emp01;
#6. 根据表employees创建emp02
CREATE TABLE IF NOT EXISTS emp02
AS
SELECT *
FROM atguigudb.employees;

SELECT *
FROM emp02;
#7. 删除表emp01
DROP TABLE IF EXISTS emp01;

SHOW TABLES;
#8. 将表emp02重命名为emp01
ALTER TABLE emp02
RENAME TO emp01; 

SHOW TABLES;
#9.在表dept02和emp01中添加新列test_column,并检查所作的操作
ALTER TABLE emp01 
ADD test_column VARCHAR(10);

DESC emp01;

ALTER TABLE dept02 
ADD test_column VARCHAR(10);

DESC dept02;
#10.直接删除表emp01中的列 department_id
ALTER TABLE emp01
DROP COLUMN department_id;

DESC emp01;

#练习2：
# 1、创建数据库 test02_market

CREATE DATABASE IF NOT EXISTS test02_market CHARACTER SET 'utf8';

USE test02_market;

SHOW CREATE DATABASE test02_market;

# 2、创建数据表 customers
CREATE TABLE IF NOT EXISTS customers(
c_num INT,
c_name VARCHAR(50),
c_contact VARCHAR(50),
c_city VARCHAR(50),
c_birth DATE
);

SHOW TABLES;

# 3、将 c_contact 字段移动到 c_birth 字段后面
DESC customers;

ALTER TABLE customers
MODIFY c_contact VARCHAR(50) AFTER c_birth;

# 4、将 c_name 字段数据类型改为 varchar(70)
ALTER TABLE customers
MODIFY c_name VARCHAR(70);

# 5、将c_contact字段改名为c_phone
ALTER TABLE customers
CHANGE c_contact c_phone VARCHAR(50);

# 6、增加c_gender字段到c_name后面，数据类型为char(1)
ALTER TABLE customers
ADD c_gender CHAR(1) AFTER c_name;

# 7、将表名改为customers_info
RENAME TABLE customers
TO customers_info;

DESC customers_info;

# 8、删除字段c_city
ALTER TABLE customers_info
DROP COLUMN c_city;

#练习3：
# 1、创建数据库test03_company
CREATE DATABASE IF NOT EXISTS test03_company CHARACTER SET 'utf8';

USE test03_company;

# 2、创建表offices
CREATE TABLE IF NOT EXISTS offices(
officeCode INT,
city VARCHAR(30),
address VARCHAR(50),
country VARCHAR(50),
postalCode VARCHAR(25)
);

DESC offices;

# 3、创建表employees
CREATE TABLE IF NOT EXISTS employees(
empNum INT,
lastName VARCHAR(50),
firstName VARCHAR(50),
mobile VARCHAR(25),
`code` INT,
jobTitle VARCHAR(50),
birth DATE,
note VARCHAR(255),
sex VARCHAR(5)

);

DESC employees;

# 4、将表employees的mobile字段修改到code字段后面
ALTER TABLE employees
MODIFY mobile VARCHAR(20) AFTER `code`;

# 5、将表employees的birth字段改名为birthday
ALTER TABLE employees
CHANGE birth birthday DATE;

# 6、修改sex字段，数据类型为char(1)
ALTER TABLE employees
MODIFY sex CHAR(1);

# 7、删除字段note
ALTER TABLE employees
DROP COLUMN note;

# 8、增加字段名favoriate_activity，数据类型为varchar(100)
ALTER TABLE employees
ADD favoriate_activity VARCHAR(100);

# 9、将表employees的名称修改为 employees_info
RENAME TABLE employees TO employees_info;

DESC employees_info;


































