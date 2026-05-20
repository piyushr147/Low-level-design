package strategy;

import entites.expense.Expense;
import entites.expense.ExpenseRequest;

import java.util.List;

public interface ExpenseStrategy {
    public List<Expense> split(ExpenseRequest request);
}
