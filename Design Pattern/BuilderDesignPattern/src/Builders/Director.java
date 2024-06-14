package Builders;
import Components.*;

import Product.CarType;

public class Director {
	
	protected void constructSportsCar(Builder builder) {
		
		builder.setCarType(CarType.SPORTS_CAR);
		builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 0));
	}
	
	protected void constructCityCar(Builder builder) {
		
        builder.setCarType(CarType.CITY_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(1.2, 0));
	}

}
