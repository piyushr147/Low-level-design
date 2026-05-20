package entites.expense;

import entites.Group;
import entites.user.User;
import enums.ExpenseType;

import java.util.List;

public class ExpenseRequest {
    private double amount;
    private String description;
    private User paidBy;
    private List<User> paidFor;
    private ExpenseType expenseType;
    private List<Double> splits;
    private Group group;

    private ExpenseRequest(){};

    private ExpenseRequest(RequestBuilder requestBuilder) {
        this.amount = requestBuilder.amount;
        this.description = requestBuilder.description;
        this.paidBy = requestBuilder.paidBy;
        this.paidFor = requestBuilder.paidFor;
        this.expenseType = requestBuilder.expenseType;
        this.splits = requestBuilder.splits;
        this.group = requestBuilder.group;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() { return description; }

    public User getPaidBy() {
        return paidBy;
    }

    public List<User> getPaidFor() {
        return paidFor;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public List<Double> getSplits() {
        return splits;
    }

    public Group getGroup() { return group; }

    public static class RequestBuilder{
        private double amount;
        private String description;
        private User paidBy;
        private List<User> paidFor;
        private ExpenseType expenseType;
        private List<Double> splits;
        private Group group;

        public ExpenseRequest build(){
            return new ExpenseRequest(this);
        }

        public RequestBuilder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public RequestBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public RequestBuilder setPaidBy(User paidBy) {
            this.paidBy = paidBy;
            return this;
        }

        public RequestBuilder setPaidFor(List<User> paidFor) {
            this.paidFor = paidFor;
            return this;
        }

        public RequestBuilder setExpenseType(ExpenseType expenseType) {
            this.expenseType = expenseType;
            return this;
        }

        public RequestBuilder setSplits(List<Double> splits) {
            this.splits = splits;
            return this;
        }

        public RequestBuilder setGroup(Group group) {
            this.group = group;
            return this;
        }
    }
}
