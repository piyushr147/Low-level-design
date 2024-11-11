package ticket;

import parkingSlot.ParkingSlot;
import vehicle.Vehicle;

import java.util.Date;

public class Ticket {
    private Vehicle vehicle;
    private Date entryTime;
    private ParkingSlot parkingSlot;

    public Ticket(Vehicle vehicle, Date entryTime, ParkingSlot parkingSlot) {
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.parkingSlot = parkingSlot;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public Date getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }
    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }
    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }
}
