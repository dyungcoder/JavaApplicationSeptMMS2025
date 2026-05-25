public class Checkerboard {

    public static void main(String[] args) {

        int row = 1;

        while (row <= 8) {

            int col = 1;

            if (row % 2 == 0) {
                System.out.print(" ");
            }

            while (col <= 8) {

                System.out.print("* ");
                System.out.print(" ");

                col++;
            }

            System.out.println();
            row++;
        }
    }
}