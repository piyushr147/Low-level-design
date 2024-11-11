package currency;

public enum CurrencyType {
    RUPEES_100(100),
    RUPEES_500(500),
    RUPEES_2000(2000);

    private final int denomination;

    // Constructor to initialize the denomination
    CurrencyType(int denomination) {
        this.denomination = denomination;
    }

    // Getter method to retrieve the denomination value
    public int getDenomination() {
        return denomination;
    }
}
