/*Write a program that uses arrays to store employee data such as name,
employee_ID, basic pay, allowances, and deductions. The program should calculate net salary
and display a formatted salary slip for each employee. */



import java.util.Scanner;


public class LA1Employee {
    
 public static void main(String[] args)

{
    Scanner sc = new Scanner(System.in);
    System.out.println("enter the number of employee");
int n = sc.nextInt();

     int[] emp_id = new int[n];
     int[] basic_pay =  new int[n];
     int[] allowance =  new int[n];
    int[] deduction =  new int[n];


    double[] net_sal = new double[n];


   

    System.out.println("\n=========Enter details of employee=========");

    for(int i = 0; i<n; i++)

    {
       

    System.out.println("\nEmployee ID: "+ emp_id[i]);
    emp_id[i] = sc.nextInt();

    System.out.println("\nBasic pay of Employee: "+basic_pay[i]);
    basic_pay[i] = sc.nextInt();

    System.out.println("\nallowance of Employee: "+allowance[i]);
    allowance[i] = sc.nextInt();

    System.out.println("\ndeductoin of employee: "+deduction[i]);
    deduction[i] = sc.nextInt();

    net_sal[i] = basic_pay[i] + allowance[i] - deduction[i];
   
   

    }
     System.out.println("\n=========salary slip=========");

    for(int i = 0; i<n; i++)

    {
        System.out.println(emp_id[i] +" "+ "net_salary" + " " + net_sal[i]);
    }
      sc.close();
  }

}
 /*
 Output:

 enter the number of employee
2

=========Enter details of employee=========

Employee ID: 0
1

Basic pay of Employee: 0
5000

allowance of Employee: 0
2000

deductoin of employee: 0
1000

Employee ID: 0
2

Basic pay of Employee: 0
4000

allowance of Employee: 0
1000

deductoin of employee: 0
500 

=========salary slip=========
1 net_salary 6000.0
2 net_salary 4500.0
PS C:\Users\Srushti\Desktop\githubRepo\JAVA\clgAssignment>

 
 */

