import java.util.Scanner;

public class CreditLimitCalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int accountNumber;
        int beginningBalance;
        int charges;
        int credits;
        int creditLimit;
        int newBalance;

        System.out.print("Enter account number (-1 to quit): ");
        accountNumber = input.nextInt();

        while (accountNumber != -1) {

            System.out.print("Enter beginning balance: ");
            beginningBalance = input.nextInt();

            System.out.print("Enter total charges: ");
            charges = input.nextInt();

            System.out.print("Enter total credits: ");
            credits = input.nextInt();

            System.out.print("Enter credit limit: ");
            creditLimit = input.nextInt();

            newBalance = beginningBalance + charges - credits;

            System.out.println("\nAccount Number: " + accountNumber);
            System.out.println("New Balance: " + newBalance);

            if (newBalance > creditLimit) {
                System.out.println("Credit limit exceeded");
            }

            System.out.println();

            System.out.print("Enter account number (-1 to quit): ");
            accountNumber = input.nextInt();
        }

        System.out.println("Program ended.");

    }
}