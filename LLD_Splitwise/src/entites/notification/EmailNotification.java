package entites.notification;

import entites.user.User;

import java.util.ArrayList;
import java.util.List;

public class EmailNotification implements Notification{
    List<User> subscribers;

    public EmailNotification() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void sendNotification(String message) {
        for(User user : subscribers){
            user.update(message);
        };
    }

    @Override
    public void subscribe(User user) {
        if(!userExists(user.getEmail()))
            subscribers.add(user);
    }

    @Override
    public void unSubscribe(User user) {
        if(userExists(user.getEmail()))
            subscribers.remove(user);
    }

    public boolean userExists(String email) {
        for (User user : subscribers) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
