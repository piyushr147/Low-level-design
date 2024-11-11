package controller;

import currency.Currency;
import currency.CurrencyType;
import operation.OperationType;

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


    public void addCurrency(Currency currency) {
        for(Currency currCurrency:currencyList){
            if(currency.getCurrencyType().getDenomination() == currCurrency.getCurrencyType().getDenomination()) {
                currCurrency.addQuantity(currency.getQuantity());
                return;
            }
        }
        currencyList.add(currency);
    }

    public Currency getCurrency(CurrencyType currencyType) {
        for(Currency currency:currencyList){
            if(currency.getCurrencyType().getDenomination() == currencyType.getDenomination())
                return currency;
        }
        return null;
    }
}
