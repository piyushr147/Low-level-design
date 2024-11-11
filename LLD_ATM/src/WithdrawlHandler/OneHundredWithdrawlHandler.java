package WithdrawlHandler;

import controller.CurrencyController;
import currency.Currency;
import currency.CurrencyType;

public class OneHundredWithdrawlHandler extends WithdrawlHandler{

    public OneHundredWithdrawlHandler(WithdrawlHandler nextHandler) {
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
        int amountLeft = remainingAmount - value*value_required;

        if(value_required <= quantity && amountLeft == 0){
            currency.reduceQuantity(value_required);
            return true;
        }
        return false;
    }
}
