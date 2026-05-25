import java.util.Scanner;

public class MileageCalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int miles;
        int gallons;

        int totalMiles = 0;
        int totalGallons = 0;

        double tripMpg;
        double totalMpg;

        System.out.print("Enter miles driven (-1 to quit): ");
        miles = input.nextInt();

        while (miles != -1) {

            System.out.print("Enter gallons used: ");
            gallons = input.nextInt();
			
            tripMpg = (double) miles / gallons;

            System.out.printf("Miles per gallon for this trip: %.2f%n", tripMpg);
			
            totalMiles += miles;
            totalGallons += gallons;
			
            totalMpg = (double) totalMiles / totalGallons;

            System.out.printf("Combined miles per gallon: %.2f%n%n", totalMpg);
			
            System.out.print("Enter miles driven (-1 to quit): ");
            miles = input.nextInt();
        }

        System.out.println("Program ended.");
    }
}