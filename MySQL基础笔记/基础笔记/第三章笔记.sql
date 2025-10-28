#1. SQL的分类
/*
DDL:数据定义语言。CREATE \ ALTER \ DROP \ RENAME \ TRUNCATE


DML:数据操作语言。INSERT \ DELETE \ UPDATE \ SELECT （重中之重）


DCL:数据控制语言。COMMIT \ ROLLBACK \ SAVEPOINT \ GRANT \ REVOKE


学习技巧：大处着眼、小处着手。

*/
SELECT * FROM employees;# *代表所有的列的意思,就是查询这个表所有的内容
SELECT employee_id , last_name FROM employees; #查询employees这个表中employee_id和last_name这两列
SELECT employee_id emp_id FROM employees;# 把结果集中的employee_id改为emp_id，不会改变原表结构
SELECT employee_id AS emp_id FROM employees;# 和上面一样的效果
SELECT employee_id "emp_id" FROM employees;# 一样的效果
SELECT salary * 12 FROM employees;# SQL查询语句可以对表中的数据进行加减乘除等数学运算,并将计算结果作为新的列返回在结果集中.这是SQL处理数据时非常常见的操作,不会修改原表数据,只会生成临时的计算结果.
SELECT department_id FROM employees;
SELECT DISTINCT department_id FROM employees;# 去掉重复的
SELECT salary , DISTINCT department_id FROM employees;# 错误的
SELECT DISTINCT department_id ,salary FROM employees;#正确 不会报错 含义是department_id和salary的组合体是唯一的，不过没什么意义
# SELECT DISTINCT department_id ,DISTINCT salary FROM employees; 错误的 在SQL中，DISTINCT关键字只能出现一次，并且它作用于所有被选择的列的组合，而不是单个列。

# 空值（null）参加运算 null不等同于0，'','null' 
SELECT employee_id,salary AS "月薪",salary * (1 + commission_pct) AS "年薪" FROM employees;# 空值参与运算结果一定也是null

# `` 着重号
SELECT * FROM `order`;

# 查询常数
SELECT '尚硅谷' AS "公司",employee_id , last_name FROM employees;#尚硅谷作为常数出现，给每一行都做了匹配

# 显示表结构
DESCRIBE employees;
DESC employees;#效果同上

# 过滤数据 例如：查询90号部门员工的信息
# WHERE 关键字表示过滤条件 WHERE一定在FROM后面挨着FROM
SELECT * FROM employees WHERE department_id = 90;
SELECT * FROM employees WHERE last_name = 'King';# 小细节 字符串忽略大小写 MySQL自己比较宽泛
SELECT employee_id FROM employees WHERE employee_id = 100;

# 练习
# 1.查询员工12个月的工资总和，并起别名为ANNUAL SALARY
SELECT employee_id , last_name , salary * 12 AS "ANNUAL SALARY"
FROM employees;
# 2.查询employees表中去除重复的job_id以后的数据
SELECT DISTINCT job_id
FROM employees;
# 3.查询工资大于12000的员工姓名和工资
SELECT first_name , last_name , salary
FROM employees
WHERE salary > 12000;
# 4.查询员工号为176的员工的姓名和部门号
SELECT first_name , last_name , department_id
FROM employees
WHERE employee_id = 176;
# 5.显示表 departments 的结构，并查询其中的全部数据 
DESC departments;
SELECT * FROM departments;



