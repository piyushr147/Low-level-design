package decorator;

public class TaxDecorator extends InvoiceDecorator {

    public TaxDecorator(BaseInvoice invoice) {
        super(invoice);
    }

    @Override
    public double calculateAmount() {
        return 0.80*(baseInvoice.calculateAmount());
    }
}
