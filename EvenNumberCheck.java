import java.util.Scanner;

public class EvenNumberCheck{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		char option;
		
		do{
			System.out.print("Enter a number: ");
			int num = scan.nextInt();
			
			if(num % 2 == 0){
				System.out.println("The number is an even number");
			}
			else{
				System.out.println("The number is an odd number");
			}
			System.out.print("Do you want to run the program again?(Y/N): ");
			option = scan.next().charAt(0);
		}while(option == 'y' || option == 'y');
		System.out.print("Good Bye............................");
	}
}