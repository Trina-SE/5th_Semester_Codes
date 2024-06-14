package Builders;
import Components.*;
import Product.*;

public class Client {
	
	public static void main(String[]args) {
		
		Director director = new Director();
		
		CarBuilder builder = new CarBuilder();
		director.constructSportsCar(builder);
		
		Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());


        CarMannualBuilder manualBuilder = new CarMannualBuilder();

        director.constructSportsCar(manualBuilder);
        Mannual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
	}

}
