package FactoryMethod;

import java.util.ArrayList;
import java.util.List;

public abstract class PizzaPackages {
	protected List<Pizza> pizza = new ArrayList<>();
	
	public PizzaPackages() {
		createPizzaPackage();
	}
	
	protected abstract void createPizzaPackage();
	
	@Override
	public String toString() {
		return "Package of Pizza: \n " + pizza ;
	}
}
