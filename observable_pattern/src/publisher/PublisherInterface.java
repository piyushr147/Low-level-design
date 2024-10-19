package publisher;

import subscriber.SubscriberInterface;

public interface PublisherInterface {
    public void add(SubscriberInterface subscriberObj);
    public void remove(SubscriberInterface subscriberObj);
    public void sendNotification();
    public void setData(int data);
}
