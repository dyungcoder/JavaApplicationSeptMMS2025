import java.util.Scanner;

public class JavaClasswork3{
	public static void main(Static[] args){
	    Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your Name: ");
		String name = input.nextLine();
		
		System.out.print("Enter your Age: ");
		int num = input.nextInt();
		
		System.out.print("Enter your Address: ");
		String address = input.nextLine();
		
		System.out.print("Name: %s%n",name);
		System.out.print("Age: %d%n",age);
		System.out.print("Address: %s%n",address);
	}
}