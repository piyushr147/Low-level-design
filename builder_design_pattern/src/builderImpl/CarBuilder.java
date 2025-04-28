package builderImpl;

import builder.ICarBuilder;
import product.Car;

import java.lang.reflect.GenericDeclaration;

public class CarBuilder implements ICarBuilder {

    private Car car;

    public CarBuilder(){
        this.car = new Car();
    }

    @Override
    public CarBuilder buildWheels(int wheels) {
        car.wheels = wheels;
        return this;
    }

    @Override
    public CarBuilder buildSeats(int seats) {
        car.seats = seats;
        return this;
    }

    @Override
    public CarBuilder buildStorage(boolean isSpace) {
        car.storage = isSpace;
        return this;
    }

    @Override
    public CarBuilder buildEngine(String engine) {
        car.engine = engine;
        return this;
    }

    @Override
    public CarBuilder buildTank(int capacity) {
        car.capacity = capacity;
        return this;
    }

    @Override
    public Car build() {
        return car;
    }
}
