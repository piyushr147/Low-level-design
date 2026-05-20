package strategy;

import entites.user.User;
import entites.expense.Expense;
import entites.expense.ExpenseRequest;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements ExpenseStrategy{
    @Override
    public List<Expense> split(ExpenseRequest request) {
        double amount = request.getAmount();
        User paidBy =  request.getPaidBy();
        List<User> paidFor = request.getPaidFor();
        List<Expense> expenses = new ArrayList<>();

        if(!paidFor.isEmpty()){
            int size = paidFor.size();
            double split = amount/size;
            for (User user : paidFor) {
                if (paidBy.equals(user))
                    continue;
                String description = paidBy.getName() + " gets back amount " + split + " and " + user.getName() + " owes the same amount.";
                expenses.add(new Expense(split, description, paidBy, user));
            }
            return expenses;
        }
        return null;
    }
}
