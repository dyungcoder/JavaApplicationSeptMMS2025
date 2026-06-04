public class MethodInJava{
	public static void main(String[] args){
		MethodInJava javaMethod = new MethodInJava();
		int sum = javaMethod.add(70,60,45);
		
		System.out.printf("The sum of all the numbers is %d%n",sum);
		
		javaMethod.details(21, "Bryan");
	}
	public int add(int num1, int num2, int num3){
		
		int sum = num1 + num2 + num3;
		return sum;
	}
	public void details(int age, String name){
		System.out.printf("Your name is %s%n",name);
		System.out.printf("You are %d years old %n",age);
	}
}