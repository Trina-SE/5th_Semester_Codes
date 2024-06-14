package Factory;

import Product.*;

public interface Furniture {
	
	public Chair createChair();
	public CoffeeTable createCoffeeTable();
	public Sofa createSofa();
	

}
