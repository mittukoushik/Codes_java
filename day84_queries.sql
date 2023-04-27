/*
Write a query to find CTC to Company.

Note: CTC is annual salary of all employees.
Annual Salary is 12*sum(sal+comm); check if comm is null set to 0.

Note:Table name: "emp"

Sample Output:
------------
CTC                                                                                                                     
374700.00 

*/
select 12*sum(sal)+12*sum(comm) as CTC from emp



/*
Write an SQL query to list out(ename,mgr,and sal) the lowest paid employees 
working for each manager,exclude any employee whose salary is less than 1000 
sort the output by salary.

Sample Output:
-------------
ename   mgr     sal                                                                                                     
FORD    7782    1300.00                                                                                                 
SCOTT   7566    3000.00                                                                                                 

*/
select ename,mgr,sal from emp e where sal=(select min(sal) from emp where e.mgr=mgr ) and sal>1000 order by sal asc;



/*
Write an SQL query to display all the details of managers who are not working 
under the president.

Sample Output:
-------------
empno   ename   job     mgr     hiredate        sal     comm    deptno                                                  
7902    FORD    ANALYST 7566    1997-12-05      3000.00 NULL    20 

*/

select * from emp where mgr!=(select empno from emp where job="PRESIDENT" ) and empno in (select mgr from emp)



/*
Write an SQL query to display employee number,employee name and salary of the 
employee(s) whose salary is less than his manager salary but more than any 
other manager.

Sample Output:
-------------
empno   ename   sal                                                                                                     
7698    BLAKE   2850.00 

*/
select empno,ename,sal from emp e where sal<(select sal from emp where empno=e.mgr) 
and
sal>any(select sal from emp where empno!=e.mgr and empno in (select mgr from emp))


/*
Write an SQL query to display the name, job, salary of the employees in the 
department with the highest average salary among all the departments.

Sample Output:
-------------
ename   job     sal                                                                                                     
MARTIN  SALESMAN        1250.00  

*/
select ename,job,sal from emp where deptno=(select deptno from emp group by deptno order by AVG(SAL) DESC limit 1)


