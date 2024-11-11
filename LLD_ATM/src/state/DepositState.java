package state;

import controller.CurrencyController;
import currency.Currency;
import machine.ATM;

public class DepositState extends ATMState {

    public DepositState(){
        System.out.println("Depositing your currency..");
    }

    public void depositCash(Currency currency){
        ATM.getMachine().addCurrency(currency);
        System.out.println("Currency deposited");
        ATM.getMachine().changeState(new SelectionState());
    }
}
