package gates;

import factory.factoryManager.FactoryManager;
import factory.parkingManagerFactory.ParkingManagerFactory;
import parkingSlot.ParkingSlot;
import parkingSlotManager.ParkingSlotManager;
import ticket.Ticket;
import vehicle.Vehicle;

import java.lang.management.ManagementFactory;
import java.util.Date;

public class Entry {
    private Vehicle vehicle;
    private ParkingSlotManager parkingSlotManager;
    private FactoryManager factoryManager;

    public Entry(FactoryManager factoryManager){
        this.factoryManager = factoryManager;
    }

    public ParkingSlotManager getParkingSlotManager() {
        return parkingSlotManager;
    }

    public void setParkingSlotManager(ParkingSlotManager parkingSlotManager) {
        this.parkingSlotManager = parkingSlotManager;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Ticket generateTicket(){
        if(parkingSlotManager.isParkingSlotAvailable()){
            System.out.println("parking slot is available");
            ParkingSlot parkingSlot = parkingSlotManager.provideParkingSlotIfAvailable(vehicle);
            if(parkingSlot == null){
                System.out.println("Parking slot not found due to some error");
            }
            else{
                Ticket ticket = new Ticket(vehicle,new Date(),parkingSlot);
                return ticket;
            }
        }
        else
            System.out.println("parking slot is not available");
        return null;
    }
}
