/*
Display each job along with minimum sal being paid in each job group.

Sample Output:
--------------
job     min(sal)                                                                                                        
ANALYST 3000.00

*/
select job,min(sal) from emp group by job

/*
Display the names of employees who earn highest salaries 
in their respective job groups.

Sample Output:
--------------
ename                                                                                                                   
ALLEN   

*/
-- select ename from emp where sal in(select max(sal) from emp group by job)
select e.ename from emp e where sal =(select max(sal) from emp where e.job=job)


/*
Display the job groups having total salary greater then the maximum salary for
managers.

Sample Output:
--------------
job     sum(sal)                                                                                                        
ANALYST 6000.00

*/
select job,sum(sal) from emp group by job having sum(sal)>(select max(sal) from emp where job='MANAGER')


/*
Display the names of employees from department number 40 with salary
greater than that of every employee working in other departments.


Sample Output:
--------------
ename   sal     deptno                                                                                                  
KEVIN   5000.00 40                                                                                                      


*/
select ename,sal,deptno from emp where deptno=40 and sal>(select max(sal) from emp where deptno!=40)
