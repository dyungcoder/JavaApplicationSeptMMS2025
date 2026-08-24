import java.util.Scanner;

public class RoundingNumbers {

    public static double roundToInteger(double number) {
        return Math.floor(number + 0.5);
    }

    public static double roundToTenths(double number) {
        return Math.floor(number * 10 + 0.5) / 10;
    }

    public static double roundToHundredths(double number) {
        return Math.floor(number * 100 + 0.5) / 100;
    }

    public static double roundToThousandths(double number) {
        return Math.floor(number * 1000 + 0.5) / 1000;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        double number = input.nextDouble();

        System.out.println("Original Number: " + number);
        System.out.println("Rounded to Integer: " + roundToInteger(number));
        System.out.println("Rounded to Tenths: " + roundToTenths(number));
        System.out.println("Rounded to Hundredths: " + roundToHundredths(number));
        System.out.println("Rounded to Thousandths: " + roundToThousandths(number));

    }
}