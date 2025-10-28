# 算数运算符
# + - * /(div) %(mod)
SELECT 100 , 100 + 10 , 100 + 3.5 , 100 + 50 * 30
FROM DUAL; 

SELECT 100 + '1' # 101 会把'1'转换成数值1（隐式转换）
FROM DUAL;

SELECT 100 + 'a' #此时把'a'看作0来处理 如果不能隐式的转换那么看作是0
FROM DUAL;

SELECT 100 + NULL #null 第三章讲过
FROM DUAL;

SELECT 100 / 0 , 100 * 1, 100 * 1.0, 100 / 1.0, 100 / 2,100 + 2 * 5 / 2,100 /3, 100 DIV 0 
FROM DUAL; # 100 / 0 是null 100 / 2 是浮点型

SELECT 100 / 3 , 100 DIV 3
FROM DUAL;

# 查询员工id为偶数的员工信息
SELECT * FROM employees
WHERE employee_id % 2 = 0;

# 比较运算符 比较运算符用来对表达式左边的操作数和右边的操作数进行比较
# 比较的结果为真则返回1，比较的结果为假则返回0，其他情况则返回NULL。
# = <=> 
#<>和!=都是不等于
# < <= > >= 
SELECT 1 = 2 , 1 <> 2 , 1 = '1' , 1 = 'a' , 0 = 'a' , 'a' = 'a' , 'a' = 'b' #两边都是字符串的话按照ANSI的比较规则比较
FROM DUAL;

SELECT 1 = NULL ,NULL = NULL # 只要有null参与判断结果就是null
FROM DUAL;

SELECT last_name , salary
FROM employees
WHERE commission_pct = NULL; # 不会有任何结果

# <=>:安全等于 解决与null比较的问题 ‘<=>’可以用来对NULL进行判断。
# 在两个操作数均为NULL时，其返回值为1，而不为NULL;
# 当一个操作数为NULL时，其返回值为0，而不为NULL。
SELECT 1 <=> '1', 1 <=> 0, 'a' <=> 'a', (5 + 3) <=> (2 + 6), '' <=> NULL,NULL <=> NULL 
FROM DUAL;
# 练习 查询commission_pct为null的有哪些
SELECT last_name , salary , commission_pct
FROM employees
WHERE commission_pct <=> NULL;

# 非符号类型的运算符
# IS NULL \ IS NOT NULL \ ISNULL
SELECT last_name , salary , commission_pct
FROM employees
WHERE commission_pct IS NULL; # IS NULL 判断值，字符串，表达式是否为空

SELECT last_name , salary , commission_pct
FROM employees
WHERE commission_pct IS NOT NULL;# 判断是否不为空

SELECT last_name , salary , commission_pct
FROM employees
WHERE ISNULL(commission_pct); #ISNULL是个函数 ISNULL(commission_pct)是判断是否为空

SELECT last_name , salary , commission_pct
FROM employees
WHERE NOT commission_pct <=> NULL; #判断不为空

# LEAST()返回最小值 \ GREATEST()返回最大值
SELECT LEAST('s','e','t','a','o'),GREATEST('s','e','t','a','o')
FROM DUAL;

SELECT LEAST(first_name,last_name)# 注意不是比较字符串的长短
FROM employees;#这个SQL语句的作用是比较每个员工的first_name和last_name,并返回按字典顺序（lexicographical order）较小的那个值

SELECT LEAST(LENGTH(first_name),LENGTH(last_name))# 这个是比较字符串的长短
FROM employees;

# BETWEEN 条件下界 AND 条件上界
# 查询工资在6000 - 8000的员工信息
SELECT employee_id , first_name , last_name ,salary# 包括边界值
FROM employees
WHERE salary BETWEEN 6000 AND 8000;

SELECT employee_id , first_name , last_name ,salary
FROM employees
WHERE salary BETWEEN 8000 AND 6000;# 没有结果

SELECT employee_id , first_name , last_name ,salary# 不包括边界值
FROM employees
WHERE salary NOT BETWEEN 6000 AND 8000;

# IN(set) \ NOT IN(set)
#IN 判断一个值是否为列表中的任意一个值 例如：
SELECT employee_id ,last_name,department_id
FROM employees
WHERE department_id IN(10,20,30);# 判断员工的department_id是否为(10,20,30)中的一个
# BETWEEN AND是一个范围 IN是离散的几个数字
#查询工资不是6000 7000 8000的员工
SELECT employee_id , last_name,salary
FROM employees
WHERE salary NOT IN(6000,7000,8000);

#LIKE:模糊查询
#练习：查询last_name中包含字符'a'的员工信息
SELECT last_name
FROM employees
WHERE last_name LIKE '%a%';#%代表不确定个数的字符(0个，1个或多个) %a%就是只要这个字符串中有a就可以

SELECT last_name
FROM employees
WHERE last_name LIKE 'a%';#此时是查询以a开头的
#练习：查询查询last_name中包含字符'a'并且包含'e'的员工信息
SELECT last_name
FROM employees
WHERE last_name LIKE '%a%e' OR last_name LIKE '%e%%a';#如果只写WHERE last_name LIKE '%a%e'的话是字符'a'并且包含'e'但是必须是a在前e在后

SELECT last_name
FROM employees
WHERE last_name LIKE '%a%' AND last_name LIKE '%e%';

SELECT last_name
FROM employees
WHERE last_name LIKE '%a%' && last_name LIKE '%e%';

#练习：查询第二个字符是'a'的员工信息
#此时引入_ 一个_代表一个不确定的字符
SELECT last_name
FROM employees
WHERE last_name LIKE '_a%';

#练习：查询第二个字符是_并且第三个字符是'a'的员工信息
#需要使用转义字符
SELECT last_name
FROM employees
WHERE last_name LIKE '_\_a%';

#正则表达式 REGEXP \ RLIKE
#REGEXP运算符用来匹配字符串，语法格式为：`expr REGEXP 匹配条件`。
#如果expr满足匹配条件，返回1；如果不满足，则返回0。
#若expr或匹配条件任意一个为NULL，则结果为NULL。
SELECT 'shkstart' REGEXP '^s', 'shkstart' REGEXP 't$', 'shkstart' REGEXP 'hk'
FROM DUAL;

SELECT 'atguigu' REGEXP 'gu.gu'
FROM DUAL;

SELECT 'atguigu' REGEXP 'gu..gu'
FROM DUAL;

#逻辑运算符: OR || \ AND && \ NOT !
SELECT employee_id ,last_name,department_id
FROM employees
WHERE department_id = 10 OR department_id = 20; 
 
SELECT employee_id ,last_name,department_id
FROM employees
WHERE department_id = 10 AND salary > 20; 

SELECT last_name , salary , commission_pct
FROM employees
WHERE NOT commission_pct <=> NULL;

#OR可以和AND一起使用，但是在使用时要注意两者的优先级
#由于AND的优先级高于OR，因此先对AND两边的操作数进行操作，再与OR中的操作数结合。

SELECT 5 >> 1
FROM DUAL;
# 练习
# 1.选择工资不在5000到12000的员工的姓名和工资
SELECT first_name , last_name , salary
FROM employees
WHERE salary NOT BETWEEN 5000 AND 12000;
# 2.选择在20或50号部门工作的员工姓名和部门号
SELECT first_name , last_name , department_id
FROM employees
WHERE department_id IN(20,50);
# 3.选择公司中没有管理者的员工姓名及job_id
SELECT first_name , last_name , job_id
FROM employees
WHERE manager_id <=> NULL;
# 4.选择公司中有奖金的员工姓名，工资和奖金级别
SELECT first_name , last_name , salary , commission_pct
FROM employees
WHERE commission_pct IS NOT NULL;
# 5.选择员工姓名的第三个字母是a的员工姓名
SELECT first_name , last_name
FROM employees
WHERE last_name LIKE '__a%';
# 6.选择姓名中有字母a和k的员工姓名
SELECT first_name , last_name
FROM employees
WHERE last_name LIKE '%a%' AND last_name LIKE '%k%';
# 7.显示出表 employees 表中 first_name 以 'e'结尾的员工信息
SELECT * FROM employees
#where first_name REGEXP 'e$';
WHERE first_name LIKE '%e';
# 8.显示出表 employees 部门编号在 80-100 之间的姓名、工种
SELECT first_name , last_name , job_id
FROM employees
WHERE department_id BETWEEN 80 AND 100;
# 9.显示出表 employees 的 manager_id 是 100,101,110 的员工姓名、工资、管理者id
SELECT first_name , last_name , salary , manager_id
FROM employees
WHERE manager_id IN(100,101,110);












