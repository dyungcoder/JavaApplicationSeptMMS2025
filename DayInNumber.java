import java.util.Scanner;

public class DayInNumber{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the day in number: ");
		int num = input.nextInt();
		
		if(num == 1){
			System.out.print("The day of the week is Sunday");
		}
		else if(num == 2){
			System.out.print("The day of the week is Monday");
		}
		else if(num == 3){
			System.out.print("The day of the week is Tuesday");
		}
		else if(num == 4){
			System.out.print("The day of the week is Wednesday");
		}
		else if(num == 5){
			System.out.print("The day of the week is Thursday");
		}
		else if(num == 6){
			System.out.print("The day of the week is Friday");
		}
		else{
			System.out.print("The day of the week is Saturday");
		}
	}
}