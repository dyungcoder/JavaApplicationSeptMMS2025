import java.util.Scanner;

public class JavaClasswork1{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the First number: ");
		int num1 = input.nextInt();
		
		System.out.print("Enter the Second number: ");
		int num2 = input.nextInt();
		
		System.out.print("Enter the Third number: ");
		int num3 = input.nextInt();
		
		System.out.print("Enter the Fourth number: ");
		int num4 = input.nextInt();
		
		System.out.print("Enter the Fifth number: ");
		int num5 = input.nextInt();
		
		double sum = (double)num1 + (double)num2 + (double)num3 + (double)num4 + (double)num5;
		double average = sum/5;
		double product = (double)num1 * (double)num2 * (double)num3 * (double)num4 * (double)num5;
		
		System.out.printf("The sum of the numbers is %.2f%n",sum);
		System.out.printf("The product of the numbers is %.2f%n",product);
		System.out.printf("The average of the numbers is %.2f%n",average);
	}
}