/*A university portal maintains student names for the purposes of identification, verification, 
and formatting. Write a program accepting student's full name and performs the following operations:
 Search for a middle name as substring Replace a word or character Convert the name to Title Case */

import java.util.Scanner;

public class LA1String 
{

    public static void main(String[] args)
    { 
     // accept fullname from user
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter your full name:");
      String fullName = sc.nextLine();

      // accept middle name from user
      System.out.println("Enter middle name to search:");
      String middlename  = sc.nextLine();

      

      // Search for middle name as substring
      if (fullName.contains(middlename)) {
          System.out.println("Middle name found in: " + fullName);
      } else {
          System.out.println("Middle name not found");
      }

      
    
      //3. Replace a word or character
      System.out.println("Enter a word to replace: ");
      String oldWord = sc.nextLine();

      System.out.println("Enter the new word: ");
      String newWord = sc.nextLine();

      String replaceName = fullName.replace(oldWord, newWord);
      System.out.println("Fullname after Replacemnt: "+ replaceName);

       String titleCaseName = toTitleCase(fullName);
        System.out.println("Title Case Name: " + titleCaseName);

        sc.close();
    }


       public static String toTitleCase(String name)
    {
        String[] words = name.toLowerCase().split(" ");
        String result = "";

        for (String word : words) {
            result += Character.toUpperCase(word.charAt(0)) 
                      + word.substring(1) + " ";
        }

        return result.trim();
    }
}  

/*Output:

Enter your full name:
srushti abasaheb rindhe
Enter middle name to search:
abasaheb
Middle name found in: srushti abasaheb rindhe
Enter a word to replace:
srushti
srushti
Enter the new word:
sruu
Fullname after Replacemntsruu abasaheb rindhe
Title Case Name: Srushti Abasaheb Rindhe
*/