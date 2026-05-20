package state;

import currency.Currency;

public interface State {
    public void clickFundsButton() throws Exception;
    public void clickProductButton() throws Exception;
    public void addFunds(Currency currency) throws Exception;
    public void cancelFunds() throws Exception;
    public void selectProduct(int productID) throws Exception;
    public void cancelProduct(int productID) throws Exception;
    public void dispenseProduct(int productID) throws Exception;
    public int getChange() throws Exception;
}
