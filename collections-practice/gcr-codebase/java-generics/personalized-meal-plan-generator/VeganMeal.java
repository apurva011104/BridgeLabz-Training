public class VeganMeal implements MealPlan {

    private final int calories;

    public VeganMeal(int calories) {
        this.calories = calories;
    }

    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public boolean isValidMeal() {
        return calories >= 200 && calories <= 2500;
    }

    @Override
    public void displayMealPlan(){
        System.out.println("Meal type: "+getMealType()+", Calories: "+getCalories());
    }
}
