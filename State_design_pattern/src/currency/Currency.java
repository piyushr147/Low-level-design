package currency;

import enums.CurrencyType;

public class Currency {
    private int amount;
    private CurrencyType currencyType;

    public Currency(int amount,CurrencyType currencyType){
        this.currencyType = currencyType;
        this.amount = amount;
    }

    public void addAmount(int amount){
        this.amount+=amount;
    }

    public void deductAmount(int amount){
        this.amount-=amount;
    }

    public int getAmount(){
        return this.amount;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }
}
