package state;

import currency.Currency;
import vandingMachine.VendingMachine;

public class IdealState implements State{

    private VendingMachine vendingMachine;

    public IdealState(){
        System.out.println("Currently the machine is in ideal state...");
    }

    @Override
    public void clickFundsButton() throws Exception {
        System.out.println("Taking you to fund addition state");
        VendingMachine.getInstance().changeState(new AddFundState());
    }

    @Override
    public void clickProductButton() throws Exception {
        System.out.println("Please add funds before product selection");
        VendingMachine.getInstance().changeState(new AddFundState());
    }

    @Override
    public void addFunds(Currency currency) throws Exception {
        throw new Exception("Can't add funds before clicking the button");
    }

    @Override
    public void cancelFunds() throws Exception {
        throw new Exception("No fund has been added yet");
    }

    @Override
    public void selectProduct(int productID) throws Exception {
        throw new Exception("Can't enter product selection state before adding funds");
    }

    @Override
    public void cancelProduct(int productID) throws Exception {
        throw new Exception("Can't enter product cancellation state before adding funds");
    }

    @Override
    public void dispenseProduct(int productID) throws Exception {
        throw new Exception("Can't enter product dispense state");
    }

    @Override
    public int getChange() throws Exception {
        throw new Exception("invalid operation");
    }
}
