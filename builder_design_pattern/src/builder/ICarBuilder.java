package builder;

import builderImpl.CarBuilder;
import product.Car;

public interface ICarBuilder {
    public CarBuilder buildWheels(int wheels);
    public CarBuilder buildSeats(int seats);
    public CarBuilder buildStorage(boolean isSpace);
    public CarBuilder buildEngine(String engine);
    public CarBuilder buildTank(int capacity);
    public Car build();
}
