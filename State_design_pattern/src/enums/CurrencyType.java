package enums;

public enum CurrencyType {
    RUPEES_ONE(1),
    RUPEES_FIVE(5),
    RUPEES_TEN(10),
    RUPEES_FIFTY(50);

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
