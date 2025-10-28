#子查询:嵌套查询,就是查询里在嵌套一个查询,类似多重for循环
#需求:谁的工资比Abel的高
#方式1:
SELECT last_name , salary
FROM employees
WHERE last_name = 'Abel';

SELECT last_name , salary
FROM employees
WHERE salary > 11000;

#方式2:自连接
SELECT e2.last_name , e2.salary
FROM employees e1 , employees e2
WHERE e2.salary > e1.salary
AND e1.last_name = 'Abel';

#方式3:子查询
SELECT last_name , salary
FROM employees
WHERE salary > (
		SELECT salary
		FROM employees
		WHERE last_name = 'Abel'
		);

#称谓的规范:外查询(或主查询)、内查询(或子查询)
/*
子查询（内查询）在主查询之前一次执行完成
子查询的结果被主查询（外查询）使用
注意事项:
	子查询要包含在括号内
	将子查询放在比较条件的右侧
	单行操作符对应单行子查询,多行操作符对应多行子查询
*/

/*
子查询的分类:
	角度1:单行子查询 VS 多行子查询
	单行子查询就是查出来只有一个结果
	多行子查询是查出来有多个结果
	
	角度2:内查询是否被执行多次
	不相关子查询 VS 相关子查询
	子查询从数据表中查询了数据结果,如果这个数据结果只执行一次,
	然后这个数据结果作为主查询的条件进行执行,那么这样的子查询叫做不相关子查询.
	
	同样,如果子查询需要执行多次,即采用循环的方式,先从外部查询开始,每次都传入子查询进行查询,
	然后再将结果反馈给外部,这种嵌套的执行方式就称为相关子查询.就是外部查询每执行一次子查询就执行一次
*/
#单行子查询
#单行操作符:=  !=  >   >=  <  <= 
#练习:查询工资大于149号员工工资的员工的信息
SELECT last_name
FROM employees
WHERE salary > (
		SELECT salary
		FROM employees
		WHERE employee_id = 149
		);
#子查询的编写技巧(或步骤):①从里往外写②从外往里写

#练习:题目:返回job_id与141号员工相同,salary比143号员工多的员工姓名,job_id和工资
SELECT last_name , job_id , salary
FROM employees
WHERE job_id = (
		SELECT job_id
		FROM employees
		WHERE employee_id = 141
		)
AND salary > (
		SELECT salary
		FROM employees
		WHERE employee_id = 143
		);
#练习:返回公司工资最少的员工的last_name,job_id和salary
SELECT last_name , job_id ,salary
FROM employees
WHERE salary = (
		SELECT MIN(salary)
		FROM employees
		);

#练习:查询与141号员工的manager_id和department_id相同的其他员工的employee_id,manager_id,department_id
#方式1:
SELECT employee_id,manager_id,department_id
FROM employees
WHERE manager_id = (
		SELECT manager_id
		FROM employees
		WHERE employee_id = 141
		)
AND department_id = (
		SELECT department_id
		FROM employees
		WHERE employee_id = 141
		)
AND employee_id != 141;
#方式2(了解):
SELECT employee_id,manager_id,department_id
FROM employees
WHERE (manager_id , department_id) = (
		SELECT manager_id , department_id#要一一对应
		FROM employees
		WHERE employee_id = 141
		);
AND employee_id != 141;

#HAVING中的子查询
#练习:查询最低工资大于110号部门最低工资的部门id和其最低工资
SELECT department_id , MIN(salary)
FROM employees
GROUP BY department_id
HAVING MIN(salary) > (
		SELECT MIN(salary)
		FROM employees
		WHERE department_id = 110
		);

#CASE中的子查询
#练习:显式员工的employee_id,last_name和location.
#其中,若员工department_id与location_id为1800的department_id相同
#则location为’Canada’,其余则为’USA’.
SELECT employee_id,last_name,CASE department_id WHEN (
					SELECT department_id FROM departments WHERE location_id = 1800
					) THEN 'Canada'
						ELSE 'USA' END "location"
FROM employees;

#子查询中的空值问题
SELECT last_name, job_id
FROM   employees
WHERE  job_id =(
		SELECT job_id
                FROM   employees
                WHERE  last_name = 'Haas'
                 );

#非法使用子查询
#错误:Subquery returns more than 1 row
SELECT employee_id, last_name
FROM  employees
WHERE salary =(
		SELECT   MIN(salary)
                FROM     employees
                GROUP BY department_id
                 );#单行操作符后面有多个数据 不知道该和哪个比较了 

#多行子查询
/*
多行比较操作符:
IN等于列表中的任意一个
ANY需要和单行比较操作符一起使用,和子查询返回的某一个值比较
ALL需要和单行比较操作符一起使用,和子查询返回的所有值比较
SOME实际上是ANY的别名,作用相同,一般常使用ANY
*/
#举例:
#IN:
SELECT employee_id, last_name
FROM  employees
WHERE salary IN
		(
		SELECT   MIN(salary)
                FROM     employees
                GROUP BY department_id
                 );

#练习:返回其它job_id中比job_id为‘IT_PROG’部门任一工资低的
#员工的员工号、姓名、job_id 以及salary
#ANY/ALL:
SELECT employee_id , last_name , job_id , salary
FROM employees
WHERE job_id <> 'IT_PROG' 
AND salary < ANY (
		SELECT salary
		FROM employees
		WHERE job_id = 'IT_PROG'
		);
#练习:返回其它job_id中比job_id为‘IT_PROG’部门所有工资都低的
#员工的员工号、姓名、job_id以及salary
SELECT employee_id , last_name , job_id , salary
FROM employees
WHERE job_id <> 'IT_PROG' 
AND salary < ALL (
		SELECT salary
		FROM employees
		WHERE job_id = 'IT_PROG'
		);
#练习:查询平均工资最低的部门id
/*
select department_id
from employees
group by department_id
order by avg(salary)
limit 1;
*/
#可以把中间的临时的表当成一个新表来查询
SELECT MIN(avg_sal)
FROM(
	SELECT AVG(salary) avg_sal
	FROM employees
	GROUP BY department_id
	) t_dept_avg_sal;
#方式1:			
SELECT department_id
FROM employees
GROUP BY department_id
HAVING AVG(salary) = (  SELECT MIN(avg_sal)
			FROM(
				SELECT AVG(salary) avg_sal
				FROM employees
				GROUP BY department_id
				) t_dept_avg_sal
			);
#方式2:
SELECT department_id
FROM employees
GROUP BY department_id
HAVING AVG(salary) <= ALL(	
			SELECT AVG(salary) avg_sal
			FROM employees
			GROUP BY department_id
			); 
#空值问题
SELECT last_name
FROM employees
WHERE employee_id NOT IN (
			SELECT manager_id
			FROM employees
			);

#相关子查询
#练习:查询员工中工资大于本部门平均工资的员工的last_name,salary和其department_id
#方式1:使用相关子查询
SELECT last_name,salary,department_id
FROM employees e1
WHERE salary > (
		SELECT AVG(e2.salary)
		FROM employees e2
		WHERE e2.department_id = e1.department_id
		);
#方式2:在FROM中声明子查询
SELECT e.last_name,e.salary,e.department_id
FROM employees e,(
		SELECT department_id,AVG(salary) avg_sal
		FROM employees
		GROUP BY department_id) t_dept_avg_sal)
WHERE e.department_id = t_dept_avg_sal.department_id
AND e.salary > t_dept_avg_sal.avg_sal
#练习:查询员工的id,salary,按照department_name排序
SELECT employee_id,salary
FROM employees e
ORDER BY (
	 SELECT department_name
	 FROM departments d
	 WHERE e.`department_id` = d.`department_id`
	) ASC;
#结论:在SELECT中,除了GROUP BY和LIMIT之外,其他位置都可以声明子查询！
/*
练习:若employees表中employee_id与job_history表中employee_id相同的数目不小于2
输出这些相同id的员工的employee_id,last_name和其job_id
*/
SELECT employee_id,last_name,job_id
FROM employees e
WHERE 2 <= (
	    SELECT COUNT(*)
	    FROM job_history j
	    WHERE e.`employee_id` = j.`employee_id`
	    );
#EXISTS与NOT EXISTS关键字
#练习:查询公司管理者的employee_id,last_name,job_id,department_id信息
#方式1:自连接
SELECT DISTINCT e2.employee_id,e2.last_name,e2.job_id,e2.department_id
FROM employees e1 JOIN employees e2
ON e1.manager_id = e2.employee_id;

SELECT DISTINCT e1.employee_id,e1.last_name,e1.job_id,e1.department_id
FROM employees e1 JOIN employees e2
ON e1.employee_id = e2.manager_id;
#方式2:子查询
SELECT employee_id,last_name,job_id,department_id
FROM employees
WHERE employee_id IN (
		SELECT DISTINCT manager_id
		FROM employees
		);
#方式3:EXISTS
SELECT employee_id,last_name,job_id,department_id
FROM employees e1
WHERE EXISTS (
		SELECT *
		FROM employees e2
		WHERE e1.employee_id = e2.manager_id
		);
#e1的每一条记录送进子查询中看是否匹配

#练习:查询departments表中,不存在于employees表中的部门的department_id和department_name
#方式1:
SELECT d.department_id,d.department_name
FROM employees e RIGHT JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE e.`department_id` IS NULL;
#方式2:
SELECT department_id,department_name
FROM departments d
WHERE NOT EXISTS (
		SELECT *
		FROM employees e
		WHERE d.`department_id` = e.`department_id`
		);

SELECT COUNT(*)
FROM departments;

#练习题:
#1.查询和Zlotkey相同部门的员工姓名和工资
SELECT last_name , salary
FROM employees
WHERE department_id = (
			SELECT department_id
			FROM employees
			WHERE last_name = 'Zlotkey'
			);
#2.查询工资比公司平均工资高的员工的员工号,姓名和工资
SELECT employee_id , last_name , salary
FROM employees
WHERE salary > (
		SELECT AVG(salary)
		FROM employees
		);
#3.选择工资大于所有JOB_ID = 'SA_MAN'的员工的工资的员工的last_name,job_id,salary
SELECT last_name,job_id,salary
FROM employees
WHERE salary > ALL (
		SELECT salary
		FROM employees
		WHERE job_id = 'SA_MAN' 
		);
#4.查询和姓名中包含字母u的员工在相同部门的员工的员工号和姓名
SELECT employee_id , last_name
FROM employees
WHERE department_id IN (
			SELECT department_id
			FROM employees
			WHERE last_name LIKE '%u%'
			)
AND last_name NOT LIKE '%u%';
#5.查询在部门的location_id为1700的部门工作的员工的员工号
SELECT employee_id
FROM employees
WHERE department_id IN (
			SELECT department_id
			FROM departments
			WHERE location_id = 1700
			);
#6.查询管理者是King的员工姓名和工资
SELECT last_name , salary
FROM employees
WHERE manager_id IN (
		SELECT employee_id
		FROM employees
		WHERE last_name = 'King'
		);
#7.查询工资最低的员工信息:last_name,salary
SELECT last_name , salary
FROM employees
WHERE salary <= ALL (
		SELECT salary
		FROM employees
		);
#8.查询平均工资最低的部门信息
SELECT *
FROM departments
WHERE department_id = (
			SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING AVG(salary) = (
						SELECT MIN(avg_sal)
						FROM(
						SELECT AVG(salary) avg_sal
						FROM employees
						GROUP BY department_id
						    )dep_avg_sal
						)
			);
#方式2：
SELECT *
FROM departments
WHERE department_id = (
			SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING AVG(salary ) <= ALL(
						SELECT AVG(salary)
						FROM employees
						GROUP BY department_id
						)
			);

#方式3： LIMIT
SELECT *
FROM departments
WHERE department_id = (
			SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING AVG(salary ) =(
						SELECT AVG(salary) avg_sal
						FROM employees
						GROUP BY department_id
						ORDER BY avg_sal ASC
						LIMIT 1		
						)
			);

#方式4：
SELECT d.*
FROM departments d,(
		SELECT department_id,AVG(salary) avg_sal
		FROM employees
		GROUP BY department_id
		ORDER BY avg_sal ASC
		LIMIT 0,1
		) t_dept_avg_sal
WHERE d.`department_id` = t_dept_avg_sal.department_id
#9.查询平均工资最低的部门信息和该部门的平均工资（相关子查询）
#方式1：
SELECT d.*,(SELECT AVG(salary) FROM employees WHERE department_id = d.`department_id`) avg_sal
FROM departments d
WHERE department_id = (
			SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING AVG(salary ) = (
						SELECT MIN(avg_sal)
						FROM (
							SELECT AVG(salary) avg_sal
							FROM employees
							GROUP BY department_id
							) t_dept_avg_sal

						)
			);

#方式2：
SELECT d.*,(SELECT AVG(salary) FROM employees WHERE department_id = d.`department_id`) avg_sal
FROM departments d
WHERE department_id = (
			SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING AVG(salary ) <= ALL(
						SELECT AVG(salary)
						FROM employees
						GROUP BY department_id
						)
			);

#方式3： LIMIT
SELECT d.*,(SELECT AVG(salary) FROM employees WHERE department_id = d.`department_id`) avg_sal
FROM departments d
WHERE department_id = (
			SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING AVG(salary ) =(
						SELECT AVG(salary) avg_sal
						FROM employees
						GROUP BY department_id
						ORDER BY avg_sal ASC
						LIMIT 1		
						)
			);

#方式4：
SELECT d.*,(SELECT AVG(salary) FROM employees WHERE department_id = d.`department_id`) avg_sal
FROM departments d,(
		SELECT department_id,AVG(salary) avg_sal
		FROM employees
		GROUP BY department_id
		ORDER BY avg_sal ASC
		LIMIT 0,1
		) t_dept_avg_sal
WHERE d.`department_id` = t_dept_avg_sal.department_id

#10.查询平均工资最高的 job 信息
#方式1：
SELECT *
FROM jobs
WHERE job_id = (
		SELECT job_id
		FROM employees
		GROUP BY job_id
		HAVING AVG(salary) = (
					SELECT MAX(avg_sal)
					FROM (
						SELECT AVG(salary) avg_sal
						FROM employees
						GROUP BY job_id
						) t_job_avg_sal
					)
		);
#方式2：
SELECT *
FROM jobs
WHERE job_id = (
		SELECT job_id
		FROM employees
		GROUP BY job_id
		HAVING AVG(salary) >= ALL(
				     SELECT AVG(salary) 
				     FROM employees
				     GROUP BY job_id
				     )
		);
#方式3：
SELECT *
FROM jobs
WHERE job_id = (
		SELECT job_id
		FROM employees
		GROUP BY job_id
		HAVING AVG(salary) =(
				     SELECT AVG(salary) avg_sal
				     FROM employees
				     GROUP BY job_id
				     ORDER BY avg_sal DESC
				     LIMIT 0,1
				     )
		);
#方式4：
SELECT j.*
FROM jobs j,(
		SELECT job_id,AVG(salary) avg_sal
		FROM employees
		GROUP BY job_id
		ORDER BY avg_sal DESC
		LIMIT 0,1		
		) t_job_avg_sal
WHERE j.job_id = t_job_avg_sal.job_id			
#11.查询平均工资高于公司平均工资的部门有哪些?
SELECT department_id
FROM employees
GROUP BY department_id
HAVING AVG(salary) > (
			SELECT AVG(salary)
			FROM employees
			)
AND department_id IS NOT NULL;	
#12.查询出公司中所有 manager 的详细信息
#方式1:自连接  xxx worked for yyy
SELECT DISTINCT mgr.employee_id,mgr.last_name,mgr.job_id,mgr.department_id
FROM employees emp JOIN employees mgr
ON emp.manager_id = mgr.employee_id;
#方式2:子查询
SELECT employee_id,last_name,job_id,department_id
FROM employees
WHERE employee_id IN (
			SELECT DISTINCT manager_id
			FROM employees
			);
#方式3:使用EXISTS
SELECT employee_id,last_name,job_id,department_id
FROM employees e1
WHERE EXISTS (
	       SELECT *
	       FROM employees e2
	       WHERE e1.`employee_id` = e2.`manager_id`
	     );
#13.各个部门中 最高工资中最低的那个部门的 最低工资是多少?
#方式1：
SELECT MIN(salary)
FROM employees
WHERE department_id = (
			SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING MAX(salary) = (
						SELECT MIN(max_sal)
						FROM (
							SELECT MAX(salary) max_sal
							FROM employees
							GROUP BY department_id
							) t_dept_max_sal
						)
			);

SELECT *
FROM employees
WHERE department_id = 10;
#方式2：
SELECT MIN(salary)
FROM employees
WHERE department_id = (
			SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING MAX(salary) <= ALL (
						SELECT MAX(salary)
						FROM employees
						GROUP BY department_id
						)
			);
#方式3：
SELECT MIN(salary)
FROM employees
WHERE department_id = (
			SELECT department_id
			FROM employees
			GROUP BY department_id
			HAVING MAX(salary) = (
						SELECT MAX(salary) max_sal
						FROM employees
						GROUP BY department_id
						ORDER BY max_sal ASC
						LIMIT 0,1
						)
			);			
#方式4：
SELECT MIN(salary)
FROM employees e,(
		SELECT department_id,MAX(salary) max_sal
		FROM employees
		GROUP BY department_id
		ORDER BY max_sal ASC
		LIMIT 0,1
		) t_dept_max_sal
WHERE e.department_id = t_dept_max_sal.department_id
#14.查询平均工资最高的部门的 manager 的详细信息: last_name,department_id,email,salary
SELECT last_name,department_id,email,salary
FROM employees
WHERE employee_id  =     (
			SELECT manager_id
			FROM departments
			WHERE department_id =   (
						SELECT department_id
						FROM employees
						GROUP BY department_id
						HAVING AVG(salary) = (
								SELECT MAX(avg_sal)
										FROM(
										SELECT AVG(salary) avg_sal
										FROM employees
										GROUP BY department_id)dep_avg_sal
								      )
						)
			);
#方式2：
SELECT last_name, department_id, email, salary
FROM employees
WHERE employee_id = ANY (
			SELECT DISTINCT manager_id
			FROM employees
			WHERE department_id = (
						SELECT department_id
						FROM employees
						GROUP BY department_id
						HAVING AVG(salary) >= ALL (
								SELECT AVG(salary) avg_sal
								FROM employees
								GROUP BY department_id
								)
						)
			);
#方式3：
SELECT last_name, department_id, email, salary
FROM employees
WHERE employee_id IN (
			SELECT DISTINCT manager_id
			FROM employees e,(
					SELECT department_id,AVG(salary) avg_sal
					FROM employees
					GROUP BY department_id
					ORDER BY avg_sal DESC
					LIMIT 0,1
					) t_dept_avg_sal
			WHERE e.`department_id` = t_dept_avg_sal.department_id
			);					      
#15.查询部门的部门号,其中不包括job_id是"ST_CLERK"的部门号
#方式1：
SELECT department_id
FROM departments
WHERE department_id NOT IN (
			SELECT DISTINCT department_id
			FROM employees
			WHERE job_id = 'ST_CLERK'
			);
#方式2：
SELECT department_id
FROM departments d
WHERE NOT EXISTS (
		SELECT *
		FROM employees e
		WHERE d.`department_id` = e.`department_id`
		AND e.`job_id` = 'ST_CLERK'
		);
#16.选择所有没有管理者的员工的last_name
#方式1:
SELECT last_name
FROM employees
WHERE manager_id IS NULL;
#方式2:
SELECT last_name
FROM employees emp
WHERE NOT EXISTS (
		SELECT *
		FROM employees mgr
		WHERE emp.`manager_id` = mgr.`employee_id`
		);
#17.查询员工号、姓名、雇用时间、工资,其中员工的管理者为 'De Haan'
#方式1:
SELECT employee_id , last_name , DATEDIFF(NOW(),hire_date) , salary
FROM employees
WHERE manager_id = (
			SELECT employee_id
			FROM employees
			WHERE last_name = 'De Haan'
			);
#方式2：
SELECT employee_id,last_name,hire_date,salary
FROM employees e1
WHERE EXISTS (
		SELECT *
		FROM employees e2
		WHERE e1.`manager_id` = e2.`employee_id`
		AND e2.last_name = 'De Haan'
		); 
#18.查询各部门中工资比本部门平均工资高的员工的员工号,姓名和工资（相关子查询）
#方式1:
SELECT employee_id , last_name , salary
FROM employees e1
WHERE salary > (
		SELECT AVG(salary)
		FROM employees e2
		WHERE e1.department_id = e2.department_id
		);
#方式2：在FROM中声明子查询
SELECT e.last_name,e.salary,e.department_id
FROM employees e,(
		SELECT department_id,AVG(salary) avg_sal
		FROM employees
		GROUP BY department_id) t_dept_avg_sal
WHERE e.department_id = t_dept_avg_sal.department_id
AND e.salary > t_dept_avg_sal.avg_sal
#19.查询每个部门下的部门人数大于 5 的部门名称（相关子查询）
SELECT department_name
FROM departments d
WHERE 5 < (
	   SELECT COUNT(*)
	   FROM employees e
	   WHERE d.department_id = e.`department_id`
	  );
#20.查询每个国家下的部门个数大于 2 的国家编号（相关子查询）
SELECT * FROM locations;

SELECT country_id
FROM locations l
WHERE 2 < (
	   SELECT COUNT(*)
	   FROM departments d
	   WHERE l.`location_id` = d.`location_id`
	 );























