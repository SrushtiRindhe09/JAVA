import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = {10, 20, 30, 40, 50};

        try {
            System.out.print("Enter index (0-4): ");
            int index = sc.nextInt();

            System.out.println("Element: " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: Invalid index! Please enter between 0 and 4.");
        } catch (Exception e) {
            System.out.println("Invalid input!");
        }

        sc.close();
    }
}

/* Output:
Enter index (0-4): 2
Element: 30

Enter index (0-4): 5
Exception: Invalid index! Please enter between 0 and 4.

Enter index (0-4): abc
Invalid input!
*/