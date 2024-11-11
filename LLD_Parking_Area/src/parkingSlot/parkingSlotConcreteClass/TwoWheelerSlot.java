package parkingSlot.parkingSlotConcreteClass;

import parkingSlot.ParkingSlot;
import vehicle.Vehicle;

public class TwoWheelerSlot extends ParkingSlot {
    public TwoWheelerSlot(int slot_id, int type, boolean isEmpty, Vehicle vehicle){
        super(slot_id,type,10,isEmpty,vehicle);
    }
}
