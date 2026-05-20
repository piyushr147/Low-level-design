package controller;

import entites.Balance;
import entites.expense.Expense;
import entites.expense.ExpenseRequest;
import entites.user.User;
import strategy.ExpenseStrategy;
import java.util.*;

public class UserController implements Controller{
    List<User> users;

    @Override
    public void addExpense(ExpenseRequest request, ExpenseStrategy strategy) {
        List<Expense> expenses = strategy.split(request);
        for(Expense expense : expenses){
            expense.getPaidBy().addExpense(expense);
            expense.getPaidFor().addExpense(expense);
            updateBalance(expense);
        }
    }

    @Override
    public void removeExpense(Expense expense) {
        User paidBy = expense.getPaidBy();
        User paidFor = expense.getPaidFor();

        paidBy.removeExpense(expense);
        paidFor.removeExpense(expense);
        expense.setAmount(-expense.getAmount());
        updateBalance(expense);
    }

    @Override
    public void showBalance(User user) {
        Balance balance = user.getBalance();
        System.out.println(balance.toString());
    }

    @Override
    public void updateBalance(Expense expense) {
        User paidBy = expense.getPaidBy();
        User paidFor = expense.getPaidFor();

        paidBy.editBalance(paidFor, expense.getAmount());
        paidFor.editBalance(paidBy, -expense.getAmount());
    }

    public void showAllExpenses(User user) {
        System.out.println(user.getExpenses().toString());
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
