package ticket;

public class Ticket {
    private int id;
    private int price;
    private TicketClass ticketClass;
    private Show show;

    protected Ticket(int id, int price){
        this.id = id;
    }
}
