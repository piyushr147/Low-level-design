package entites.user;

import entites.Balance;
import entites.expense.Expense;
import entites.notification.Subscribers;

import java.util.ArrayList;
import java.util.List;

public class User implements Subscribers {
    private int userId;
    private String name;
    private String email;
    private Balance balance;
    private List<Expense> expenses;

    public User(int userId,String name, String email) {
        this.balance = new Balance();
        this.expenses = new ArrayList<>();
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + getName() + " Beep: " + message);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public void editBalance(User user, double amount) {
        balance.addBalance(user, amount);
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void removeExpense(Expense expense) {
        expenses.remove(expense);
    }
}
