import builderImpl.CarBuilder;
import director.Director;
import product.Car;

public class Main {
    public static void main(String[] args) {
        CarBuilder myCarBuilder = new CarBuilder();
        Director director = new Director(myCarBuilder);
        Car car = director.constructCar();
        System.out.println(car);
    }
}