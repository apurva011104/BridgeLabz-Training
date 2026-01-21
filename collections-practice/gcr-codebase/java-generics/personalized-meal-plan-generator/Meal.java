public class Meal<T extends MealPlan> {

    private final T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public void displayMealPlan(){
        mealPlan.displayMealPlan();
    }

}
