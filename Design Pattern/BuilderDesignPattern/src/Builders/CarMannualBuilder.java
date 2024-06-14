package Builders;

import Components.*;
import Product.*;

public class CarMannualBuilder implements Builder {
	
	private CarType type;
    private int seats;
    private Engine engine;
    
    @Override
    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    
    public Mannual getResult() {
        return new Mannual(type, seats, engine);
    }

}
