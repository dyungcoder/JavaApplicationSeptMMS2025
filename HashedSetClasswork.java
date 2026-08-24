import java.util.Set;
import java.util.LinkedHashSet;

public class HashedSetClasswork{
	public static void main(String[] args){
		Set<String> studentEmail = new LinkedHashSet<>();
		
		studentEmail.add("btom1111@gmail.com");
		studentEmail.add("johnnyboy@gmail.com");
		studentEmail.add("umaruamed@gmail.com");
		studentEmail.add("benth131@gmail.com");
		studentEmail.add("nouser@gmail.com");
		studentEmail.add("false909@gmail.com");
		studentEmail.add("bnot1@gmail.com");
		studentEmail.add("jamesdane@gmail.com");
		studentEmail.add("kelvin43@gmail.com");
		studentEmail.add("dannyjames51@gmail.com");
		
		for(String email : studentEmail){
			System.out.printf("%s%n",email);
		}
	}
}