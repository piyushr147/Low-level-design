package payment;

public class OnlinePayment implements Payment{
    @Override
    public void processPayment() {
        System.out.println("processing online payment.....");
    }

    @Override
    public void cancelPayment() {
        System.out.println("processing online payment.....");
    }
}
