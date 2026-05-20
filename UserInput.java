import java.util.Scanner;

public class UserInput{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String name = input.nextLine();
		
		System.out.print("Enter your gender: ");
		String gender = input.next();
		
		System.out.print("Enter your age: ");
		byte age = input.nextByte();
		
		System.out.print("Enter the amount of students in your class: ");
		short classStudents = input.nextShort();
		
		System.out.print("Do you love learning Java(True/False): ");
		boolean loveJava = input.nextboolean();
		
		System.out.println("");
		System.out.printf("Information about %s%n",name);
		System.out.println("===================================================");
		
		System.out.printf("Hello %s. You are welcome to NIIT %n",name);
		System.out.printf("You are a %s and you are %d years old %n",gender,age);
		System.out.printf("There are %d students in your class %n",classStudents);
	}
}