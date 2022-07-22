package builder;

public class MealBuilder {
	public OrderMeal prepareVegMeal (){
		
		OrderMeal meal = new OrderMeal();
	    meal.addItem(new VegBurger());
	    meal.addItem(new Coke());
	    return meal;
	}   

	public OrderMeal prepareNonVegMeal (){
	
		OrderMeal meal = new OrderMeal();
	    meal.addItem(new ChickenBurger());
	    meal.addItem(new Pepsi());
	    return meal;
	}
}
