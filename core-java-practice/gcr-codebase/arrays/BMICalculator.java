import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter number of people: ");
        int numberOfPeople=scan.nextInt();
        
        double []weight = new double[numberOfPeople];
        double height[]=new double[numberOfPeople];

        //Taking weight and height input from user
        for(int i=0;i<numberOfPeople;i++){
            System.out.print("Enter weight of person "+(i+1)+" in kilograms: ");
            double w = scan.nextDouble();
            if(w<=0){
                System.out.println("Not a valid weight. Enter again!");
                i--;
                continue;
            }
            System.out.print("Enter height of person "+(i+1)+" in centimeters: ");
            double h = scan.nextDouble();
            if(h<=0){
                System.out.println("Not a valid height. Enter again!");
                i--;
                continue;
            }
            height[i]=h;
            weight[i]=w;
        }

        double []bmi=new double[numberOfPeople];
        String []status=new String[numberOfPeople];

        for(int i=0; i<numberOfPeople;i++){
            double heightInMeters = height[i] / 100;
            bmi[i] = weight[i] / (heightInMeters * heightInMeters);

            //Determining weight status
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

        for(int i=0;i<numberOfPeople;i++){
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
