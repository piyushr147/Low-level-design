package parkingSlotManager.parkingSlotConcreteClass;

import enums.ManagerType;
import enums.WheelerType;
import parkingSlot.ParkingSlot;
import parkingSlot.parkingSlotConcreteClass.TwoWheelerSlot;
import parkingSlotManager.ParkingSlotManager;

import java.util.ArrayList;
import java.util.List;

public class TwoWheelerParkingSlotManager extends ParkingSlotManager {
    private static TwoWheelerParkingSlotManager INSTANCE;
    private static final int capacity = 10;

    public TwoWheelerParkingSlotManager(int capacity){
        super(capacity);
    }
    public TwoWheelerSlot twoWheelerSlot;

    public static TwoWheelerParkingSlotManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new TwoWheelerParkingSlotManager(capacity);
        }
        return INSTANCE;
    }
    @Override
    public void checkParkingSlotStatus() {
        System.out.println("parking slots accquired: "+super.getAvailable_slot_index());
    }

    @Override
    public List<ParkingSlot> initializeParkingList(int capacity) {
        List<ParkingSlot> parkingSlots = new ArrayList<>(capacity);
        for(int i=0;i<capacity;i++){
            parkingSlots.add(i,new TwoWheelerSlot(i, WheelerType.TWO_WHEELER,true,null));
        }
        return parkingSlots;
    }
}
