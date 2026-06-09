import java.util.Random;

public class AccountNumberGenerator {
    public static void main(String[] args) {

        Random random = new Random();

        long accountNumber = 3000000000L + random.nextInt(100000000);

        System.out.println("Account Number: " + accountNumber);
    }
}