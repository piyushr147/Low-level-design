import decorator.BaseInvoice;
import decorator.DiscountDecorator;
import decorator.Invoice;
import decorator.TaxDecorator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BaseInvoice baseInvoice = new Invoice();
        BaseInvoice decoratedInvoice = new TaxDecorator(new DiscountDecorator(baseInvoice));
        System.out.println(decoratedInvoice.calculateAmount());
    }
}