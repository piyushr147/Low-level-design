package parkingSlot;

import vehicle.Vehicle;

public class ParkingSlot {
    private int slot_id;
    private int type;
    private int price;
    private boolean isEmpty;
    private Vehicle vehicle;

    public ParkingSlot(){}

    public ParkingSlot(int slot_id, int type, int price,boolean isEmpty, Vehicle vehicle) {
        this.slot_id = slot_id;
        this.type = type;
        this.price = price;
        this.isEmpty = isEmpty;
        this.vehicle = vehicle;
    }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public int getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
