import java.util.Scanner;

public class BMICalculator {

    public static double[] calculateBMI(double []weight, double []height){
        double []bmi=new double[weight.length];
        for(int i=0; i<weight.length;i++){
            double heightInMeters = height[i] / 100;
            bmi[i] = weight[i] / (heightInMeters * heightInMeters);
        }
        return bmi;
    }

    public static String[] calculateBMIStatus(double[] bmi){
        String []status=new String[bmi.length];
        for(int i=0;i<bmi.length;i++){
            if(bmi[i] < 18.5){
                status[i]="Underweight";
            }
            else if( bmi[i]>=18.5 && bmi[i]<25){
                status[i]="Normal";
            }
            else if( bmi[i]>=25 && bmi[i]<40){
                status[i]="Overweight";
            }
            else{
                status[i]="Obesity";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double []weight = new double[10];
        double height[]=new double[10];

        //Taking weight and height input from user
        for(int i=0;i<10;i++){
            System.out.print("Enter weight of person "+(i+1)+" in kilograms: ");
            weight[i]= scan.nextDouble();
            while(weight[i]<=0){
                System.out.print("Not a valid weight. Enter again: ");
                weight[i]= scan.nextDouble();
                
            }
            System.out.print("Enter height of person "+(i+1)+" in centimeters: ");
            height[i]= scan.nextDouble();
            if(height[i]<=0){
                System.out.print("Not a valid height. Enter again: ");
                height[i]= scan.nextDouble();
            }
        }

        double []bmi=calculateBMI(weight, height);
        String []status=calculateBMIStatus(bmi);

        for(int i=0;i<10;i++){
            System.out.println("Person "+(i+1)+" details:");
            System.out.println("Weight: "+weight[i]+"kgs");
            System.out.println("Height: "+height[i]+"cms");
            System.out.printf("BMI: %.3f kg per meter square\n",bmi[i]);
            System.out.println("Status"+status[i]);
            System.out.println("---------------------------------------------------------");
        }

        scan.close();
    }
}
