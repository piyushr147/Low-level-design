package vandingMachine;

import controller.CurrencyController;
import controller.ProductController;
import currency.Currency;
import product.Product;
import state.IdealState;
import state.State;

import java.util.List;

public class VendingMachine {
    private State state;
    private static VendingMachine vendingMachine;

    private VendingMachine(){
        this.state = new IdealState();
    }

    public static VendingMachine getInstance() {
        if(vendingMachine == null)
            vendingMachine = new VendingMachine();
        return vendingMachine;
    }

    public State getState(){
        return this.state;
    }

    public void changeState(State state){
        this.state = state;
    }

    public ProductController getProductController() {
        return ProductController.getInstance();
    }

    public void calculateTotal(){
        System.out.println("current total: " + CurrencyController.getInstance().getTotalValue());
    }

    public void addProduct(Product product){
        ProductController.getInstance().addProduct(product);
    }

    public void showProducts(){
        ProductController.getInstance().showAllAvailableProducts();
    }
}
