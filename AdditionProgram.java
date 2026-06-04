import java.util.Scanner;

public class AdditionProgram{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int sum = 0;
		
		for(int i = 1; i <= 3; i++){
			System.out.print("Enter number " + i+ ": ");
			sum += input.nextInt();
		}
		System.out.println("Sum = " + sum);
		int product = 1;
		
		if(sum % 2 == 0 && sum % 10 == 0){
			for(int a = 1; a <= 3; a++){
			System.out.print("Enter number " + a+ ": ");
			product *= input.nextInt();
		}
		System.out.println("Product = " + product);
		if(product >= 200){
			System.out.print("Hurray I did it");
		}
		else{
			System.out.print("I still have work to do");
		}
		}
	}
}