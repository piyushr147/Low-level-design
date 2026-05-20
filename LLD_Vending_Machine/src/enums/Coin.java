package enums;

public enum Coin {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    FIFTY(50),
    HUNDRED(100);

    private final int value;

    Coin(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean matches(int valueToCheck) {
        for (Coin coin : Coin.values()) {
            if (coin.getValue() == valueToCheck) {
                return true;
            }
        }
        return false;
    }
}
