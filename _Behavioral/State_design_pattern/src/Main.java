import currency.Currency;
import enums.CurrencyType;
import product.Product;
import vandingMachine.VendingMachine;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        vendingMachine.addProduct(new Product(1,"Pepsi can",2,30));
        vendingMachine.addProduct(new Product(2,"limca can",4,25));
        vendingMachine.addProduct(new Product(3,"lays chips",10,10));
        vendingMachine.addProduct(new Product(4,"Britania cake",3,15));

        vendingMachine.getState().clickFundsButton();
        vendingMachine.getState().addFunds(new Currency(1, CurrencyType.RUPEES_TEN));
        vendingMachine.getState().addFunds(new Currency(1, CurrencyType.RUPEES_TEN));
        vendingMachine.getState().addFunds(new Currency(1, CurrencyType.RUPEES_FIVE));
        vendingMachine.getState().addFunds(new Currency(1, CurrencyType.RUPEES_ONE));
        vendingMachine.getState().addFunds(new Currency(1, CurrencyType.RUPEES_FIFTY));

        vendingMachine.calculateTotal();

        vendingMachine.getState().clickProductButton();

        vendingMachine.showProducts();
        vendingMachine.getState().selectProduct(1);

        vendingMachine.showProducts();

        vendingMachine.getState().dispenseProduct(1);
    }
}