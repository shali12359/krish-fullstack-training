package FactoryMethod;

public class PizzaMiniPackage extends PizzaPackages{
	@Override
	protected void createPizzaPackage() {
		pizza.add(new CheesePizza());
		pizza.add(new PepperoniPizza());
	}
}
