package factory.vehicleFactory;

import vehicle.Vehicle;

public interface VehicleFactory {
    public Vehicle createVehicleObject(int id,int type);
}
