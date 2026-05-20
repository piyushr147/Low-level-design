package entites.expense;

import entites.user.User;

import java.util.UUID;

public class Expense {
    private String id;
    private double amount;
    private String description;
    private User paidBy;
    private User paidFor;

    public Expense(double amount, String description, User paidBy, User paidFor) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.description = description;
        this.paidBy = paidBy;
        this.paidFor = paidFor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public User getPaidFor() {
        return paidFor;
    }

    public void setPaidFor(User paidFor) {
        this.paidFor = paidFor;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", paidBy=" + paidBy +
                ", paidFor=" + paidFor +
                '}';
    }
}
