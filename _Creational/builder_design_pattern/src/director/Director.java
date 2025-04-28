package director;

import builderImpl.CarBuilder;
import product.Car;

public class Director {

    private final CarBuilder carBuilder;

    public Director(CarBuilder carBuilder){
        this.carBuilder = carBuilder;
    }

    public Car constructCar(){
        return carBuilder.buildEngine("Electric")
                .buildSeats(4)
                .buildStorage(true)
                .buildTank(40)
                .build();
    }
}
