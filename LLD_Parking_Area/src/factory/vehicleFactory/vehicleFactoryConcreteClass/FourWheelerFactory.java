package factory.vehicleFactory.vehicleFactoryConcreteClass;

import factory.vehicleFactory.VehicleFactory;
import vehicle.Vehicle;
import vehicle.vehicleConcreteClass.FourWheelerVehicle;

public class FourWheelerFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicleObject(int id, int type) {
        return new FourWheelerVehicle(id,type);
    }
}
