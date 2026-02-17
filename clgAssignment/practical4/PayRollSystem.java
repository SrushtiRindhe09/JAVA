/*
A company wants to automate its payroll system. Write a program with a
superclass Employee having a method calculateSalary(). 
Create subclasses: FullTimeEmployee – fixed monthly salary PartTimeEmployee –
paid hourly Intern – receives a fixed stipend Override 
calculateSalary() in each subclass and use polymorphism to compute and display salaries
for a list of employees of different types.
*/


public class PayRollSystem {
    public static void main(String args[])
    {
      Employee[] emp = new Employee[3];
      emp[0] = new FullTimeEmployee(100000);
      emp[1] = new PartTimeEmployee(1000, 10);
      emp[2] = new Intern(10000);

       for(Employee e : emp)
       {
         e.salary();
       };

    }
    
}

class Employee
{
  void salary()
  {
    System.out.println("Employee Salary");

  }
}

class FullTimeEmployee extends Employee
{
    double fullSalary;
    FullTimeEmployee(double f)
    {
        fullSalary = f;
    }
    void salary()
    {
        System.out.println("Full Time Employee Salary: " + fullSalary);
    }

}

class PartTimeEmployee extends Employee
{
   double  payhour;
   int hour;
    PartTimeEmployee(double h, int hr)
    {
         payhour = h;
         hour = hr;
    }
    void salary()
    {
        System.out.println("Part Time Employee Salary: " + (payhour * hour));
    }
}

class Intern extends Employee
{
   double stipend;
    Intern(double s)
    {
        stipend = s;
    }
    void salary()
    {
        System.out.println("Intern Salary: " + stipend);
    }
}


/*
Output:
Full Time Employee Salary: 100000.0
Part Time Employee Salary: 10000.0
Intern Salary: 10000.0

*/