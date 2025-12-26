public class CalculateBonus {

    public static double generateSalary(){
        double salary=0;
        while(salary<10000){
            salary=0;
            for(int i=1;i<=5;i++){
                salary=(salary*10)+(Math.random()*9);
            }
        }
        return salary;
    }

    public static int generateYearsOfExperience(){
        return (int)(Math.random()*10);
    }

    public static double[][] calculateBonusAndNewSalary(double [][]employeeInformation){
        double [][]bonusAndNewSalary = new double[employeeInformation.length][2];

        for(int i=0;i<10;i++){
            double bonusPercentage;
            if(employeeInformation[i][1]>=5){
                bonusPercentage = 0.05;
            }
            else{
                bonusPercentage = 0.02;
            }
            bonusAndNewSalary[i][0] = bonusPercentage * employeeInformation[i][0];
            bonusAndNewSalary[i][1] = employeeInformation[i][0] + bonusAndNewSalary[i][0];
        }

        return bonusAndNewSalary;
    }

    public static void displayInformation(double [][]employeeInformation , double[][] bonusAndNewSalary){
        System.out.println("Person  |  Years of Experience   |  Old Salary  |  Bonus  |  New Salary");
        for(int i=0;i<10;i++){
            System.out.printf("%d  |  %d  |  %.2f  |  %.2f  |  %.2f",(i+1),(int)employeeInformation[i][1],employeeInformation[i][0],bonusAndNewSalary[i][0],bonusAndNewSalary[i][1]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double [][]employeeInformation = new double[10][2];

        for(int i=0;i<10;i++){
            employeeInformation[i][0]=generateSalary();
            employeeInformation[i][1]=generateYearsOfExperience();
        }

        double [][]bonusAndNewSalary = calculateBonusAndNewSalary(employeeInformation);
        
        displayInformation(employeeInformation, bonusAndNewSalary);
    }
}
