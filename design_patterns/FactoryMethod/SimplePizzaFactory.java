package FactoryMethod;

public class SimplePizzaFactory {
	public static PizzaPackages createPizzaPackage (PizzaPackageCode packageCode) {
		switch(packageCode) {
		
			case MINIPACKAGE:
				return new PizzaMiniPackage();
			case BIGPACKAGE:
				return new PizzaBigPackage();
			default:		
				return null;		
		}
	}
}


