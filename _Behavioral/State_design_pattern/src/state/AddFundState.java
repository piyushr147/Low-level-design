package state;

import controller.CurrencyController;
import controller.ProductController;
import currency.Currency;
import vandingMachine.VendingMachine;

public class AddFundState implements State{

    private CurrencyController currencyController;

    public AddFundState(){
        System.out.println("Currently the machine is in funding state");
    }
    @Override
    public void clickFundsButton() throws Exception {
        System.out.println("Already in adding fund state");
    }

    @Override
    public void clickProductButton() throws Exception {
        VendingMachine.getInstance().changeState(new SelectProductState());
    }

    @Override
    public void addFunds(Currency currency) throws Exception {
        System.out.println("Adding your funds");
        currencyController = CurrencyController.getInstance();
        for(Currency myCurrency:currencyController.getCurrencyList()){
            if(myCurrency.getCurrencyType().getDenomination() == currency.getCurrencyType().getDenomination()){
                myCurrency.addAmount(currency.getAmount());
                return;
            }
        }
        currencyController.getCurrencyList().add(currency);
    }

    @Override
    public void cancelFunds() throws Exception {
        System.out.println("Cancelling process, and refunding money back");
        currencyController = CurrencyController.getInstance();
        currencyController.getCurrencyList().clear();
        VendingMachine.getInstance().changeState(new IdealState());
    }

    @Override
    public void selectProduct(int productID) throws Exception {
        throw new Exception("First click product select button");
    }

    @Override
    public void cancelProduct(int productID) throws Exception {
        throw new Exception("can't reach this state as no product is clicked");
    }

    @Override
    public void dispenseProduct(int productID) throws Exception {
        throw new Exception("can't reach here before product selection state");
    }

    @Override
    public int getChange() throws Exception {
        throw new Exception("invalid operation");
    }
}
