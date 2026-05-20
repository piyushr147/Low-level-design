package decorator;

public class Invoice implements BaseInvoice {
    @Override
    public double calculateAmount() {
        return 1000;
    }
}
