import java.util.Scanner;

public class GrossPayCalculator {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int employee = 1;

        while (employee <= 3) {

            double hoursWorked;
            double hourlyRate;
            double grossPay;

            System.out.println("Employee " + employee);

            System.out.print("Enter hours worked: ");
            hoursWorked = input.nextDouble();

            System.out.print("Enter hourly rate: ");
            hourlyRate = input.nextDouble();

            // Calculate gross pay
            if (hoursWorked <= 40) {
                grossPay = hoursWorked * hourlyRate;
            } else {
                grossPay = (40 * hourlyRate) +
                           ((hoursWorked - 40) * hourlyRate * 1.5);
            }

            System.out.printf("Gross Pay: $%.2f%n%n", grossPay);

            employee++;
        }

        input.close();
    }
}