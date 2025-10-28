#多表查询
#熟悉常见的几个表
DESC employees;
DESC departments;
DESC locations;

#查询员工名字为Abel的人在哪个城市工作
SELECT * 
FROM employees
WHERE last_name = 'Abel';

SELECT * 
FROM departments
WHERE department_id = 80;

SELECT * 
FROM locations
WHERE location_id = 2500;

#多表查询如何实现
#错误原因:缺少多表的查询条件
SELECT employee_id , department_name
FROM employees , departments;#查询出2889条记录 笛卡尔积的错误 每个员工和每个部门都匹配了一遍

SELECT * 
FROM employees; #107条记录

SELECT * 
FROM departments; #27条记录 107*27=2889

#多表查询正确方式:需要有连接条件
SELECT employee_id , department_name
FROM employees , departments
#多表查询连接条件
WHERE employees.department_id = departments.department_id;

#下列代码会报错 因为employees表和departments都有department_id
#MySQL不知道你想查哪个表的department_id
SELECT employee_id , department_name , department_id
FROM employees , departments
WHERE employees.department_id = departments.department_id;

#如果查询语句中出现了多个表中都存在的字段,则必须指明此字段所在的表
SELECT employee_id , department_name , departments.department_id
FROM employees , departments
WHERE employees.department_id = departments.department_id;

#建议:从SQL优化的角度，建议多表查询时每个字段前都指明其所在的表	

#可以给表起别名,在SELECT和WHERE中使用表的别名 注意区分列的别名和表的别名
SELECT emp.employee_id , dept.department_name , dept.department_id
FROM employees emp, departments dept
WHERE emp.department_id = dept.department_id;
#如果给表起了别名,则在SELECT和WHERE中如果要使用到这个表名
#那么必须使用表的别名,不能使用表的原名

#练习：查询员工的employee_id,last_name,department_name,city
#如果有n个表实现多表的查询,则至少需要n-1个连接条件
SELECT e.employee_id,e.last_name,d.department_name,l.city,e.department_id,l.location_id
FROM employees e,departments d,locations l
WHERE e.`department_id` = d.`department_id`
AND d.`location_id` = l.`location_id`;

/*
多表查询的分类:

角度一:等值连接 vs 非等值连接

角度二:自连接 vs 非自连接

角度三:内连接 vs 外连接
*/
#等值连接 vs 非等值连接
#非等值连接的例子:
SELECT *
FROM job_grades;

SELECT last_name , salary , grade_level
FROM employees e , job_grades j
WHERE e.salary BETWEEN j.lowest_sal AND j.highest_sal;

#自连接 vs 非自连接
#自连接就是多表查询查的是同一个表
#练习:查询员工id,员工姓名及其管理者的id和姓名
SELECT emp.employee_id,emp.last_name,mgr.employee_id,mgr.last_name
FROM employees emp ,employees mgr
WHERE emp.`manager_id` = mgr.`employee_id`;

#内连接 vs 外连接
/*
内连接:只取那些在所有被连接的表中都能找到符合连接条件的匹配记录，并将它们组合成新的结果行。
任何不符合连接条件的记录（无论是在左表还是右表中）都会被完全排除在最终结果集之外。
*/
SELECT employee_id,department_name
FROM employees e,departments d
WHERE e.`department_id` = d.department_id;  #只有106条记录
/*
- 外连接:两个表在连接过程中除了返回满足连接条件的行以外还返回左（或右）表中不满足条件的行
这种连接称为左（或右）外连接。
没有匹配的行时, 结果表中相应的列为空(NULL)。

-如果是左外连接，则连接条件中左边的表也称为`主表`，右边的表称为`从表`。

 如果是右外连接，则连接条件中右边的表也称为`主表`，左边的表称为`从表`。
 
 外连接的分类：左外连接、右外连接、满外连接

 左外连接：两个表在连接过程中除了返回满足连接条件的行以外还返回左表中不满足条件的行，这种连接称为左外连接。
 右外连接：两个表在连接过程中除了返回满足连接条件的行以外还返回右表中不满足条件的行，这种连接称为右外连接。
*/
#练习：查询所有的员工的last_name,department_name信息(重点是所有的) 
#提到所有的就是外连接
SELECT employee_id,department_name
FROM employees e,departments d
WHERE e.`department_id` = d.department_id;   # 需要使用左外连接

#SQL92语法实现内连接：见上，略
#SQL92语法实现外连接：使用 +  注意！MySQL不支持SQL92语法中外连接的写法！
#在 SQL92 中采用（+）代表从表所在的位置。即左或右外连接中，(+) 表示哪个是从表。
#不支持：
SELECT employee_id,department_name
FROM employees e,departments d
WHERE e.`department_id` = d.department_id(+);
#SQL99语法中使用 JOIN ...ON 的方式实现多表的查询。这种方式也能解决外连接的问题。MySQL是支持此种方式的。

/*
  JOIN不一定必须和ON 搭配使用,但JOIN后面必须指定连接条件或使用特定的语法来定义表之间的关系.
  ON 子句是定义这种关系 最常用和推荐的方式，但不是唯一方式。
*/
#SQL99语法如何实现多表的查询。
#SQL99语法实现内连接：
SELECT last_name,department_name
FROM employees e INNER JOIN departments d
ON e.`department_id` = d.`department_id`;
#JOIN一个表ON一个条件
SELECT last_name,department_name,city
FROM employees e JOIN departments d
ON e.`department_id` = d.`department_id`
JOIN locations l
ON d.`location_id` = l.`location_id`;
#SQL99语法实现外连接：
#练习：查询所有的员工的last_name,department_name信息 
# 左外连接：
SELECT last_name,department_name
FROM employees e LEFT JOIN departments d
ON e.`department_id` = d.`department_id`;
#右外连接：
SELECT last_name,department_name
FROM employees e RIGHT OUTER JOIN departments d
ON e.`department_id` = d.`department_id`;
#满外连接：mysql不支持FULL OUTER JOIN
SELECT last_name,department_name
FROM employees e FULL OUTER JOIN departments d
ON e.`department_id` = d.`department_id`;


#8. UNION  和 UNION ALL的使用
# UNION：会执行去重操作
# UNION ALL:不会执行去重操作
/*
去重操作指的是:例如在employees和departments内连接时得到106条记录
左外连接多1条,右外连接多16条 去重得到的是1+106+16
不去重得到的是1+106+106+16
*/
#结论：如果明确知道合并数据后的结果数据不存在重复数据，或者不需要去除重复的数据，
#则尽量使用UNION ALL语句，以提高数据查询的效率。

#7种JOIN的实现：
# 中图：内连接
SELECT employee_id,department_name
FROM employees e JOIN departments d
ON e.`department_id` = d.`department_id`;
# 左上图：左外连接
SELECT employee_id,department_name
FROM employees e LEFT JOIN departments d
ON e.`department_id` = d.`department_id`;
# 右上图：右外连接
SELECT employee_id,department_name
FROM employees e RIGHT JOIN departments d
ON e.`department_id` = d.`department_id`;
# 左中图：
SELECT employee_id,department_name
FROM employees e LEFT JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE d.`department_id` IS NULL;
# 右中图：
SELECT employee_id,department_name
FROM employees e RIGHT JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE e.`department_id` IS NULL;
# 左下图：满外连接
# 方式1：左上图 UNION ALL 右中图
SELECT employee_id,department_name
FROM employees e LEFT JOIN departments d
ON e.`department_id` = d.`department_id`
UNION ALL
SELECT employee_id,department_name
FROM employees e RIGHT JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE e.`department_id` IS NULL;
# 方式2：左中图 UNION ALL 右上图
SELECT employee_id,department_name
FROM employees e LEFT JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE d.`department_id` IS NULL
UNION ALL
SELECT employee_id,department_name
FROM employees e RIGHT JOIN departments d
ON e.`department_id` = d.`department_id`;
# 右下图：左中图  UNION ALL 右中图
SELECT employee_id,department_name
FROM employees e LEFT JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE d.`department_id` IS NULL
UNION ALL
SELECT employee_id,department_name
FROM employees e RIGHT JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE e.`department_id` IS NULL;

#10. SQL99语法的新特性1:自然连接
SELECT employee_id,last_name,department_name
FROM employees e JOIN departments d
ON e.`department_id` = d.`department_id`
AND e.`manager_id` = d.`manager_id`;
# NATURAL JOIN : 它会帮你自动查询两张连接表中`所有相同的字段`，然后进行`等值连接`。
SELECT employee_id,last_name,department_name
FROM employees e NATURAL JOIN departments d;
#11. SQL99语法的新特性2:USING(必须是同名字段)
SELECT employee_id,last_name,department_name
FROM employees e JOIN departments d
ON e.department_id = d.department_id;

SELECT employee_id,last_name,department_name
FROM employees e JOIN departments d
USING (department_id);
#拓展：
SELECT last_name,job_title,department_name 
FROM employees INNER JOIN departments INNER JOIN jobs 
ON employees.department_id = departments.department_id 
AND employees.job_id = jobs.job_id;

#练习:
# 1.显示所有员工的姓名，部门号和部门名称。
SELECT last_name , employees.department_id , department_name
FROM employees LEFT JOIN departments
ON employees.department_id = departments.department_id;
# 2.查询90号部门员工的job_id和90号部门的location_id
SELECT job_id , location_id
FROM employees JOIN departments
ON employees.department_id = departments.department_id
#WHERE employees.department_id = 90;
AND employees.department_id = 90;
# 3.选择所有有奖金的员工的last_name , department_name , location_id , city
SELECT last_name , department_name , locations.location_id , city
FROM employees LEFT JOIN departments
ON employees.department_id = departments.department_id
LEFT JOIN locations
ON departments.location_id = locations.location_id
WHERE employees.commission_pct IS NOT NULL;
# 4.选择city在Toronto工作的员工的 last_name , job_id , department_id , department_name
SELECT last_name , job_id , employees.department_id , department_name
FROM employees JOIN departments
ON employees.department_id = departments.department_id
JOIN locations
ON departments.location_id = locations.location_id
WHERE locations.city = 'Toronto';
# 5.查询员工所在的部门名称、部门地址、姓名、工作、工资，其中员工所在部门的部门名称为’Executive’
SELECT last_name , job_id , salary , department_name , street_address
FROM employees JOIN departments
ON employees.department_id = departments.department_id
JOIN locations
ON departments.location_id = locations.location_id
WHERE departments.department_name = 'Executive';
# 6.选择指定员工的姓名，员工号，以及他的管理者的姓名和员工号，结果类似于下面的格式
SELECT emp.last_name "employees",emp.employee_id "Emp#",mgr.last_name "manager", mgr.employee_id "Mgr#"
FROM employees emp LEFT JOIN employees mgr
ON emp.manager_id = mgr.employee_id;
# 7.查询哪些部门没有员工
SELECT department_name
FROM employees RIGHT JOIN departments 
ON employees.department_id = departments.department_id
WHERE employees.employee_id IS NULL; 
# 8.查询哪个城市没有部门
SELECT city
FROM departments RIGHT JOIN locations
ON departments.location_id = locations.location_id
WHERE department_name IS NULL;
# 9.查询部门名为 Sales 或 IT 的员工信息
SELECT last_name
FROM employees JOIN departments
ON employees.department_id = departments.department_id 
WHERE department_name = 'Sales' OR department_name = 'IT';


































