package payment;

public class CashPayment implements Payment{
    @Override
    public void processPayment() {
        System.out.println("processing cash payment.....");
    }

    @Override
    public void cancelPayment() {
        System.out.println("Cancelling your cash payment....");
    }
}
