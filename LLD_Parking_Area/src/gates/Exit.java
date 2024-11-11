package gates;

import parkingSlot.ParkingSlot;
import parkingSlotManager.ParkingSlotManager;
import payment.CashPayment;
import payment.OnlinePayment;
import payment.Payment;
import ticket.Ticket;

import java.util.Date;

import static constants.Constants.CASH_PAYMENT;
import static constants.Constants.ONLINE_PAYMENT;

public class Exit {
    private Ticket ticket;
    private ParkingSlotManager parkingSlotManager;
    private int transaction_type;
    private Payment payment;

    public Ticket getTicket() { return ticket; }

    public void setTicket(Ticket ticket) { this.ticket = ticket; }

    public ParkingSlotManager getParkingSlotManager() { return parkingSlotManager; }

    public void setParkingSlotManager(ParkingSlotManager parkingSlotManager) { this.parkingSlotManager = parkingSlotManager; }

    public int getTransaction_type() { return transaction_type; }

    public void setTransaction_type(int transaction_type) { this.transaction_type = transaction_type; }

    public Payment getPayment() { return payment; }

    public void setPayment(int payment_type) {
        setPaymentObject(payment_type);
    }

    private void setPaymentObject(int transaction_type) {
        if(transaction_type == CASH_PAYMENT)
            payment = new CashPayment();
        else if(transaction_type == ONLINE_PAYMENT)
            payment = new OnlinePayment();
        else
            System.out.println("invalid transaction type");
    }

    public void freeParkingSlot(){
        ParkingSlot parkingSlot = ticket.getParkingSlot();
        if(!parkingSlot.isEmpty()) {
            parkingSlotManager.releaseParkingSlot(parkingSlot);
        }
    }

    public int calculatePrice(){
        Date date = new Date();
        int hours = (int) ((date.getTime() - ticket.getEntryTime().getTime())/60*60*60);
        return hours*ticket.getParkingSlot().getPrice();
    }

    public void recievePayment(){
        payment.processPayment();
    }
}
