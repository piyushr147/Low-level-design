package decorator;

public class DiscountDecorator extends InvoiceDecorator{

    public DiscountDecorator(BaseInvoice invoice) {
        super(invoice);
    }

    @Override
    public double calculateAmount() {
        return 0.90*(baseInvoice.calculateAmount());
    }
}
