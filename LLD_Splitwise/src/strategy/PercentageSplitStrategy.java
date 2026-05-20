package strategy;

import entites.user.User;
import entites.expense.Expense;
import entites.expense.ExpenseRequest;

import java.util.ArrayList;
import java.util.List;

public class PercentageSplitStrategy implements ExpenseStrategy{
    @Override
    public List<Expense> split(ExpenseRequest request) {
        double amount = request.getAmount();
        User paidBy =  request.getPaidBy();
        List<User> paidFor = request.getPaidFor();
        List<Double> splits = request.getSplits();
        List<Expense> expenses = new ArrayList<>();

        if(paidFor.size() != splits.size())
            return null;

        if(!paidFor.isEmpty()){
            int size = paidFor.size();
            for(int i = 0; i < size; i++){
                if(paidBy.equals(paidFor.get(i)))
                    continue;
                double split = (splits.get(i)*amount)/100;
                String description = paidBy.getName() + " gets back amount " + split + " and :" + paidFor.get(i).getName() + " owes the same amount.";
                expenses.add(new Expense(split,"",paidBy,paidFor.get(i)));
            }
            return expenses;
        }
        return null;
    }
}
