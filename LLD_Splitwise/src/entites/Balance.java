package entites;

import entites.user.User;

import java.util.HashMap;
import java.util.Map;

public class Balance {
    private HashMap<User, Double> balance;

    public Balance() {
        balance = new HashMap<>();
    }

    public void addBalance(User user, Double amount) {
        balance.merge(user, amount, Double::sum);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Map.Entry<User, Double> entry: balance.entrySet()) {
            User key = entry.getKey();
            Double amount = entry.getValue();
            String description;
            if(amount>0)
                description = key.getName() + " gets back " + amount;
            else
                description = key.getName() + " owes " + amount;
            str.append(description).append("\n");
        }
        return str.toString();
    }
}
