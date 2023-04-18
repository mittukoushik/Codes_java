/*
Write a query to display ename, dname, location of employee 
( join ‘emp’ and ‘dept’ tables) where employee name starts with  'A'.

Sample Output:
-------------
ename   dname       location                                                                                                
ALLEN   Accounting  New York                                                                                        

*/
select emp.ename,dept.dname,dept.location from emp inner join dept on emp.deptno=dept.deptno where ename like"A%" 

/*
Write an sql query to display the empno, ename, sal, dname from emp,dept,
the employees is either 'MANAGER' or 'ANALYST' working in ‘New York’ or ‘Dallas’
and display in descending order of name.

Sample Output:
--------------
empno   ename   sal     dname                                                                                           
7788    SCOTT   3000.00 Research 

*/
select emp.empno,emp.ename,emp.sal,dept.dname from emp inner join dept on emp.deptno=dept.deptno where (emp.job='MANAGER' or emp.job="ANALYST") and (dept.location="New York" or dept.location="Dallas") order by ename desc;

/*
Display the department number, minimum salary, maximum salary of each department 	

Sample Output:
--------------
deptno  min_salary      max_salary                                                                                      
10      1300.00         2450.00  

*/
select deptno,min(sal) as min_salary,max(sal) as max_salary from emp group by deptno

/*
Display the department numbers and count of employees in it,
with more than three employees in each dept.    

Sample Output:
-------------
deptno  count                                                                                                           
20      6                                                                                                               

*/

select deptno,count(deptno) as count from emp group by deptno having count(ename)>3;

/*
Display the name of the employee/s earking second highest salary of EMP table

Sample Output:
    ename                                                                                                                   
    SCOTT                                                                                                                   

*/
select ename from emp where sal=(select max(sal) from emp where sal not in (select max(sal) from emp))
