package parkingSlotManager;

import parkingSlot.ParkingSlot;
import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public abstract class ParkingSlotManager {
    private int capacity;
    private int available_slot_index;
    public List<ParkingSlot> parkingSlots;

    protected ParkingSlotManager(int capacity){
        this.capacity = capacity;
        this.available_slot_index = 0;
        this.parkingSlots = initializeParkingList(capacity);
    }

    public int getCapacity() {return capacity;}

    public int getAvailable_slot_index() {return available_slot_index;}

    public List<ParkingSlot> getParkingSlots() {return parkingSlots;}

    public Boolean isParkingSlotAvailable(){
        return available_slot_index < capacity;
    }

    public  ParkingSlot provideParkingSlotIfAvailable(Vehicle vehicle){
        if(isParkingSlotAvailable()){
            parkingSlots.get(available_slot_index).setVehicle(vehicle);
            acquireParkingSlot(parkingSlots.get(available_slot_index));
            return parkingSlots.get(available_slot_index++);
        }
        return null;
    }

    public void acquireParkingSlot(ParkingSlot parkingSlot){
        parkingSlots.get(parkingSlot.getSlot_id()).setEmpty(false);
    }

    public void releaseParkingSlot(ParkingSlot parkingSlot){
        parkingSlots.get(parkingSlot.getSlot_id()).setEmpty(true);
        parkingSlots.get(parkingSlot.getSlot_id()).setVehicle(null);
        available_slot_index--;
    }

    public abstract void checkParkingSlotStatus();

    public abstract List<ParkingSlot> initializeParkingList(int capacity);
}
