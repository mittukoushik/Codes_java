/*
List all the details of employees who joined before 1996.

Sample Output:
empno   ename   job     mgr     hiredate        sal     comm    deptno                                                  
7369    SMITH   CLERK   7902    1993-06-13      800.00  0.00    20                                                      

*/
select * from emp where year(hiredate)<1996

/*

List the employee names starting with ‘S’ and ending with ‘H’ and having a length of 5 chars.

Sample Output:
ename                                                                                                                   
SMITH 

*/
select ename from emp where ename like"S%H"

/*

List the emp names those are having four chars and third character must be ‘r’.

Sample Output:
ename                                                                                                                   
FORD                                                                                                                    

*/

select ename from emp where ename like "__R_"

/*
Write a query to display names of employee and their annual salary as 
‘annual_salary’ from ‘emp’ table where the annual salary is greater than 30000

Sample Output:
ename   annual_salary                                                                                                   
JONES   35700.00                                                                                                        

*/
select ename,12*sal as annual_salary from emp where 12*sal>30000

/*
Write a query to find CTC of company.
NOTE: CTC is annual salary(sal) of all employees including commission (comm).

Sample Output:
CTC                                                                                                                     
163200.00 

*/
select sum(12*sal)+sum(12*comm) as CTC from emp
