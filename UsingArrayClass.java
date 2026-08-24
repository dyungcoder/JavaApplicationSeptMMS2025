import java.util.Arrays;

public class UsingArrayClass{
	public static void main(String[] args){
		int[] numbers = {5,8,2,3,9,4,1,6,7,10};
		int[] a = {7,9,6};
		int[] b = {7,9,6};
		
		int[] c = {7,9,9};
		int[] d = {7,8,6};
		int[] myFillArray = new;
		int[][] numbers ={
			{7,8,9,6,4},
			{3,5,4,2,1},
			{5,6,3,8,7}
		};
		
		Arrays.sort(numbers);
		System.out.println("The elements of the array are");
		
		for(int number : numbers){
			System.out.printf("%d%n",number);
		}
		System.out.println("Binary Search");
		int index = Arrays.binarySearch(numbers, 9);
		System.out.printf("The index number of the element is %d%n",index);
		
		boolean isEqual = Arrays.equals(a,b);
		System.out.printf("The result is %b%n",isEqual);
		
		boolean compareArrays = Arrays.equals(a,b);
		System.out.printf("The result is %b%n",compareArrays);
		
		int[] evenNumbers = {2,4,6,8,10,12,14,16,18,20};
		int[] copyArr = Arrays.copyOf(evenNumbers,5);
		
		System.out.println("The elements of the array are");
		for(int arr : copyArr){
			System.out.printf("%d%n",arr);
		}
		
		
		System.out.println(Arrays.toString(evenNumbers));
	}
	System.out.println(Arrays.deepToString(numbers));
}