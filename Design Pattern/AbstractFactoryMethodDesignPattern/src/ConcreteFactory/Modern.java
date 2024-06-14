package ConcreteFactory;

import ConcreteProduct.*;
import Factory.Furniture;
import Product.*;

public class Modern implements Furniture {
	
	public Chair createChair() {
		return new ModernChair();
	}
	
	public CoffeeTable createCoffeeTable() {
		return new ModernCoffeeTable();
	}
	
	public Sofa createSofa() {
		return new ModernSofa();
	}

}
