public class Employee {
    public static void main()

    {


                int n = 3;

                String[] name = {"xyz", "abc", "pqr"};

                int[] emp_id = {4, 5, 6};

                int[] basic_pay = {25000, 30000, 28000};

                int[] allowance = {20000, 25000, 22000};

                int[] deduction = {2000, 3000, 4000};



                double[] net_sal = new double[n];

                for(int i = 0; i<n; i++)

                {

                    net_sal[i] = basic_pay[i] + allowance[i] - deduction[i];



                }



                System.out.println("\n=========Salary Slip=========");

                for(int i = 0; i<n; i++)

                {

                    System.out.println("\nEmployee ID: "+ emp_id[i]);

                    System.out.println("\nBasic pay of Employee: "+basic_pay[i]);

                    System.out.println("\nallowance of Employee: "+allowance[i]);

                    System.out.println("\ndeductoin of employee: "+deduction[i]);

                    System.out.println("\nnet salary of Employee: "+net_sal[i]);

                }

            }

        }



