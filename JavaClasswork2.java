import java.util.Scanner;

public class JavaClasswork2{
	public static void main(String[] args){
	    Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int num = input.nextInt();
		
		System.out.print(num % 2 == 0);
	}
}