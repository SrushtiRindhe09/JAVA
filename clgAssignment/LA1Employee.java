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


