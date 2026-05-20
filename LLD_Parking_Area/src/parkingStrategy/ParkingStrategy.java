package parkingStrategy;

import enums.WheelerType;
import parkingSlot.ParkingSlot;
import vehicle.Vehicle;

public interface ParkingStrategy {
    public ParkingSlot getParkingSlot(WheelerType type);
}
