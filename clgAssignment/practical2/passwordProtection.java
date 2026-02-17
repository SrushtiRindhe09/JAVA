/*
 Protect user privacy in a banking application, passwords should never be fully visible. 
 Create a program that masks a user's password by replacing all characters with asterisks (*) 
 except the last two. 
 Example: Input: mySecret123 → Output: *******23
*/


import java.util.Scanner;

public class passwordProtection

{
    public static void main(String args[])
    {
      Scanner sc = new Scanner (System.in);
      System.out.println("Enter your Password: ");
      String password = sc.nextLine();


      if(password.length() <= 2)
      {
        System.out.println("Masked password: "+ password);
      }
      else
      {
        String lastTwo = password.substring(password.length()-2);
        String maskedPart = "";

        for(int i =0 ; i<password.length()-2; i++)
        {
            maskedPart = maskedPart + "*";
        }

        String finalPassword = maskedPart + lastTwo;
        System.out.println("Masked password: "+ finalPassword);
      }


      sc.close();
    }
    
}
 /*
 Output :
Enter your Password: 
Srushti363
Masked password: ********63

 */