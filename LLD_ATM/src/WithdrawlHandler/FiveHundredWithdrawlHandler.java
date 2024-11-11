package WithdrawlHandler;

import controller.CurrencyController;
import currency.Currency;
import currency.CurrencyType;
import machine.ATM;

public class FiveHundredWithdrawlHandler extends WithdrawlHandler{

    public FiveHundredWithdrawlHandler(WithdrawlHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public boolean applyChain(int remainingAmount) {
        if(remainingAmount == 0)
            return true;
        Currency currency = CurrencyController.getInstance().getCurrency(CurrencyType.RUPEES_2000);
        int value = currency.getCurrencyType().getDenomination();
        int quantity = currency.getQuantity();
        int value_required = remainingAmount/value;

        if(quantity < value_required){
            int amountLeft = remainingAmount - value*quantity;
            if(applyChain(amountLeft)){
                currency.reduceQuantity(quantity);
                return true;
            }
        }
        else{
            int amountLeft = remainingAmount - value*value_required;
            if(applyChain(amountLeft)){
                currency.reduceQuantity(value_required);
                return true;
            }
        }
        return super.applyChain(remainingAmount);
    }
}
