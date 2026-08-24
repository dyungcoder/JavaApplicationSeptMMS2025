import java.util.List;
import java.util.ArrayList;

public class UsingList2{
	public static void main(String[] args){
		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(90);
		numbers.add(42);
		numbers.add(12);
		numbers.add(24);
		numbers.add(55);
		numbers.add(26);
		numbers.add(90);
		numbers.add(19);
		numbers.add(84);
		numbers.add(78);
		
		System.out.print(numbers);
		System.out.printf("The size: %d%n",numbers.size());
	}
}