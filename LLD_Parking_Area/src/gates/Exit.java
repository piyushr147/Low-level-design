package gates;

import enums.PaymentType;
import parkingSlot.ParkingSlot;
import parkingSlotManager.ParkingSlotManager;
import payment.CashPayment;
import payment.OnlinePayment;
import payment.Payment;
import ticket.Ticket;
import java.util.Date;

public class Exit {
    private Ticket ticket;
    private ParkingSlotManager parkingSlotManager;
    private PaymentType paymentType;
    private Payment payment;

    public Ticket getTicket() { return ticket; }

    public void setTicket(Ticket ticket) { this.ticket = ticket; }

    public ParkingSlotManager getParkingSlotManager() { return parkingSlotManager; }

    public void setParkingSlotManager(ParkingSlotManager parkingSlotManager) { this.parkingSlotManager = parkingSlotManager; }

    public PaymentType getTransaction_type() { return paymentType; }

    public void setTransaction_type(PaymentType transaction_type) { this.paymentType = transaction_type; }

    public Payment getPayment() { return payment; }

    public void setPayment(PaymentType payment_type) {
        setPaymentObject(payment_type);
    }

    private void setPaymentObject(PaymentType paymentType) {
        if(paymentType.equals(PaymentType.CASH_PAYMENT))
            payment = new CashPayment();
        else if(paymentType.equals(PaymentType.ONLINE_PAYMENT))
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
