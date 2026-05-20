package states.concreteStateImpl;

import controller.ProductController;
import enums.Coin;
import machine.VendingMachine;
import product.Product;
import states.State;

public class SelectState implements State {
    private final ProductController productController = ProductController.getInstance();

    @Override
    public void displayItems(VendingMachine vm) throws Exception {
        throw new UnsupportedOperationException("operation not supported yet.");
    }

    @Override
    public void selectItems(VendingMachine vm, Product product) throws Exception {
        if(productController.checkIfProductExist(product)){
            System.out.println("Product exists! enter coins");
            productController.setSelectedProduct(product);
            vm.setCurrentState(new InsertCoinState());
        }
        else {
            System.out.println("Product is currently unavaliable");
            vm.setCurrentState(new IdleState());
        }
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
