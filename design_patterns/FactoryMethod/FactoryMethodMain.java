package FactoryMethod;

public class FactoryMethodMain {
	public static void main(String[] args) {
		PizzaPackages pizzaPackages = SimplePizzaFactory.createPizzaPackage(PizzaPackageCode.BIGPACKAGE);
		System.out.println(pizzaPackages);
		System.out.println("It's a jumbo package");
		
		PizzaPackages pizzaPackages1 = SimplePizzaFactory.createPizzaPackage(PizzaPackageCode.MINIPACKAGE);
		System.out.println("\n" + pizzaPackages1);
		System.out.println("It's a mini package");
	}
}


