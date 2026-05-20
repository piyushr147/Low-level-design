package entites.notification;

import entites.user.User;

public interface Notification {
    public void sendNotification(String message);
    public void subscribe(User user);
    public void unSubscribe(User user);
}
