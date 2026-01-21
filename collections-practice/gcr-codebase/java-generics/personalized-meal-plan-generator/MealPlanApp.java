public class MealPlanApp {
    public static void main(String[] args) {

        MealPlanManager mealPlanManager = new MealPlanManager();
        MealPlan mealPlan = new VegetarianMeal(1800);
        VegetarianMeal vegetarianMeal = new VegetarianMeal(1500);
        VeganMeal veganMeal = new VeganMeal(1240);

        try {
            Meal<MealPlan> meal1 = mealPlanManager.addMealPlan(mealPlan);
            Meal<VegetarianMeal> meal2 = mealPlanManager.addMealPlan(vegetarianMeal);
            Meal<VeganMeal> meal3 = mealPlanManager.addMealPlan(veganMeal);

            meal1.displayMealPlan();
            meal2.displayMealPlan();
            meal3.displayMealPlan();
        } 
        catch (InvalidMealPlanException e) {
            System.out.println(e);
        }
    }
}
