import java.util.Scanner;

public class ParkingCharges {

    public static double calculateCharges(double hours) {
        double charge = 2.0;

        if (hours > 3) {
            charge += Math.ceil(hours - 3) * 0.5;
        }

        if (charge > 10.0) {
            charge = 10.0;
        }

        return charge;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double totalReceipts = 0.0;

        System.out.print("Enter number of customers: ");
        int customers = input.nextInt();

        for (int i = 1; i <= customers; i++) {
            System.out.print("Enter hours parked for customer " + i + ": ");
            double hours = input.nextDouble();

            double charge = calculateCharges(hours);
            totalReceipts += charge;

            System.out.printf("Customer %d Charge: $%.2f%n", i, charge);
            System.out.printf("Running Total: $%.2f%n%n", totalReceipts);
        }

        System.out.printf("Yesterday's Total Receipts: $%.2f%n", totalReceipts);

    }
}