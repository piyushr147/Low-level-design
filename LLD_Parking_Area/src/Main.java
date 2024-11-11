import factory.factoryManager.FactoryManager;
import gates.Entry;
import gates.Exit;
import parkingSlotManager.ParkingSlotManager;
import ticket.Ticket;
import vehicle.Vehicle;
import vehicle.vehicleConcreteClass.FourWheelerVehicle;
import vehicle.vehicleConcreteClass.TwoWheelerVehicle;

import static constants.Constants.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        System.out.println("Hello and welcome!");
        Vehicle mercedes = new FourWheelerVehicle(100,4);
        Vehicle activa = new TwoWheelerVehicle(101,2);
        Vehicle activa2 = new TwoWheelerVehicle(102,2);

        FactoryManager factoryManager = new FactoryManager();
        ParkingSlotManager twoWheelerManager = factoryManager.createParkingManagerObject(TWO_WHEELER_MANAGER,10);
        ParkingSlotManager fourWheelerManager = factoryManager.createParkingManagerObject(FOUR_WHEELER_MANAGER,10);

        Entry entry = new Entry(factoryManager);
        entry.setParkingSlotManager(fourWheelerManager);
        entry.setVehicle(mercedes);
        Ticket ticketMercedes = entry.generateTicket();

        entry.setParkingSlotManager(twoWheelerManager);
        entry.setVehicle(activa);
        Ticket ticketActiva = entry.generateTicket();

        entry.setParkingSlotManager(twoWheelerManager);
        entry.setVehicle(activa2);
        Ticket ticketActiva2 = entry.generateTicket();

        twoWheelerManager.checkParkingSlotStatus();
        fourWheelerManager.checkParkingSlotStatus();

        Exit exit = new Exit();
        exit.setPayment(CASH_PAYMENT);
        exit.setTicket(ticketMercedes);
        exit.setParkingSlotManager(fourWheelerManager);
        exit.freeParkingSlot();
        exit.calculatePrice();
        exit.recievePayment();

        exit.setPayment(ONLINE_PAYMENT);
        exit.setTicket(ticketActiva);
        exit.setParkingSlotManager(twoWheelerManager);
        exit.freeParkingSlot();
        exit.calculatePrice();
        exit.recievePayment();

        twoWheelerManager.checkParkingSlotStatus();
        fourWheelerManager.checkParkingSlotStatus();

        entry.setVehicle(activa2);
        ticketActiva2 = entry.generateTicket();

        exit.setPayment(2);
        exit.setTicket(ticketActiva2);
        exit.setParkingSlotManager(twoWheelerManager);
        exit.freeParkingSlot();
        exit.calculatePrice();
        exit.recievePayment();

        twoWheelerManager.checkParkingSlotStatus();
        fourWheelerManager.checkParkingSlotStatus();
    }
}