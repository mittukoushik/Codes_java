/*
Display the monthly total salary drawn by the analyst/s working 
in dept no 20.

Sample Output:
--------------
total_salary                                                                                                    
6000.00    

*/
select sum(sal) as total_salary from emp where deptno=20 and job="analyst"

/*
Display name, Sal, hra, pf, da, total Sal for each employee. The output should be
in the order of total Sal, hra 15% of Sal, da 10% of sal, pf 5% of sal 
total salary will be (sal+hra+da)-pf.

Sample Output:
--------------
ename   sal     HRA         PF          DA          TOTAL_SALARY                                                                    
SMITH   800.00  120.000000  40.000000   80.000000   960.000000                                              
 

*/

select ename,sal,
sal*0.1500 as HRA,
sal*0.0500 as PF,
sal*0.1000 as DA,
sal+sal*0.1500+sal*0.1000-sal*0.0500 as TOTAL_SALARY from emp

/*
Display the employee number and name of employee working as CLERK and 
earning highest salary among CLERKS.

Sample Output:
--------------
empno   ename                                                                                                           
7934    FORD 

*/
select empno,ename from emp where sal=(select max(sal) from emp where job="CLERK")

/*
Display the names of the salesman who earns a salary more than 
the highest salary of any clerk.

Sample Output:
--------------
ename                                                                                                                   
ALLEN                                                                                                                   

*/
select ename from emp where sal>(select max(sal) from emp where job="CLERK") and job="SALESMAN"

/*
Display the names of the employees who earn highest salary in 
their respective departments.

Sample Output:
--------------
empno   ename   job     mgr     hiredate        sal     comm    deptno                                                  
7698    BLAKE   MANAGER 7839    1992-06-11      2850.00 NULL    30        

*/

select * from emp e where e.sal=(
select max(sal) from emp where e.deptno=deptno);
