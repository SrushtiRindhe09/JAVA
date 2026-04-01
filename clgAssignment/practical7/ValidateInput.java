import java.util.Scanner;

class InvalidInputException extends Exception
{
    public InvalidInputException(String message) {
        super(message);
    }
}

public class ValidateInput
{
    public static void checkAge(int age) throws InvalidInputException
    {
        if(age < 18 || age > 60)
            throw new InvalidInputException("age is not between 18 and 60");
        else
            {
                System.out.println("age is valid: "+ age);
            }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        try{
             System.out.println("Enter your age:");
             int age = sc.nextInt();
             checkAge(age);
        }
        catch(InvalidInputException e)
        {
            System.out.println("Exception: "+ e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("invalid input");
        }
        sc.close();
    }
}

/*output:
Enter your age:
98
Exception: age is not between 18 and 60

Enter your age:
20
age is valid: 20



*/
