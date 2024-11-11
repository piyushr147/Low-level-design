package factory.factoryManager;

import factory.parkingManagerFactory.ParkingManagerFactory;
import factory.parkingManagerFactory.parkingManagerConcreteClass.FourWheelerParkingManagerFactory;
import factory.parkingManagerFactory.parkingManagerConcreteClass.TwoWheelerParkingManagerFactory;
import factory.vehicleFactory.VehicleFactory;
import parkingSlotManager.ParkingSlotManager;
import parkingSlotManager.parkingSlotConcreteClass.FourWheelerParkingSlotManager;
import parkingSlotManager.parkingSlotConcreteClass.TwoWheelerParkingSlotManager;
import vehicle.Vehicle;
import vehicle.vehicleConcreteClass.FourWheelerVehicle;
import vehicle.vehicleConcreteClass.TwoWheelerVehicle;

import static constants.Constants.*;

public class FactoryManager {

    private TwoWheelerParkingManagerFactory twoWheelerParkingManagerFactory = new TwoWheelerParkingManagerFactory();
    private FourWheelerParkingManagerFactory fourWheelerParkingManagerFactory = new FourWheelerParkingManagerFactory();
    public Vehicle createVehicleObject(int id,int type){
        if(type == TWO_WHEELER)
            return new TwoWheelerVehicle(id,type);
        if(type == FOUR_WHEELER)
            return new FourWheelerVehicle(id,type);
        return null;
    }

    public ParkingSlotManager createParkingManagerObject(int type, int capacity){
        if(type == TWO_WHEELER_MANAGER)
            return new TwoWheelerParkingSlotManager(capacity);
        if(type == FOUR_WHEELER_MANAGER)
            return new FourWheelerParkingSlotManager(capacity);
        return null;
    }
}
