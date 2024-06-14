package ConcreteFactory;

import ConcreteProduct.*;
import Factory.Furniture;
import Product.*;

public class Victorian implements Furniture {
	
	public Chair createChair() {
		return new VictorianChair();
	}
	
	public CoffeeTable createCoffeeTable() {
		return new VictorianCoffeeTable();
	}
	
	public Sofa createSofa() {
		return new VictorianSofa();
	}


}
