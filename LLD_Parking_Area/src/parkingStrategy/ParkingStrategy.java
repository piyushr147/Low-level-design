package parkingStrategy;

import parkingSlot.ParkingSlot;
import vehicle.Vehicle;

public interface ParkingStrategy {
    public ParkingSlot getParkingSlot(int type);
}
