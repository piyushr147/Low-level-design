package states.concreteStateImpl;


import controller.ProductController;
import enums.Coin;
import machine.VendingMachine;
import product.Product;
import states.State;

import java.util.Arrays;

public class InsertCoinState implements State {
    private final ProductController productController = ProductController.getInstance();

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
        if(Arrays.stream(Coin.values()).anyMatch(c -> c == coin)){
            vm.addBalance(coin.getValue());
            if(vm.getCurrentBalance() >= productController.getSelectedProduct().getPrice()){
                System.out.println("Enough coins to buy the product");
                vm.setCurrentState(new DispenseProductState());
            }
            else{
                int neededBalance = productController.getSelectedProduct().getPrice() - vm.getCurrentBalance();
                System.out.println("Add this much balance to buy this product: "+neededBalance);
            }
        }
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
