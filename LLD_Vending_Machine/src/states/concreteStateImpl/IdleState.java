package states.concreteStateImpl;

import controller.ProductController;
import enums.Coin;
import machine.VendingMachine;
import product.Product;
import states.State;

public class IdleState implements State {
    private final ProductController productController = ProductController.getInstance();

    @Override
    public void displayItems(VendingMachine vm) throws Exception {
        productController.displayProducts();
        vm.setCurrentState(new SelectState());
    }

    @Override
    public void selectItems(VendingMachine vm, Product product) throws Exception {
        throw new UnsupportedOperationException("operation not supported yet.");
    }

    @Override
    public void enterCoins(VendingMachine vm, Coin coin) throws Exception {
        throw new UnsupportedOperationException("operation not supported yet.");
    }

    @Override
    public void checkBalance(VendingMachine vm) throws Exception {
        throw new UnsupportedOperationException("operation not supported yet.");
    }

    @Override
    public void dispenseProduct(VendingMachine vm) throws Exception {
        throw new UnsupportedOperationException("operation not supported yet.");
    }

    @Override
    public void returnChange(VendingMachine vm) throws Exception {
        throw new UnsupportedOperationException("operation not supported yet.");
    }
}
