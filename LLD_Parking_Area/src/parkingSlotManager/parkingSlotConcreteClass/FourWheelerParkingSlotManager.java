package parkingSlotManager.parkingSlotConcreteClass;

import enums.ManagerType;
import enums.WheelerType;
import parkingSlot.ParkingSlot;
import parkingSlot.parkingSlotConcreteClass.FourWheelerSlot;
import parkingSlot.parkingSlotConcreteClass.TwoWheelerSlot;
import parkingSlotManager.ParkingSlotManager;
import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;


public class FourWheelerParkingSlotManager extends ParkingSlotManager {
    private static FourWheelerParkingSlotManager INSTANCE;
    private static final int capacity = 10;

    private FourWheelerParkingSlotManager(int capacity) {
        super(capacity);
    };

    public FourWheelerSlot fourWheelerSlot;

    public static FourWheelerParkingSlotManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new FourWheelerParkingSlotManager(capacity);
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
            parkingSlots.add(i,new FourWheelerSlot(i, WheelerType.FOUR_WHEELER,true,null));
        }
        return parkingSlots;
    }
}
