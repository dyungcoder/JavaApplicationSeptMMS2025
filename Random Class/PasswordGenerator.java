import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {

        Random random = new Random();

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%&*";

        String password = "";

        for (int i = 1; i <= 15; i++) {
            password += chars.charAt(random.nextInt(chars.length()));
        }

        System.out.println("Password: " + password);
    }
}