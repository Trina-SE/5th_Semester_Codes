package Product;
import Components.Engine;

public class Mannual {
	
	private CarType carType;
    private int seats;
    private Engine engine;
    
    public Mannual(CarType carType, int seats, Engine engine) {
     this.carType = carType;
     this.seats = seats;
     this.engine = engine;
 }
    
    public CarType getCarType() {
        return carType;
    }

    public int getSeats() {
        return seats;
    }

    public Engine getEngine() {
        return engine;
    }
    
    public String print() {
        String info = "";
        info += "Type of car: " + carType + "\n";
        info += "Count of seats: " + seats + "\n";
        info += "Engine: volume - " + engine.getVolume() + "; mileage - " + engine.getMileage() + "\n";
     
        return info;
    }

}
