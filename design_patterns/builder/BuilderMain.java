package builder;

public class BuilderMain {
	public static void main(String[] args) {
		MealBuilder mealBuilder = new MealBuilder();

		OrderMeal vegMeal = mealBuilder.prepareVegMeal();
	    System.out.println("Vegi Meal");
	    vegMeal.showItems();
	    System.out.println("Total Cost: " + vegMeal.getCost());

	    OrderMeal nonVegMeal = mealBuilder.prepareNonVegMeal();
	    System.out.println("\n\nNon-Vegi Meal");
	    nonVegMeal.showItems();
	    System.out.println("Total Cost: " + nonVegMeal.getCost());
	}
}
