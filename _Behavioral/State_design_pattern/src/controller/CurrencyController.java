package controller;

import currency.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyController {
    private List<Currency> currencyList;
    private static CurrencyController currencyController;

    private CurrencyController(){
        currencyList = new ArrayList<Currency>();
    }

    public static CurrencyController getInstance(){
        if(currencyController == null)
            currencyController = new CurrencyController();
        return currencyController;
    }

    public void addCurrency(Currency currency){
        currencyList.add(currency);
    }

    public List<Currency> getCurrencyList(){
        return currencyList;
    }

    public int getTotalValue(){
        int total = 0;
        for(Currency currency:currencyList)
            total+= currency.getAmount()*currency.getCurrencyType().getDenomination();
        return total;
    }
}
