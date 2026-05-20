package states.concreteStateImpl;

import controller.ProductController;
import enums.Coin;
import machine.VendingMachine;
import product.Product;
import states.State;

public class ReturnChangeState implements State {
    private ProductController productController = ProductController.getInstance();

    @Override
    public void displayItems(VendingMachine vm) throws Exception {
        throw new UnsupportedOperationException("operation not supported yet.");
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
        int returnAmount = vm.getCurrentBalance() - productController.getSelectedProduct().getPrice();
        System.out.println("Returning change amount: "+returnAmount);
        vm.resetBalance();
        vm.setCurrentState(new IdleState());
    }
}
