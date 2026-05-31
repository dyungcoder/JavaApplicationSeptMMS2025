import java.util.Scanner;

public class CalculationAssignment{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter 1st number: ");
        int n1 = input.nextInt();

        System.out.print("Enter 2nd number: ");
        int n2 = input.nextInt();

        System.out.print("Enter 3rd number: ");
        int n3 = input.nextInt();

        System.out.print("Enter 4th number: ");
        int n4 = input.nextInt();

        System.out.print("Enter 5th number: ");
        int n5 = input.nextInt();

        System.out.print("Enter 6th number: ");
        int n6 = input.nextInt();

        System.out.print("Enter 7th number: ");
        int n7 = input.nextInt();

        System.out.print("Enter 8th number: ");
        int n8 = input.nextInt();

        System.out.print("Enter 9th number: ");
        int n9 = input.nextInt();

        System.out.print("Enter 10th number: ");
        int n10 = input.nextInt();

        int firstSum = n1 + n5 + n10;
        int secondSum = n3 + n8 + n2;

        int product = firstSum * secondSum;

        int thirdSum = n4 + n7 + n6 + n9;

        int result = thirdSum - product;

        if (result >= 100) {
            System.out.println("hurray I did it");
        } else {
            System.out.println("I still need to learn more in Java");
        }
    }
}