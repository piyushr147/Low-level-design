package controller;

import entites.*;
import entites.expense.Expense;
import entites.expense.ExpenseRequest;
import entites.user.User;
import strategy.ExpenseStrategy;

import java.util.ArrayList;
import java.util.List;

public class GroupController implements Controller{
    private List<Group> groups;
    private List<Expense> groupExpenses;
    private Balance groupBalances;
    private UserController userController;

    public GroupController(UserController userController) {
        this.groups = new ArrayList<>();
        this.groupExpenses = new ArrayList<>();
        this.groupBalances = new Balance();
        this.userController = userController;
    }

    @Override
    public void addExpense(ExpenseRequest request, ExpenseStrategy strategy) {
        Group group = request.getGroup();
        List<Expense> expenses = strategy.split(request);
        for(Expense expense : expenses){
            expense.getPaidBy().addExpense(expense);
            expense.getPaidFor().addExpense(expense);
            groupExpenses.add(expense);

            updateBalance(expense);
        }
        group.notifyMembers(request.getDescription());
    }

    @Override
    public void removeExpense(Expense expense) {
        groupExpenses.remove(expense);
        expense.getPaidBy().removeExpense(expense);
        expense.getPaidFor().removeExpense(expense);

        expense.setAmount(-expense.getAmount());
        updateBalance(expense);
    }

    @Override
    public void showBalance(User user) {
        System.out.println(groupBalances.toString());
    }

    public void showAllBalance() {
        System.out.println(groupBalances.toString());
    }

    @Override
    public void updateBalance(Expense expense) {
        userController.updateBalance(expense);

        User paidBy = expense.getPaidBy();
        User paidFor = expense.getPaidFor();
        double amount = expense.getAmount();

        groupBalances.addBalance(paidBy, amount);
        groupBalances.addBalance(paidFor, -amount);
    }

    public void showAllExpenses() {
        StringBuilder str = new StringBuilder();
        for(Expense expense : groupExpenses){
            str.append(expense.getPaidBy().toString());
        }
        System.out.println(str.toString());
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void deleteGroup(Group group) {
        groups.remove(group);
    }
}
