package machine;

import controller.CurrencyController;
import currency.Currency;
import state.ATMState;
import state.IdealState;

import java.util.List;

public class ATM {
    private ATMState state;
    private static ATM machine;
    private List<Currency> currencyList;

    private ATM(){
        this.state = new IdealState();
    }
    public static ATM getMachine() {
        if(machine == null)
            machine = new ATM();
        return machine;
    }

    public ATMState getState() {
        return state;
    }

    public void changeState(ATMState state) {
        this.state = state;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public void addCurrency(Currency currency) {
        CurrencyController.getInstance().addCurrency(currency);
    }
}
