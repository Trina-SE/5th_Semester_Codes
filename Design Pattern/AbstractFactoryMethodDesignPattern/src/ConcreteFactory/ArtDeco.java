package ConcreteFactory;

import ConcreteProduct.*;
import Factory.Furniture;
import Product.*;

public class ArtDeco implements Furniture {
	
	public Chair createChair() {
		return new ArtDecoChair();
	}
	
	public CoffeeTable createCoffeeTable() {
		return new ArtDecoCoffeeTable();
	}
	
	public Sofa createSofa() {
		return new ArtDecoSofa();
	}

}
