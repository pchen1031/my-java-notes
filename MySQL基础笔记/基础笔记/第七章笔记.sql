#单行函数

#数值函数
SELECT ABS(-123)
,ABS(32)#ABS(x)返回x的绝对值
,SIGN(-23)#SIGN(X)返回X的符号.正数返回1,负数返回-1,0返回0
,SIGN(43)
,PI()#PI()返回圆周率的值
,CEIL(32.32)
,CEILING(-43.23)#CEIL(x),CEILING(x)返回大于或等于某个值的最小整数
,FLOOR(32.32)
,FLOOR(-43.23)#返回小于或等于某个值的最大整数
,MOD(12,5)#MOD(x,y)返回X除以Y后的余数
FROM DUAL;

/*
RAND()返回0~1的随机值
RAND(x)返回0~1的随机值,其中x的值用作种子值,相同的X值会产生相同的随机数并且无论运行多少次得到的随机数一样
ROUND(x)返回一个对x的值进行四舍五入后,最接近于X的整数 不管X是几位小数,只看第一位就行

ROUND(x,y)返回一个对x的值进行四舍五入后最接近X的值,并保留到小数点后面Y位
其实就是对x进行保留y位小数的四舍五入
y=0的话等价于ROUND(x)

TRUNCATE(x,y)返回数字x截断为y位小数的结果 不是四舍五入是直接不要了
*/
SELECT RAND()
,RAND()
,RAND(10)
,RAND(10)
,RAND(-1)
,RAND(-1)
FROM DUAL;
#四舍五入,截断操作
SELECT ROUND(13.5)
,ROUND(12.343,2)
,ROUND(12.324,-1)
,ROUND(13,-1)
,ROUND(16,-1)
,TRUNCATE(12.66,1)
,TRUNCATE(16.66,-1)
FROM DUAL;

#单行函数可以嵌套
SELECT TRUNCATE(ROUND(123.46,2),2)#当x本身的小数位数等于y时,ROUND(x,y)会原样返回该数字,不会进行任何舍入
FROM DUAL;

#角度和弧度互换函数
/*
 RADIANS(x)将角度转化为弧度,其中,参数x为角度值
 DEGREES(x)将弧度转化为角度,其中,参数x为弧度值
*/
SELECT RADIANS(60)
FROM DUAL;

SELECT DEGREES(PI()) , DEGREES(RADIANS(60))
FROM DUAL;

#三角函数
/*
SIN(x)返回x的正弦值,其中,参数x为弧度值
ASIN(x)返回x的反正弦值,即获取正弦为x的弧度值.如果x的值不在-1到1之间,则返回NULL
COS(x)返回x的余弦值,其中,参数x为弧度值
ACOS(x)返回x的反余弦值,即获取余弦为x的弧度值.如果x的值不在-1到1之间,则返回NULL
TAN(x)返回x的正切值,其中,参数x为弧度值
ATAN(x)返回x的反正切值,即返回正切值为x的弧度值
ATAN2(m,n)返回两个参数的反正切值
COT(x)返回x的余切值,其中,X为弧度值
*/
SELECT SIN(RADIANS(30))
,ASIN(1)
,DEGREES(ASIN(1))
,TAN(RADIANS(45))
,DEGREES(ATAN(1))
,DEGREES(ATAN2(1,1))
FROM DUAL;

#指数和对数
/*
POW(x,y),POWER(X,Y)返回x的y次方
EXP(X)返回e的X次方,其中e是一个常数,2.718281828459045
LN(X),LOG(X)返回以e为底的X的对数,当X <= 0 时,返回的结果为NULL
LOG10(X)返回以10为底的X的对数,当X <= 0 时,返回的结果为NULL
LOG2(X)返回以2为底的X的对数,当X <= 0 时,返回NULL
*/
SELECT POW(2,5)
,POWER(2,4)
,EXP(2)
,LN(10)
,LOG10(10)
,LOG2(4)
FROM DUAL;

SELECT LN(EXP(2))
,LOG(EXP(2))
,LOG10(10)
,LOG2(4)
FROM DUAL;

#进制间的转换
/*
BIN(x)返回x的二进制编码
HEX(x)返回x的十六进制编码
OCT(x)返回x的八进制编码
CONV(x,f1,f2)返回f1进制数变成f2进制数
*/
SELECT BIN(10)
,HEX(10)
,OCT(10)
,OCT(2)
,CONV(10,2,8)#这里的10不是十进制的10 是二进制的10 对应的十进制为2 也就是2用八进制来表示
FROM DUAL;

#字符串函数
/*
ASCII(S)返回字符串S中的第一个字符的ASCII码值
CHAR_LENGTH(s)返回字符串s的字符数.作用与CHARACTER_LENGTH(s)相同
LENGTH(s)返回字符串s的字节数,和字符集有关
CONCAT(s1,s2,......,sn)连接s1,s2,......,sn为一个字符串
CONCAT_WS(x,s1,s2,......,sn)同CONCAT(s1,s2,...)函数,但是每个字符串之间要加上x
INSERT(str,idx,len,replacestr)将字符串str从第idx位置开始,len个字符长的子串替换为字符串replacestr
REPLACE(str,a,b)用字符串b替换字符串str中所有出现的字符串a
UPPER(s)或UCASE(s)将字符串s的所有字母转成大写字母
LOWER(s)或LCASE(s)将字符串s的所有字母转成小写字母
LEFT(str,n)返回字符串str最左边的n个字符
RIGHT(str,n)返回字符串str最右边的n个字符
LPAD(str,len,pad)用字符串pad对str最左边进行填充,直到str的长度为len个字符
RPAD(str,len,pad)用字符串pad对str最右边进行填充,直到str的长度为len个字符
LTRIM(s)去掉字符串s左侧的空格
RTRIM(s)去掉字符串s右侧的空格
TRIM(s)去掉字符串s开始与结尾的空格
TRIM(s1 FROM s)去掉字符串s开始与结尾的s1
TRIM(LEADING s1 FROM s)去掉字符串s开始处的s1
TRIM(TRAILING s1 FROM s)去掉字符串s结尾处的s1
REPEAT(str,n)返回str重复n次的结果
SPACE(n)返回n个空格
STRCMP(s1,s2)比较字符串s1,s2的ASCII码值的大小
SUBSTR(s,index,len)返回从字符串s的index位置其len个字符,作用与SUBSTRING(s,n,len)、MID(s,n,len)相同
LOCATE(substr,str)返回字符串substr在字符串str中首次出现的位置,作用于POSITION(substr IN str)、INSTR(str,substr)相同.未找到返回0
ELT(m,s1,s2,…,sn)返回指定位置的字符串,如果m=1,则返回s1,如果m=2,则返回s2,如果m=n,则返回sn
FIELD(s,s1,s2,…,sn)返回字符串s在字符串列表中第一次出现的位置
FIND_IN_SET(s1,s2)返回字符串s1在字符串s2中出现的位置.其中,字符串s2是一个以逗号分隔的字符串
REVERSE(s)返回s反转后的字符串
NULLIF(value1,value2)比较两个字符串,如果value1与value2相等,则返回NULL,否则返回value1
*/
SELECT ASCII('Abcdfsf')
,CHAR_LENGTH('hello')
,CHAR_LENGTH('我们')
,LENGTH('hello')
,LENGTH('我们')
FROM DUAL;
#注意一个是字符数一个是字节数

SELECT CONCAT(emp.last_name,' worked for ',mgr.last_name) "details"
FROM employees emp JOIN employees mgr
WHERE emp.`manager_id` = mgr.employee_id;

SELECT CONCAT_WS('-','hello','world','hello','beijing')
FROM DUAL;#效果和CONCAT一样 只不过每个字符串之间加速-

#！！！！在SQL中字符串的索引从1开始！！！！
SELECT INSERT('helloworld',2,3,'aaaaa')
,REPLACE('hello','ll','mmm')
,REPLACE('hello','lol','mmm')
FROM DUAL;

#UPPER变大写 LOWER变小写
SELECT UPPER('HelLo'),LOWER('HelLo')
FROM DUAL;

SELECT LEFT('hello',2)#从左边开始取2个字符
,RIGHT('hello',3)#从右边开始取3个字符
,RIGHT('hello',13)
FROM DUAL;

#LPAD:实现右对齐效果
#RPAD:实现左对齐效果
SELECT employee_id,last_name,LPAD(salary,10,'*')
FROM employees;

SELECT employee_id,last_name,RPAD(salary,10,'*')
FROM employees;

SELECT CONCAT('---',LTRIM('    h  el  lo   '),'***')
,TRIM('oo' FROM 'ooheollo')
FROM DUAL;

SELECT REPEAT('hello',4)
,LENGTH(SPACE(5))
,STRCMP('abc','abe')
FROM DUAL;

SELECT SUBSTR('hello',2,2)
,LOCATE('lll','hello')
FROM DUAL;

SELECT ELT(2,'a','b','c','d')
,FIELD('mm','gg','jj','mm','dd','mm')
,FIND_IN_SET('mm','gg,mm,jj,dd,mm,gg')
FROM DUAL;

SELECT employee_id
,NULLIF(LENGTH(first_name)
,LENGTH(last_name)) "compare"
FROM employees;

#日期和时间函数
/*
获取日期、时间:
CURDATE(),CURRENT_DATE()返回当前日期,只包含年、月、日
CURTIME(),CURRENT_TIME()返回当前时间,只包含时、分、秒
NOW()/SYSDATE()/CURRENT_TIMESTAMP()/LOCALTIME()/LOCALTIMESTAMP()返回数据库当前时区的时间（受 time_zone 设置影响）
UTC_DATE()返回UTC（世界标准时间）日期
UTC_TIME()返回UTC（世界标准时间）时间
*/
SELECT CURDATE()
,CURRENT_DATE()
,CURTIME()
,NOW()
,SYSDATE()
,UTC_DATE()
,UTC_TIME()
FROM DUAL;

SELECT CURDATE()
,CURDATE() + 0
,CURTIME() + 0
,NOW() + 0
FROM DUAL;
/*
使用+0操作,会触发隐式类型转换,将原始的日期/时间值转换为数值格式。
比如2025-06-02,加上0后,转换为数值YYYYMMDD（如20250602）
其他的以此类推
*/

/*
日期和时间戳的转换:
UNIX_TIMESTAMP()以UNIX时间戳的形式返回当前时间.SELECT UNIX_TIMESTAMP() ->1634348884
UNIX_TIMESTAMP(date)将时间date以UNIX时间戳的形式返回.
FROM_UNIXTIME(timestamp)将UNIX时间戳的时间转换为普通格式的时间
UNIX时间戳是秒数
*/
SELECT UNIX_TIMESTAMP()
,UNIX_TIMESTAMP('2025-6-2 12:12:32')
,FROM_UNIXTIME(1635173853)
,FROM_UNIXTIME(1750837316)
FROM DUAL;

/*
获取月份,星期,星期数,天数等函数:
YEAR(date)/MONTH(date)/DAY(date)返回具体的日期值
HOUR(time)/MINUTE(time)/SECOND(time)返回具体的时间值
MONTHNAME(date)返回月份:January,... 
DAYNAME(date)返回星期几:MONDAY，TUESDAY.....SUNDAY
WEEKDAY(date)返回周几,注意!!!!:周1是0,周2是1,...周日是6
QUARTER(date)返回日期对应的季度,范围为1～4
WEEK(date),WEEKOFYEAR(date)返回一年中的第几周
DAYOFYEAR(date)返回日期是一年中的第几天
DAYOFMONTH(date)返回日期位于所在月份的第几天
DAYOFWEEK(date)返回周几,注意:周日是1,周一是2,...周六是7
*/
SELECT YEAR(CURDATE())
,MONTH(CURDATE())
,DAY(CURDATE())
,HOUR(CURTIME())
,MINUTE(NOW())
,SECOND(SYSDATE())
FROM DUAL;

SELECT MONTHNAME('2021-10-26')
,DAYNAME('2021-10-26')
,WEEKDAY('2021-10-26')
,QUARTER(CURDATE())
,WEEK(CURDATE())
,DAYOFYEAR(NOW())
,DAYOFMONTH(NOW())
,DAYOFWEEK(NOW())
FROM DUAL;

/*
日期的操作函数:
EXTRACT(type FROM date)返回指定日期中特定的部分,type指定返回的值
*/
SELECT EXTRACT(SECOND FROM NOW())
,EXTRACT(DAY FROM NOW())
,EXTRACT(HOUR_MINUTE FROM NOW())
,EXTRACT(QUARTER FROM '2021-05-12')
FROM DUAL;

/*
时间和秒钟转换的函数:
TIME_TO_SEC(time)将time转化为秒并返回结果值.转化的公式为:`小时*3600+分钟*60+秒`
SEC_TO_TIME(seconds)将seconds描述转化为包含小时、分钟和秒的时间
*/
SELECT TIME_TO_SEC(CURTIME())
,SEC_TO_TIME(83355)
FROM DUAL;

/*
计算日期和时间的函数:
DATE_ADD(datetime,INTERVAL expr type),ADDDATE(date,INTERVAL expr type)返回与给定日期时间相差expr时间段的日期时间
DATE_SUB(date,INTERVAL expr type),SUBDATE(date,INTERVAL expr type)返回与date相减expr时间间隔的日期

ADDTIME(time1,time2)返回time1加上time2的时间.当time2为一个数字时,代表的是`秒`,可以为负数
SUBTIME(time1,time2)返回time1减去time2后的时间.当time2为一个数字时,代表的是`秒`,可以为负数
DATEDIFF(date1,date2)返回date1 - date2的日期间隔天数
TIMEDIFF(time1, time2)返回time1 - time2的时间间隔
FROM_DAYS(N)返回从0000年1月1日起,N天以后的日期
TO_DAYS(date)返回日期date距离0000年1月1日的天数
LAST_DAY(date)返回date所在月份的最后一天的日期
MAKEDATE(year,n)针对给定年份与所在年份中的天数返回一个日期
MAKETIME(hour,minute,second)将给定的小时、分钟和秒组合成时间并返回
PERIOD_ADD(time,n)返回time加上n后的时间
*/
SELECT NOW()
,DATE_ADD(NOW(),INTERVAL 1 YEAR)
,DATE_ADD(NOW(),INTERVAL -1 YEAR)
,DATE_SUB(NOW(),INTERVAL 1 YEAR)
FROM DUAL;

SELECT DATE_ADD(NOW(), INTERVAL 1 DAY) AS col1
,DATE_ADD('2021-10-21 23:32:12',INTERVAL 1 SECOND) AS col2
,ADDDATE('2021-10-21 23:32:12',INTERVAL 1 SECOND) AS col3
,DATE_ADD('2021-10-21 23:32:12',INTERVAL '1_1' MINUTE_SECOND) AS col4
,DATE_ADD(NOW(), INTERVAL -1 YEAR) AS col5#可以是负数
,DATE_ADD(NOW(), INTERVAL '1_1' YEAR_MONTH) AS col6 #需要单引号
FROM DUAL;

SELECT ADDTIME(NOW(),20)
,SUBTIME(NOW(),30)
,SUBTIME(NOW(),'1:1:3')
,DATEDIFF(NOW(),'2025-6-2 21:40:10')#就算传入的有时分秒也不参与运算
,TIMEDIFF(NOW(),'2025-6-2 21:40:10')
,FROM_DAYS(366),TO_DAYS('0000-12-25')
,LAST_DAY(NOW())
,MAKEDATE(YEAR(NOW()),32)
,MAKETIME(10,21,23)
,PERIOD_ADD(20200101010101,10)
FROM DUAL;

/*
日期的格式化与解析:
DATE_FORMAT(date,fmt)按照字符串fmt格式化日期date值
TIME_FORMAT(time,fmt)按照字符串fmt格式化时间time值
GET_FORMAT(date_type,format_type)返回日期字符串的显示格式
STR_TO_DATE(str, fmt)按照字符串fmt对str进行解析,解析为一个日期
*/
# 格式化:日期 ---> 字符串
# 解析:字符串 ----> 日期

#此时我们谈的是日期的显式格式化和解析

#之前,我们接触过隐式的格式化或解析
SELECT *
FROM employees
WHERE hire_date = '1993-01-13';

#格式化：
SELECT DATE_FORMAT(CURDATE(),'%Y-%M-%D')
,DATE_FORMAT(NOW(),'%Y-%m-%d')
,TIME_FORMAT(CURTIME(),'%h:%i:%S')
,DATE_FORMAT(NOW(),'%Y-%M-%D %h:%i:%S %W %w %T %r')
FROM DUAL;

#解析：格式化的逆过程
SELECT STR_TO_DATE('2021-October-25th 11:37:30 Monday 1','%Y-%M-%D %h:%i:%S %W %w')
,STR_TO_DATE('01/01/1997', '%m/%d/%Y')
FROM DUAL;

SELECT GET_FORMAT(DATE,'USA')
FROM DUAL;

SELECT DATE_FORMAT(CURDATE(),GET_FORMAT(DATE,'USA'))
FROM DUAL;

#流程控制函数
/*
IF(value,value1,value2)如果value的值为TRUE,返回value1,否则返回value2
IFNULL(value1, value2)如果value1不为NULL,返回value1,否则返回value2
CASE WHEN 条件1 THEN 结果1 WHEN 条件2 THEN 结果2...[ELSE resultn] END相当于Java的if...else if...else...
CASE expr WHEN 常量值1 THEN 值1 WHEN 常量值1 THEN 值1 .... [ELSE 值n] END相当于Java的switch...case...
*/
SELECT last_name,salary,IF(salary >= 6000,'高工资','低工资') "details"
FROM employees;

SELECT last_name,commission_pct
,IF(commission_pct IS NOT NULL,commission_pct,0) "details"
,salary * 12 * (1 + IF(commission_pct IS NOT NULL,commission_pct,0)) "annual_sal"
FROM employees;

#IFNULL(VALUE1,VALUE2):看做是IF(VALUE,VALUE1,VALUE2)的特殊情况
SELECT last_name,commission_pct,IFNULL(commission_pct,0) "details"
FROM employees;

#CASE WHEN ... THEN ...WHEN ... THEN ... ELSE ... END
#类似于java的if ... else if ... else if ... else
SELECT last_name,salary,CASE WHEN salary >= 15000 THEN '白骨精' 
			     WHEN salary >= 10000 THEN '潜力股'
			     WHEN salary >= 8000 THEN '小屌丝'
			     ELSE '草根' END "details",department_id
FROM employees;

SELECT last_name,salary,CASE WHEN salary >= 15000 THEN '白骨精' 
			     WHEN salary >= 10000 THEN '潜力股'
			     WHEN salary >= 8000 THEN '小屌丝'
			     END "details"
FROM employees;

#CASE ... WHEN ... THEN ... WHEN ... THEN ... ELSE ... END
#类似于java的swich ... case...
/*
练习1
查询部门号为10,20,30 的员工信息, 
若部门号为10,则打印其工资的1.1倍, 
20号部门,则打印其工资的1.2倍, 
30号部门,打印其工资的1.3倍数,
其他部门,打印其工资的1.4倍数.
*/
SELECT employee_id,last_name,department_id,salary,CASE department_id WHEN 10 THEN salary * 1.1
								     WHEN 20 THEN salary * 1.2
								     WHEN 30 THEN salary * 1.3
								     ELSE salary * 1.4 END "details"
FROM employees;

/*
练习2
查询部门号为10,20,30的员工信息, 
若部门号为10,则打印其工资的1.1倍, 
20号部门,则打印其工资的1.2倍, 
30号部门打印其工资的1.3倍数
*/
SELECT employee_id,last_name,department_id,salary,CASE department_id WHEN 10 THEN salary * 1.1
								     WHEN 20 THEN salary * 1.2
								     WHEN 30 THEN salary * 1.3
								     END "details"
FROM employees
WHERE department_id IN (10,20,30);

#加密与解密函数
/*
PASSWORD(str)返回字符串str的加密版本,41位长的字符串.加密结果`不可逆`,常用于用户的密码加密
MD5(str)返回字符串str的md5加密后的值,也是一种加密方式.若参数为NULL,则会返回NULL,加密结果`不可逆`
SHA(str)从原明文密码str计算并返回加密后的密码字符串,当参数为NULL时,返回NULL.`SHA加密算法比MD5更加安全`.
ENCODE(value,password_seed)返回使用password_seed作为加密密码加密value
DECODE(value,password_seed)返回使用password_seed作为加密密码解密value
*/
#PASSWORD()在mysql8.0中弃用。
SELECT MD5('mysql'),MD5('mysql'),SHA('mysql'),MD5(MD5('mysql'))
FROM DUAL;

#ENCODE()\DECODE() 在mysql8.0中弃用。
/*
SELECT ENCODE('atguigu','mysql'),DECODE(ENCODE('atguigu','mysql'),'mysql')
FROM DUAL;
*/

#MySQL信息函数
/*
VERSION()返回当前MySQL的版本号
CONNECTION_ID()返回当前MySQL服务器的连接数
DATABASE(),SCHEMA()返回MySQL命令行当前所在的数据库
USER(),CURRENT_USER()、SYSTEM_USER(),SESSION_USER()返回当前连接MySQL的用户名,返回结果格式为“主机名@用户名”
CHARSET(value)返回字符串value自变量的字符集
COLLATION(value)返回字符串value的比较规则
*/
SELECT VERSION()
,CONNECTION_ID()
,DATABASE(),SCHEMA()
,USER()
,CURRENT_USER()
,CHARSET('尚硅谷')
,COLLATION('尚硅谷')
FROM DUAL;

#7. 其他函数
/*
FORMAT(value,n)返回对数字value进行格式化后的结果数据.n表示`四舍五入`后保留到小数点后n位
CONV(value,from,to)将value的值进行不同进制之间的转换
INET_ATON(ipvalue)将以点分隔的IP地址转化为一个数字
INET_NTOA(value)将数字形式的IP地址转化为以点分隔的IP地址
BENCHMARK(n,expr)将表达式expr重复执行n次.用于测试MySQL处理expr表达式所耗费的时间
CONVERT(value USING char_code)将value所使用的字符编码修改为char_code
*/
#如果n的值小于或者等于0，则只保留整数部分
SELECT FORMAT(123.125,2)
,FORMAT(123.625,0)
,FORMAT(123.125,-2)
FROM DUAL;

SELECT CONV(16, 10, 2)
, CONV(8888,10,16)
, CONV(NULL, 10, 2)
FROM DUAL;
#以“192.168.1.100”为例，计算方式为192乘以256的3次方，加上168乘以256的2次方，加上1乘以256，再加上100。
SELECT INET_ATON('192.168.1.100')
,INET_NTOA(3232235876)
FROM DUAL;

#BENCHMARK()用于测试表达式的执行效率
SELECT BENCHMARK(1000000,MD5('mysql'))
FROM DUAL;

# CONVERT():可以实现字符集的转换
SELECT CHARSET('atguigu')
,CHARSET(CONVERT('atguigu' USING 'gbk'))
FROM DUAL;



#第07章_单行函数的课后练习
# 1.显示系统时间(注：日期+时间)
SELECT NOW()
,SYSDATE()
,CURRENT_TIMESTAMP()
,LOCALTIME()
,LOCALTIMESTAMP() #大家只需要掌握一个函数就可以了
FROM DUAL;
# 2.查询员工号,姓名,工资,以及工资提高百分之20%后的结果（new salary）
SELECT employee_id,last_name,salary,salary * 1.2 "new salary"
FROM employees;
# 3.将员工的姓名按首字母排序,并写出姓名的长度（length）
SELECT last_name,LENGTH(last_name) "name_length"
FROM employees
#order by last_name asc;
ORDER BY name_length ASC;
# 4.查询员工id,last_name,salary,并作为一个列输出,别名为OUT_PUT
SELECT CONCAT(employee_id,',',last_name,',',salary) "OUT_PUT"
FROM employees;
# 5.查询公司各员工工作的年数、工作的天数,并按工作年数的降序排序
SELECT employee_id
,DATEDIFF(CURDATE(),hire_date)/365 "worked_years",DATEDIFF(CURDATE(),hire_date) "worked_days"
,TO_DAYS(CURDATE()) - TO_DAYS(hire_date) "worked_days1"
FROM employees
ORDER BY worked_years DESC;
# 6.查询员工姓名,hire_date,department_id,满足以下条件:
#雇用时间在1997年之后，department_id 为80 或 90 或110,commission_pct不为空
SELECT last_name,hire_date,department_id
FROM employees
WHERE department_id IN (80,90,110)
AND commission_pct IS NOT NULL
#and hire_date >= '1997-01-01';  #存在着隐式转换
#and  date_format(hire_date,'%Y-%m-%d') >= '1997-01-01';  # 显式转换操作，格式化：日期---> 字符串
#and  date_format(hire_date,'%Y') >= '1997';   # 显式转换操作，格式化
AND hire_date >= STR_TO_DATE('1997-01-01','%Y-%m-%d');# 显式转换操作，解析：字符串 ----> 日期
# 7.查询公司中入职超过10000天的员工姓名、入职时间
SELECT last_name,hire_date
FROM employees
WHERE DATEDIFF(CURDATE(),hire_date) >= 10000;
# 8.做一个查询，产生下面的结果
#<last_name> earns <salary> monthly but wants <salary*3> 
SELECT CONCAT(last_name,' earns ',TRUNCATE(salary,0)
,' monthly but wants '
,TRUNCATE(salary * 3,0)) "Dream Salary"
FROM employees;
# 9.使用case-when，按照下面的条件：
/*job                  grade
AD_PRES              	A
ST_MAN               	B
IT_PROG              	C
SA_REP               	D
ST_CLERK             	E

产生下面的结果:
*/
SELECT last_name "Last_name",job_id "Job_id",CASE job_id WHEN 'AD_PRES' THEN 'A'
							 WHEN 'ST_MAN' THEN 'B'
							 WHEN 'IT_PROG' THEN 'C'
							 WHEN 'SA_REP' THEN 'D'
							 WHEN 'ST_CLERK' THEN 'E'
							 END "Grade"
FROM employees;


SELECT last_name "Last_name",job_id "Job_id",CASE job_id WHEN 'AD_PRES' THEN 'A'
							 WHEN 'ST_MAN' THEN 'B'
							 WHEN 'IT_PROG' THEN 'C'
							 WHEN 'SA_REP' THEN 'D'
							 WHEN 'ST_CLERK' THEN 'E'
							 ELSE "undefined" END "Grade"
FROM employees;





















































