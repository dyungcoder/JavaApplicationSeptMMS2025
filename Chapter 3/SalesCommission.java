import java.util.Scanner;

public class SalesCommission {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int item;
        double totalSales = 0.0;
        double earnings;

        System.out.println("Items:");
        System.out.println("1 - $239.99");
        System.out.println("2 - $129.75");
        System.out.println("3 - $99.95");
        System.out.println("4 - $350.89");

        System.out.print("Enter item number sold (-1 to end): ");
        item = input.nextInt();

        while (item != -1) {

            switch (item) {

                case 1:
                    totalSales += 239.99;
                    break;

                case 2:
                    totalSales += 129.75;
                    break;

                case 3:
                    totalSales += 99.95;
                    break;

                case 4:
                    totalSales += 350.89;
                    break;

                default:
                    System.out.println("Invalid item number.");
            }

            System.out.print("Enter item number sold (-1 to end): ");
            item = input.nextInt();
        }

        earnings = 200 + (0.09 * totalSales);

        System.out.printf("%nGross Sales: $%.2f%n", totalSales);
        System.out.printf("Weekly Earnings: $%.2f%n", earnings);

    }
}