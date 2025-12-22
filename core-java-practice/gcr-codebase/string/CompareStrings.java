import java.util.Scanner;

public class CompareStrings {
	
	public static boolean compareCharacters(String s1, String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)!=s2.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	public static void main( String []args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter first string: ");
		String str1 = scan.next();
		System.out.print("Enter second string: ");
		String str2 = scan.next();
		boolean compare = compareCharacters(str1,str2);
		boolean compareUsingBuiltIn = str1.equals(str2);
		System.out.println("Comparison by comparing each character: "+compare);
		System.out.println("Comparison using built-in method: "+compare);
		
	}
}
