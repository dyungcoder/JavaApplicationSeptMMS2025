public class PrimitiveDataType{
	public static void main(String[] args) {
		byte myAge = 30;
		System.out.printf("Ms Mercy is %d years old%n",myAge);
		
		short quantity = 30000;
		System.out.printf("The quantity of Iphones Ordered is %,d%n",quantity);
		
		int nigeriaPopulation = 290989289;
		System.out.printf("The population of Nigeria is %,d%n",nigeriaPopulation);
		
		long worldPopulation = 409022830220390L;
		System.out.printf("The World's population is %,d%n",worldPopulation);
		
		float price = 577858.84747f;
		System.out.printf("The price of each Iphone per unit is %,.2f%n",price);
		
		double myBalance = 747463647271121212.2321192;
		System.out.printf("My account balance is %c%,.2f%n",'$',myBalance);
		
		char symbol = '%';
		System.out.printf("There is an increment in the worlds population by 3%c%n",symbol);
		
		boolean isJavaFun = true;
		System.out.printf("Do you love Java? %b",isJavaFun);
	}
}