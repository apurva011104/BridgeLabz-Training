public class VegetarianMeal implements MealPlan {

    private final int calories;

    public VegetarianMeal(int calories) {
        this.calories = calories;
    }

    @Override
    public String getMealType() {
        return "Vegetarian";
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public boolean isValidMeal() {
        return calories >= 200 && calories <= 3000;
    }

    @Override
    public void displayMealPlan(){
        System.out.println("Meal type: "+getMealType()+", Calories: "+getCalories());
    }
}
