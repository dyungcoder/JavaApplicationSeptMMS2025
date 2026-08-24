public class EvenNumberFiltering{
	public static void main(String[] args){
		int[] arr = {7,8,4,3,2,9,0,1,6,8};
		
		for(int i = 0; i < 10; i++){
			if(arr[i] % 2 == 0){
				System.out.println(arr[i]);
			}
		}
		System.out.print("These are the even numbers in the array");
	}
}