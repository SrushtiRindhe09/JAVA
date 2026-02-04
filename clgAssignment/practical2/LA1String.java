package practical2;

/*A university portal maintains student names for the purposes of identification, verification, 
and formatting. Write a program accepting student's full name and performs the following operations:
 Search for a middle name as substring Replace a word or character Convert the name to Title Case */

import java.util.Scanner;

public class LA1String {


    public static void main(String[] args)
    { 
     // accept fullname from user
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter your full name:");
      String fullName = sc.nextLine();

      // accept middle name from user
      System.out.println("Enter middle name to search:");
      String middlename  = sc.nextLine();

      sc.close();

      // Search for middle name as substring
      if (fullName.contains(middlename)) {
          System.out.println("Middle name found in: " + fullName);
      } else {
          System.out.println("Middle name not found");
      }

      }


    
}
