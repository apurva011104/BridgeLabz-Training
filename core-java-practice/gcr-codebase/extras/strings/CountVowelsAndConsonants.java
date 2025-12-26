import java.util.Scanner;

public class CountVowelsAndConsonants {
	
	static final String VOWELS = "aeiouAEIOU";
	static final String CONSONANTS = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
	
	//Count number of vowels in text
	public static int countVowels(String text) {
		int count=0;
		for(char ch: text.toCharArray()) {
			if(VOWELS.contains(ch+"")) {
				count++;
			}
		}
		return count;
	}
	
	//Count number of consonants in text
	public static int countConsonants(String text) {
		int count = 0;
		for(char ch: text.toCharArray()) {
			if(CONSONANTS.contains(ch+"")) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String []args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter text: ");
		String text = scan.nextLine();
		System.out.println("Number of vowels: "+countVowels(text));
		System.out.println("Number of consonants: "+countConsonants(text));
	}
}
