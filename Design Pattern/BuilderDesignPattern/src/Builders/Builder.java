package Builders;

import Components.*;
import Product.*;

public interface Builder {
	
	void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);

}
