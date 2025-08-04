// Interface for meal plans
interface MealPlan {
    String getMealDetails();
}

// Subtypes of MealPlan
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Vegetarian Meal: Grilled paneer with quinoa and mixed vegetables.";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Vegan Meal: Tofu stir-fry with brown rice and steamed broccoli.";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "Keto Meal: Baked salmon with avocado salad and olive oil.";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealDetails() {
        return "High-Protein Meal: Chicken breast with lentils and eggs.";
    }
}

// Generic Meal class with bounded type parameter
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void showMeal() {
        System.out.println(mealPlan.getMealDetails());
    }

    public T getMealPlan() {
        return mealPlan;
    }
}

// Utility class with a generic method to generate a meal plan
class MealPlanGenerator {

    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        System.out.println("Generating your personalized meal plan...");
        return new Meal<>(mealPlan);
    }
}

// Test class
public class PersonalizedMealPlanApp {

    public static void main(String[] args) {

        // Generate a Vegetarian meal plan
        Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generateMealPlan(new VegetarianMeal());
        vegMeal.showMeal();

        // Generate a Vegan meal plan
        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(new VeganMeal());
        veganMeal.showMeal();

        // Generate a Keto meal plan
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(new KetoMeal());
        ketoMeal.showMeal();

        // Generate a High-Protein meal plan
        Meal<HighProteinMeal> highProteinMeal = MealPlanGenerator.generateMealPlan(new HighProteinMeal());
        highProteinMeal.showMeal();
    }
}
