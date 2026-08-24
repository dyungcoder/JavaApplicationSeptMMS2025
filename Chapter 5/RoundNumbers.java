import java.util.Scanner;

public class RoundNumbers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        double x = input.nextDouble();

        double y = Math.floor(x + 0.5);

        System.out.println("Original number: " + x);
        System.out.println("Rounded number: " + y);

    }
}