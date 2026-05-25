import java.util.Scanner;

public class LargestNumber {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int counter = 1;
        int number;
        int largest;

        System.out.print("Enter integer 1: ");
        number = input.nextInt();

        largest = number;

        while (counter < 10) {

            System.out.print("Enter integer " + (counter + 1) + ": ");
            number = input.nextInt();

            if (number > largest) {
                largest = number;
            }

            counter++;
        }

        System.out.println("Largest integer is: " + largest);

        input.close();
    }
}