package factory.vehicleFactory;

import enums.WheelerType;
import vehicle.Vehicle;
import vehicle.vehicleConcreteClass.FourWheelerVehicle;
import vehicle.vehicleConcreteClass.TwoWheelerVehicle;

public class VehicleFactory {
    public static Vehicle createVehicleObject(int id, WheelerType type){
        if(type == WheelerType.FOUR_WHEELER){
            return new FourWheelerVehicle(id, WheelerType.FOUR_WHEELER);
        }
        else if(type == WheelerType.TWO_WHEELER){
            return new TwoWheelerVehicle(id, WheelerType.TWO_WHEELER);
        }
        return new FourWheelerVehicle(id, WheelerType.FOUR_WHEELER);
    };
}
