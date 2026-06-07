public class CompoundInterest {
    public static void main(String[] args) {

        double principal = 1000.0; // starting amount

        System.out.printf("%-10s %-15s%n", "Rate", "Amount after 10 years");

        for (int rate = 5; rate <= 10; rate++) {

            double amount = principal;

            double r = rate / 100.0; 

            for (int year = 1; year <= 10; year++) {
                amount = amount * (1 + r);
            } 

            System.out.printf("%-10d %-15.2f%n", rate, amount);
        }
    }
}