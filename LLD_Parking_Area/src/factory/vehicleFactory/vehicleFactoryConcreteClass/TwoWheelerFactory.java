package factory.vehicleFactory.vehicleFactoryConcreteClass;

import factory.vehicleFactory.VehicleFactory;
import vehicle.Vehicle;
import vehicle.vehicleConcreteClass.TwoWheelerVehicle;

public class TwoWheelerFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicleObject(int id,int type) {
        return new TwoWheelerVehicle(id,type);
    }
}
