package factory.factoryManager;

import enums.ManagerType;
import enums.WheelerType;
import factory.parkingManagerFactory.ParkingManagerFactory;
import factory.vehicleFactory.VehicleFactory;
import parkingSlotManager.ParkingSlotManager;
import parkingSlotManager.parkingSlotConcreteClass.FourWheelerParkingSlotManager;
import parkingSlotManager.parkingSlotConcreteClass.TwoWheelerParkingSlotManager;
import vehicle.Vehicle;
import vehicle.vehicleConcreteClass.FourWheelerVehicle;
import vehicle.vehicleConcreteClass.TwoWheelerVehicle;

public class FactoryManager {

    public FactoryManager(){
        System.out.println("FactoryManager created");
    }

    public Vehicle createVehicle(int id, WheelerType type){
        return VehicleFactory.createVehicleObject(id, type);
    }

    public ParkingSlotManager createParkingManager(ManagerType type, int capacity){
       return ParkingManagerFactory.createParkingSlotManagerObject(type);
    }
}
