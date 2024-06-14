package Factory;
import ConcreteFactory.*;
import ConcreteProduct.*;
import Product.*;
import java.util.Scanner;

public class Client {
	
		    public static void main(String[] args) {
		        Furniture modernFactory = new Modern();
		        Furniture victorianFactory = new Victorian();
		        Furniture artDecoFactory = new ArtDeco();

		        Chair modernChair = modernFactory.createChair();
		        Sofa modernSofa = modernFactory.createSofa();
		        CoffeeTable modernCoffeeTable = modernFactory.createCoffeeTable();

		        modernChair.sitOn();
		        modernSofa.lieOn();
		        modernCoffeeTable.drinkCoffee();

		    /*    Chair victorianChair = victorianFactory.createChair();
		        Sofa victorianSofa = victorianFactory.createSofa();
		        CoffeeTable victorianCoffeeTable = victorianFactory.createCoffeeTable();

		        victorianChair.sitOn();
		        victorianSofa.lieOn();
		        victorianCoffeeTable.drinkCoffee();

		        Chair artDecoChair = artDecoFactory.createChair();
		        Sofa artDecoSofa = artDecoFactory.createSofa();
		        CoffeeTable artDecoCoffeeTable = artDecoFactory.createCoffeeTable();

		        artDecoChair.sitOn();
		        artDecoSofa.lieOn();
		        artDecoCoffeeTable.drinkCoffee();*/
		    }



	}

