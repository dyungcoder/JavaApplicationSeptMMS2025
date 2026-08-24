import java.util.Scanner;

public class HypotenuseCalculator {

    public static double hypotenuse(double side1, double side2) {
        return Math.sqrt(side1 * side1 + side2 * side2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter side 1: ");
        double side1 = input.nextDouble();

        System.out.print("Enter side 2: ");
        double side2 = input.nextDouble();

        double hyp = hypotenuse(side1, side2);

        System.out.println("Hypotenuse = " + hyp);

    }
}