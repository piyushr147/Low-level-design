package parkingSlotManager.parkingSlotConcreteClass;

import parkingSlot.ParkingSlot;
import parkingSlot.parkingSlotConcreteClass.TwoWheelerSlot;
import parkingSlotManager.ParkingSlotManager;

import java.util.ArrayList;
import java.util.List;

import static constants.Constants.TWO_WHEELER_MANAGER;

public class TwoWheelerParkingSlotManager extends ParkingSlotManager {

    public TwoWheelerParkingSlotManager(int capacity){ super(capacity); }
    public TwoWheelerSlot twoWheelerSlot;

    @Override
    public void checkParkingSlotStatus() {
        System.out.println("parking slots accquired: "+super.getAvailable_slot_index());
    }

    @Override
    public List<ParkingSlot> initializeParkingList(int capacity) {
        List<ParkingSlot> parkingSlots = new ArrayList<>(capacity);
        for(int i=0;i<capacity;i++){
            parkingSlots.add(i,new TwoWheelerSlot(i,TWO_WHEELER_MANAGER,true,null));
        }
        return parkingSlots;
    }
}
