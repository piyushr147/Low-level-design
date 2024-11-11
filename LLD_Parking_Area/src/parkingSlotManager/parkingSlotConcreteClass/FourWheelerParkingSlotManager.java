package parkingSlotManager.parkingSlotConcreteClass;

import parkingSlot.ParkingSlot;
import parkingSlot.parkingSlotConcreteClass.FourWheelerSlot;
import parkingSlot.parkingSlotConcreteClass.TwoWheelerSlot;
import parkingSlotManager.ParkingSlotManager;
import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

import static constants.Constants.FOUR_WHEELER_MANAGER;

public class FourWheelerParkingSlotManager extends ParkingSlotManager {

    public FourWheelerParkingSlotManager(int capacity) {
        super(capacity);
    }
    public FourWheelerSlot fourWheelerSlot;

    @Override
    public void checkParkingSlotStatus() {
        System.out.println("parking slots accquired: "+super.getAvailable_slot_index());
    }

    @Override
    public List<ParkingSlot> initializeParkingList(int capacity) {
        List<ParkingSlot> parkingSlots = new ArrayList<>(capacity);
        for(int i=0;i<capacity;i++){
            parkingSlots.add(i,new FourWheelerSlot(i,FOUR_WHEELER_MANAGER,true,null));
        }
        return parkingSlots;
    }
}
