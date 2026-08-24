import java.util.Scanner;

public class MultipleChecker {

    public static boolean isMultiple(int first, int second) {
        return second % first == 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char choice;

        do {
            System.out.print("Enter first integer: ");
            int first = input.nextInt();

            System.out.print("Enter second integer: ");
            int second = input.nextInt();

            if (isMultiple(first, second)) {
                System.out.println(second + " is a multiple of " + first);
            } else {
                System.out.println(second + " is not a multiple of " + first);
            }

            System.out.print("Check another pair? (y/n): ");
            choice = input.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

    }
}