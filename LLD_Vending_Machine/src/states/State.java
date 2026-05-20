package states;

import enums.Coin;
import machine.VendingMachine;
import product.Product;

public interface State {

    public void displayItems(VendingMachine vm) throws Exception;
    public void selectItems(VendingMachine vm,Product product) throws Exception;
    public void enterCoins(VendingMachine vm, Coin coin) throws Exception;
    public void checkBalance(VendingMachine vm) throws Exception;
    public void dispenseProduct(VendingMachine vm) throws Exception;
    public void returnChange(VendingMachine vm) throws Exception;
}
