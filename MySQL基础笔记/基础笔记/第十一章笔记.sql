#数据处理之增删改
#0.储备工作
USE atguigudb;

CREATE TABLE IF NOT EXISTS emp1(
id INT,
`name` VARCHAR(15),
hire_date DATE,
salary DOUBLE(10,2)
);

DESC emp1;

SELECT *
FROM emp1;
#1. 添加数据
#方式1:一条一条的添加数据
#没有显式指定列名顺序一定要按照声明的字段的先后顺序添加
INSERT INTO emp1
VALUES (1,'Tom','2025-12-21',3400);#DATE类型的数据加引号

INSERT INTO emp1
VALUES (1,3400,'2025-12-21',3400);#3400在插入到name列的时候整数被隐式转换为字符串 '3400'

INSERT INTO emp1 (salary, hire_date, NAME, id)#显式指定列名的顺序不需要与创建表时的列顺序一致
VALUES (3400, '2025-12-21', 'Tom', 1); 

#只插入部分字段（需确保未指定列可为NULL或有默认值）
INSERT INTO emp1 (NAME, salary)
VALUES ('Jerry', 4000);

SELECT *
FROM emp1;

#使用一个INSERT同时插入多条记录
INSERT INTO emp1(id,NAME,salary)
VALUES
(5,'彭晨',25000),
(6,'Jerry',15000);

SELECT *
FROM emp1;

/*
一个同时插入多行记录的INSERT语句等同于多个单行插入的INSERT语句
但是多行的INSERT语句在处理过程中`效率更高`
因为MySQL执行单条INSERT语句插入多行数据比使用多条INSERT语句快
所以在插入多条记录时最好选择使用单条INSERT语句的方式插入.
*/
#方式2:将查询结果插入表中
SELECT * FROM emp1;

INSERT INTO emp1(id,NAME,salary,hire_date)
#查询语句
SELECT employee_id,last_name,salary,hire_date#查询的字段一定要与添加到的表的字段一一对应
FROM employees
WHERE department_id IN (70,60);

DESC emp1;
DESC employees;
#说明:emp1表中要添加数据的字段的长度不能低于employees表中查询的字段的长度.
#如果emp1表中要添加数据的字段的长度低于employees表中查询的字段的长度的话,就有添加不成功的风险.

#2.更新数据(修改数据)
#UPDATE 表名 SET 修改的字段 WHERE过滤条件
#如果没有过滤条件会把整个表都修改
#可以实现批量修改数据
UPDATE emp1
SET hire_date = NOW()
WHERE NAME = '彭晨';

SELECT * FROM emp1;

#同时修改一条数据的多个字段
UPDATE emp1
SET hire_date = NOW(),salary = 6000
WHERE id = 6;

SELECT * FROM emp1;

#练习:把表中姓名中包含a的提薪20%
UPDATE emp1
SET salary = salary * 1.2
WHERE NAME LIKE '%a%';

SELECT * FROM emp1;

#修改数据时,是可能存在不成功的情况的（可能是由于约束的影响造成的）
UPDATE employees
SET department_id = 10000
WHERE employee_id = 102;

#3.删除数据 DELETE...WHERE...
#不加WHERE的话会删除所有的数据
DELETE FROM emp1
WHERE id = 1 OR id <=> NULL;

SELECT * FROM emp1;

#在删除数据时,也有可能因为约束的影响,导致删除失败
DELETE FROM departments
WHERE department_id = 50;

#小结:DML操作默认情况下,执行完以后都会自动提交数据.
#如果希望执行完以后不自动提交数据,则需要使用 SET autocommit = FALSE.

#4. MySQL8的新特性：计算列
/*
什么叫计算列呢？简单来说就是某一列的值是通过别的列计算得来的.
例如,a列值为1、b列值为2,c列不需要手动插入,定义a+b的结果为c的值
那么c就是计算列,是通过别的列计算得来的.
*/
#在MySQL8.0中,CREATE TABLE 和 ALTER TABLE中都支持增加计算列.下面以CREATE TABLE为例进行讲解.
USE atguigudb;

CREATE TABLE test1(
a INT,
b INT,
c INT GENERATED ALWAYS AS (a + b) VIRTUAL
);

INSERT INTO test1 (a,b)
VALUES (100,200);

SELECT *
FROM test1;

UPDATE test1
SET a = 200;

SELECT *
FROM test1;

#5.综合案例
# 1、创建数据库test01_library
CREATE DATABASE IF NOT EXISTS test01_library CHARACTER SET 'utf8';
USE test01_library;
# 2、创建表 books,表结构如下：
CREATE TABLE IF NOT EXISTS books(
id INT,
NAME VARCHAR(50),
AUTHORS VARCHAR(100),
price FLOAT,
pubdate YEAR,
note VARCHAR(100),
num INT
);
# 3、向books表中插入记录
# 1）不指定字段名称，插入第一条记录
INSERT INTO books
VALUES (1,'Tal of AAA','Dickes',23,1995,'novel',11);
# 2）指定所有字段名称，插入第二记录
INSERT INTO books (id,NAME,AUTHORS,price,pubdate,note,num)
VALUES (2,'EmmaT','Jane lura',35,1993,'joke',22);
# 3）同时插入多条记录（剩下的所有记录）
INSERT INTO books(id,NAME,AUTHORS,price,pubdate,note,num)
VALUES
(3,'Story of Jane','Jane Tim',40,2001,'novel',0),
(4,'Lovey Day','George Byron',20,2005,'novel',30),
(5,'Old land','Honore Blade',30,2010,'Law',0),
(6,'The Battle','Upton Sara',30,1999,'medicine',40),
(7,'Rose Hood','Richard haggard',28,2008,'cartoon',28);

SELECT *
FROM books;

# 4、将小说类型(novel)的书的价格都增加5。
UPDATE books
SET price = price + 5
WHERE note = 'novel';

SELECT *
FROM books;
# 5、将名称为EmmaT的书的价格改为40，并将说明改为drama。
UPDATE books
SET price = 40,note = 'drama'
WHERE NAME = 'EmmaT';

SELECT *
FROM books;
# 6、删除库存为0的记录。
DELETE FROM books
WHERE num = 0;

SELECT *
FROM books;
# 7、统计书名中包含a字母的书
SELECT NAME
FROM books
WHERE NAME LIKE '%a%';
# 8、统计书名中包含a字母的书的数量和库存总量
SELECT COUNT(*) , SUM(num)
FROM books
WHERE NAME LIKE '%a%'
# 9、找出“novel”类型的书，按照价格降序排列
SELECT NAME
FROM books
WHERE note = 'novel'
ORDER BY price DESC;
# 10、查询图书信息，按照库存量降序排列，如果库存量相同的按照note升序排列
SELECT *
FROM books
ORDER BY num DESC , note ASC;
# 11、按照note分类统计书的数量
SELECT note , COUNT(*)
FROM books
GROUP BY note;
# 12、按照note分类统计书的库存量，显示库存量超过30本的
SELECT note,SUM(num)
FROM books
GROUP BY note
HAVING SUM(num) > 30;
# 13、查询所有图书，每页显示5本，显示第二页
SELECT *
FROM books
LIMIT 5,5;
# 14、按照note分类统计书的库存量，显示库存量最多的
SELECT note , SUM(num)
FROM books
GROUP BY note
HAVING SUM(num) >= ALL(
		SELECT SUM(num)
		FROM books
		GROUP BY note
		);
# 15、查询书名达到10个字符的书，不包括里面的空格
SELECT * 
FROM books 
WHERE CHAR_LENGTH(REPLACE(NAME,' ',''))>=10;#REPLACE(NAME,' ','')把name中的空格换成''
# 16、查询书名和类型，其中note值为novel显示小说，law显示法律，medicine显示医药，cartoon显示卡通，joke显示笑话
SELECT NAME AS "书名" ,note, CASE note 
				 WHEN 'novel' THEN '小说'
				 WHEN 'law' THEN '法律'
				 WHEN 'medicine' THEN '医药'
				 WHEN 'cartoon' THEN '卡通'
				 WHEN 'joke' THEN '笑话'
				 ELSE '其他'
				 END AS "类型"
FROM books;
# 17、查询书名、库存，其中num值超过30本的，显示滞销，大于0并低于10的，显示畅销，为0的显示需要无货
SELECT NAME , num , CASE WHEN num > 30 THEN '滞销'
			 WHEN num < 10 THEN '畅销'
			 WHEN num = 0  THEN '无货'
			 END '销售情况'
FROM books;	
# 18、统计每一种note的库存量,并合计总量
SELECT note , SUM(num)
FROM books
GROUP BY note WITH ROLLUP;
# 19、统计每一种note的数量,并合计总量
SELECT IFNULL(note,'合计总量') AS note,COUNT(*)
FROM books
GROUP BY note WITH ROLLUP;
# 20、统计库存量前三名的图书
SELECT *
FROM books
ORDER BY num DESC
LIMIT 0,3;
# 21、找出最早出版的一本书
SELECT *
FROM books
ORDER BY pubdate
LIMIT 1;
# 22、找出novel中价格最高的一本书
SELECT *
FROM books
WHERE note = 'novel'
ORDER BY price DESC
LIMIT 0,1;
# 23、找出书名中字数最多的一本书,不含空格
SELECT *
FROM books
ORDER BY CHAR_LENGTH(REPLACE(NAME,' ','')) DESC
LIMIT 0,1;



#第11章_数据处理之增删改的课后练习
#练习1：
#1. 创建数据库dbtest11
CREATE DATABASE IF NOT EXISTS dbtest11 CHARACTER SET 'utf8';

#2. 运行以下脚本创建表my_employees
USE dbtest11;

CREATE TABLE my_employees(
	id INT(10),
	first_name VARCHAR(10),
	last_name VARCHAR(10),
	userid VARCHAR(10),
	salary DOUBLE(10,2)
);

CREATE TABLE users(
	id INT,
	userid VARCHAR(10),
	department_id INT
);
#3.显示表my_employees的结构

DESC my_employees;

DESC users;

#4.向my_employees表中插入下列数据
/*
ID	FIRST_NAME	LAST_NAME	USERID		SALARY
1	patel		Ralph		Rpatel		895
2	Dancs		Betty		Bdancs		860
3	Biri		Ben		Bbiri		1100
4	Newman		Chad		Cnewman		750
5	Ropeburn	Audrey		Aropebur	1550
*/
INSERT INTO my_employees
VALUES(1,'patel','Ralph','Rpatel',895);

INSERT INTO my_employees VALUES
(2,'Dancs','Betty','Bdancs',860),
(3,'Biri','Ben','Bbiri',1100),
(4,'Newman','Chad','Cnewman',750),
(5,'Ropeburn','Audrey','Aropebur',1550);

SELECT * FROM my_employees;

DELETE FROM my_employees;

#方式2：
INSERT INTO my_employees
SELECT 1,'patel','Ralph','Rpatel',895 UNION ALL
SELECT 2,'Dancs','Betty','Bdancs',860 UNION ALL
SELECT 3,'Biri','Ben','Bbiri',1100 UNION ALL
SELECT 4,'Newman','Chad','Cnewman',750 UNION ALL
SELECT 5,'Ropeburn','Audrey','Aropebur',1550;
			
#5.向users表中插入数据
/*
1	Rpatel		10
2	Bdancs		10
3	Bbiri		20
4	Cnewman		30
5	Aropebur	40
*/
INSERT INTO users 
VALUES  (1,'Rpatel',10),
	(2,'Bdancs',10),
	(3,'Bbiri',20),
	(4,'Cnewman',30),
	(5,'Aropebur',40);

SELECT * FROM users;



#6. 将3号员工的last_name修改为“drelxer”
UPDATE my_employees
SET last_name = 'drelxer'
WHERE id = 3;

#7. 将所有工资少于900的员工的工资修改为1000
UPDATE my_employees
SET salary = 1000
WHERE salary < 900;

#8. 将userid为Bbiri的users表和my_employees表的记录全部删除

#方式1：
DELETE FROM my_employees
WHERE userid = 'Bbiri';

DELETE FROM users
WHERE userid = 'Bbiri';

#方式2：

DELETE m,u
FROM my_employees m
JOIN users u
ON m.userid = u.userid
WHERE m.userid = 'Bbiri';

SELECT * FROM my_employees;
SELECT * FROM users;

#9. 删除my_employees、users表所有数据
DELETE FROM my_employees;
DELETE FROM users;

#10. 检查所作的修正
SELECT * FROM my_employees;
SELECT * FROM users;

#11. 清空表my_employees
TRUNCATE TABLE my_employees;
##########################################
#练习2：
# 1. 使用现有数据库dbtest11
USE dbtest11;

# 2. 创建表格pet
CREATE TABLE pet(
NAME VARCHAR(20),
OWNER VARCHAR(20),
species VARCHAR(20),
sex CHAR(1),
birth YEAR,
death YEAR
);

DESC pet;

# 3. 添加记录
INSERT INTO pet VALUES
('Fluffy','harold','Cat','f','2003','2010'),
('Claws','gwen','Cat','m','2004',NULL),
('Buffy',NULL,'Dog','f','2009',NULL),
('Fang','benny','Dog','m','2000',NULL),
('bowser','diane','Dog','m','2003','2009'),
('Chirpy',NULL,'Bird','f','2008',NULL);

SELECT *
FROM pet;

# 4. 添加字段:主人的生日owner_birth DATE类型。
ALTER TABLE pet
ADD owner_birth DATE;

# 5. 将名称为Claws的猫的主人改为kevin
UPDATE pet
SET OWNER = 'kevin'
WHERE NAME = 'Claws' AND species = 'Cat';

# 6. 将没有死的狗的主人改为duck
UPDATE pet
SET OWNER = 'duck'
WHERE death IS NULL AND species = 'Dog';

# 7. 查询没有主人的宠物的名字；
SELECT NAME
FROM pet
WHERE OWNER IS NULL;

# 8. 查询已经死了的cat的姓名，主人，以及去世时间；
SELECT NAME,OWNER,death
FROM pet
WHERE death IS NOT NULL;

# 9. 删除已经死亡的狗
DELETE FROM pet
WHERE death IS NOT NULL 
AND species = 'Dog';

# 10. 查询所有宠物信息
SELECT * 
FROM pet;

##################################
#练习3：
# 1. 使用已有的数据库dbtest11
USE dbtest11;
# 2. 创建表employee，并添加记录
CREATE TABLE employee(
id INT,
NAME VARCHAR(15),
sex CHAR(1),
tel VARCHAR(25),
addr VARCHAR(35),
salary DOUBLE(10,2)
);

INSERT INTO employee VALUES
(10001,'张一一','男','13456789000','山东青岛',1001.58),
(10002,'刘小红','女','13454319000','河北保定',1201.21),
(10003,'李四','男','0751-1234567','广东佛山',1004.11),
(10004,'刘小强','男','0755-5555555','广东深圳',1501.23),
(10005,'王艳','男','020-1232133','广东广州',1405.16);

SELECT * FROM employee;

# 3. 查询出薪资在1200~1300之间的员工信息。
SELECT *
FROM employee
WHERE salary BETWEEN 1200 AND 1300;

# 4. 查询出姓“刘”的员工的工号，姓名，家庭住址。
SELECT id,NAME,addr
FROM employee
WHERE NAME LIKE '刘%';

# 5. 将“李四”的家庭住址改为“广东韶关”
UPDATE employee
SET addr = '广东韶关'
WHERE NAME = '李四';

# 6. 查询出名字中带“小”的员工
SELECT *
FROM employee
WHERE NAME LIKE '%小%';
























































