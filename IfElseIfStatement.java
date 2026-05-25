import java.util.Scanner;

public class IfElseIfStatement{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		//String name;
		//int score;
		//String subject;
		
		System.out.print("Enter your name here: ");
		String name = input.nextLine();
		
		System.out.print("Enter your subject here: ");
		String subject = input.nextLine();
		
		System.out.print("Enter your score here: ");
		int score = input.nextInt();
		
		if(score >= 70){
			System.out.printf("Name: %s%n",name);
			System.out.printf("Subject: %s%n",subject);
			System.out.printf("Score: %d%n",score);
			System.out.println("Grade: A");
		}
		else if(score >= 60){
			System.out.printf("Name: %s%n",name);
			System.out.printf("Subject: %s%n",subject);
			System.out.printf("Score: %d%n",score);
			System.out.println("Grade: B");
		}
		else if(score >= 50){
			System.out.printf("Name: %s%n",name);
			System.out.printf("Subject: %s%n",subject);
			System.out.printf("Score: %d%n",score);
			System.out.println("Grade: C");
		}
		else if(score >= 40){
			System.out.printf("Name: %s%n",name);
			System.out.printf("Subject: %s%n",subject);
			System.out.printf("Score: %d%n",score);
			System.out.println("Grade: D");
		}
		else{
			System.out.printf("Name: %s%n",name);
			System.out.printf("Subject: %s%n",subject);
			System.out.printf("Score: %d%n",score);
			System.out.println("Grade: F");
		}
	}
	
}