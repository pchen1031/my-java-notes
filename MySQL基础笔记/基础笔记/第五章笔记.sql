#排序与分页
#1.排序操作
#如果没有使用排序操作，默认情况下查询返回的数据是按照数据添加的顺序显示的
SELECT * FROM employees;

#练习：按照salary从高到低的顺序显示员工信息
#使用ORDER BY对查询到的数据进行排序操作
#升序:ASC(ascend)
#降序:DESC(descend)
SELECT employee_id , last_name , salary
FROM employees
ORDER BY salary DESC;
#练习：按照salary从低到高的顺序显示员工信息
SELECT employee_id , last_name , salary
FROM employees
ORDER BY salary；#如果ORDER BY后没有显式指明排序方式，那么默认按照升序

#可以使用列的别名进行排序
SELECT employee_id , salary , salary * 12 AS annual_sal
FROM employees
ORDER BY annual_sal;

#列的别名只能在ORDER BY使用，不能在WHERE中使用
SELECT employee_id , salary , salary * 12 AS annual_sal
FROM employees
WHERE annual_sal > 81600;#错误
#语句的执行顺序不是从上到下的
#先执行FROM和WHERE,在执行SELECT，最后在执行ORDER BY
#WHERE需要声明在FROM后ORDER BY前面
SELECT employee_id , salary
FROM employees
WHERE department_id IN(50,60,70)
ORDER BY department_id DESC;

#二级排序(三级，四级......以此类推)
#练习：显示员工信息，按照department_id降序排列
#若department_id一样则按照salary升序排列
SELECT employee_id , salary , department_id
FROM employees
ORDER BY department_id DESC , salary ASC;

#分页操作
#MySQL使用LIMIT实现数据的分页显示
#需求1：每页显示20条数据，此时显示第一页的数据
SELECT employee_id , last_name
FROM employees
LIMIT 0 , 20;#0是偏移量，代表从第一条数据开始 一共20条
#若偏移量为1则代表从第二条数据开始 一共20条

#需求2：每页显示20条数据，此时显示第二页的数据
SELECT employee_id , last_name
FROM employees
LIMIT 20 , 20;

#需求3：每页显示20条数据，此时显示第三页的数据
SELECT employee_id , last_name
FROM employees
LIMIT 40 , 20;

#需求：每页显示pageSize条记录，此时显示第pageNumber页的数据
#公式：LIMIT (pageNumber - 1) * pageSize , pageSize;

#WHERE ... ORDER BY ... LIMIT声明顺序
#LIMIT的格式： 严格来说：LIMIT 位置偏移量,条目数
#结构"LIMIT 0,条目数" 等价于 "LIMIT 条目数"
#注意：LIMIT 子句必须放在整个SELECT语句的最后
SELECT employee_id , last_name , salary
FROM employees
WHERE salary > 6000
ORDER BY salary DESC
LIMIT 0 , 10;

#练习:表中有107条数据，我们只想要显示第32,33条数据
SELECT employee_id , last_name , salary
FROM employees
LIMIT 31 , 2;

#MySQL8.0新特性:LIMIT...OFFSET...
SELECT employee_id , last_name , salary
FROM employees
LIMIT 2 OFFSET 31;#和LIMIT 31 , 2;一样的效果

#练习:查询员工表中工资最高的员工信息
SELECT employee_id , last_name , salary
FROM employees
ORDER BY salary DESC
LIMIT 1;

#练习
#1. 查询员工的姓名和部门号和年薪，按年薪降序,按姓名升序显示 
SELECT last_name , department_id , salary * 12 AS "年薪"
FROM employees
ORDER BY 年薪 DESC , last_name ASC;
#2. 选择工资不在 8000 到 17000 的员工的姓名和工资，按工资降序，显示第21到40位置的数据
SELECT last_name , salary
FROM employees
WHERE salary NOT BETWEEN 8000 AND 17000
ORDER BY salary DESC
LIMIT 20 , 20;
#3. 查询邮箱中包含 e 的员工信息，并先按邮箱的字节数降序，再按部门号升序
SELECT employee_id , last_name , email
FROM employees
WHERE email LIKE '%e%'
#WHERE email REGEXP '[e]'
ORDER BY LENGTH(email) DESC , department_id;


































