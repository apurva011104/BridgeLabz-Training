import java.util.Arrays;
import java.util.Scanner;

public class CharactersInAString {
	
	public static char[] characterArray(String str) {
		char []characters = new char[str.length()];
		
		for(int i=0;i<str.length();i++) {
			characters[i]=str.charAt(i);
		}
		
		return characters;
	}
	
	public static void main(String []args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter string: ");
		String str = scan.nextLine();
		
		char []charactersArray = characterArray(str);
		
		char []charactersArrayUsingBuiltIn = str.toCharArray();
		
		System.out.println("Characters array using user-defined method: "+Arrays.toString(charactersArray));
		System.out.println("Characters array using built-in method: "+Arrays.toString(charactersArrayUsingBuiltIn));
		
		scan.close();
		
	}
}
