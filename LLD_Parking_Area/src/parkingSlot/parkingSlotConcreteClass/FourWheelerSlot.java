package parkingSlot.parkingSlotConcreteClass;

import enums.WheelerType;
import parkingSlot.ParkingSlot;
import vehicle.Vehicle;

public class FourWheelerSlot extends ParkingSlot {
    public FourWheelerSlot(int slot_id, WheelerType type, boolean isEmpty, Vehicle vehicle) {
        super(slot_id, type, 20, isEmpty, vehicle);
    }
}
