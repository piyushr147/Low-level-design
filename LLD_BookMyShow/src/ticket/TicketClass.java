package ticket;

public enum TicketClass {
    SILVER(100),
    GOLD(200),
    PLATINUM(300);

    private final int price;

    // Constructor to initialize the price for each ticket class
    TicketClass(int price) {
        this.price = price;
    }

    // Getter method to retrieve the price
    public int getPrice() {
        return price;
    }
}