package practical7;

import java.util.Scanner;

// User-defined Exception
class InvalidWithdrawalException extends Exception {
    public InvalidWithdrawalException(String message) {
        super(message);
    }
}

public class ATM {
    static double balance = 5000; // initial balance

    // Method for withdrawal
    static void withdraw(double amount) throws InvalidWithdrawalException {
        if (amount < 0) {
            throw new InvalidWithdrawalException("Amount cannot be negative!");
        } else if (amount > balance) {
            throw new InvalidWithdrawalException("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful!");
            System.out.println("Remaining balance: " + balance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();

            withdraw(amount);

        } catch (InvalidWithdrawalException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input!");
        }

        sc.close();
    }
}

/* Output:
Enter withdrawal amount: 2000
Withdrawal successful!
Remaining balance: 3000.0

Enter withdrawal amount: 6000
Exception: Insufficient balance!

Enter withdrawal amount: -1000
Exception: Amount cannot be negative!

Enter withdrawal amount: abc
Invalid input!
*/