public class OddIntegerProduct{
	public static void main(String[] args){
		int i = 1;
		int count = 1;
		long product = 1;
		while(count <= 15){
			if(i % 2 == 1){
				product *= i;
				count++;
			}i += 1;
		}
		System.out.printf("The product of the first 15 odd numbers is %d",product);
	}
}