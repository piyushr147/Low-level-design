package currency;

public class Currency {
    private int quantity;
    private CurrencyType currencyType;

    public Currency(int quantity,CurrencyType currencyType){
        this.quantity = quantity;
        this.currencyType = currencyType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }
}
