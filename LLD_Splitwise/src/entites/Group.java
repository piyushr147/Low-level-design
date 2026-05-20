package entites;

import entites.expense.Expense;
import entites.notification.Notification;
import entites.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Group {
    private String id;
    private String groupName;
    private List<User> members;
    private List<Balance> groupBalances;
    private List<Expense> groupExpenses;
    private Notification notifier;
    private int totalExpense;

    public Group(Notification notifier) {
        this.id = UUID.randomUUID().toString();
        this.members = new ArrayList<>();
        this.groupBalances = new ArrayList<>();
        this.groupExpenses = new ArrayList<>();
        this.notifier = notifier;
    }

    public void notifyMembers(String message) {
        notifier.sendNotification(message);
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public void addMember(User user) {
        notifier.sendNotification(user.getName() + " added to the group");
        notifier.subscribe(user);
        members.add(user);
    }

    public void removeMember(User user) {
        notifier.unSubscribe(user);
        members.remove(user);
    }

    public List<Balance> getGroupBalances() {
        return groupBalances;
    }

    public void setGroupBalances(List<Balance> groupBalances) {
        this.groupBalances = groupBalances;
    }

    public List<Expense> getGroupExpenses() {
        return groupExpenses;
    }

    public void setGroupExpenses(List<Expense> groupExpenses) {
        this.groupExpenses = groupExpenses;
    }

    public int getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(int totalExpense) {
        this.totalExpense = totalExpense;
    }
}
