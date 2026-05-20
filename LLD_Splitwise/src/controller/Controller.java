package controller;

import entites.expense.Expense;
import entites.expense.ExpenseRequest;
import entites.user.User;
import strategy.ExpenseStrategy;

public interface Controller {
    public void addExpense(ExpenseRequest request, ExpenseStrategy strategy);
    public void removeExpense(Expense expense);
    public void showBalance(User user);
    public void updateBalance(Expense expense);
}
