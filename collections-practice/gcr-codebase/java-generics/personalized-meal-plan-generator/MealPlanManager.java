public class MealPlanManager {
    public <T extends MealPlan> Meal<T> addMealPlan(T mealPlan) throws InvalidMealPlanException {

        if (!mealPlan.isValidMeal()) {
           throw new InvalidMealPlanException("Invalid meal plan for "+mealPlan.getMealType());
        }
        return new Meal<>(mealPlan);
    }

    public static <T extends MealPlan> void displayMealPlan(T mealPlan){

    }
}
