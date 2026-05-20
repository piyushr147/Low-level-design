package decorator;

public abstract class InvoiceDecorator implements BaseInvoice {
    BaseInvoice baseInvoice;

    public InvoiceDecorator(BaseInvoice baseInvoice) {
        this.baseInvoice = baseInvoice;
    }

    public abstract double calculateAmount();
}
