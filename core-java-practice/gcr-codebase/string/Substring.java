import java.util.Scanner;


public class Substring {
	
	public static String createSubstring(String str, int start, int end) {
		String substring="";
		for(int i=start ; i<end; i++) {
			substring+=str.charAt(i);
		}
		return substring;
	}
	public static void main(String []args) {
		Scanner scan=new Scanner(System.in);
		
		System.out.print("Enter string: ");
		String str = scan.nextLine();
		
		int len= str.length();
		
		System.out.printf("Enter starting index in range[0,%d): ",len);
		int start=scan.nextInt();
		while(start<0 || start>=str.length()) {
			System.out.print("Invalid start index! Enter again: ");
			start=scan.nextInt();
		}
		
		System.out.printf("Enter ending index in range[%d,%d]: ",start,len);
		int end=scan.nextInt();
		while(end<start || end>len) {
			System.out.print("Invalid end index! Enter again: ");
			end=scan.nextInt();
		}
			
		String substring = createSubstring(str,start,end);
		
		String substringUsingBuiltIn = str.substring(start,end);
		
		System.out.println("Substring using user-defined method: "+substring);
		System.out.println("Substring using built-in method: "+substringUsingBuiltIn);
	}
}
