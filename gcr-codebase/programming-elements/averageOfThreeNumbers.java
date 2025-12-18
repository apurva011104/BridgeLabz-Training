public class averageOfThreeNumbers {
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = scan.nextDouble();                     //Takes first number input
        System.out.print("Enter second number: ");
        double num2 = scan.nextDouble();                     //Takes second number input
        System.out.print("Enter third number: ");
        double num3 = scan.nextDouble();                     //Takes third number input
        double average = (num1 + num2 + num3) / 3;          //Calculates average of three numbers
        System.out.println("Average of three numbers: " + average);
    }
}