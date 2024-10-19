package publisher.publisherImpl;

import publisher.PublisherInterface;
import subscriber.SubscriberInterface;

import java.util.ArrayList;
import java.util.List;

public class IphonePublisher implements PublisherInterface {
    int stock = 0;
    public List<SubscriberInterface> subscribersList = new ArrayList<>();

    @Override
    public void add(SubscriberInterface subscriberObj) {
        subscribersList.add(subscriberObj);
    }

    @Override
    public void remove(SubscriberInterface subscriberObj) {
        subscribersList.remove(subscriberObj);
    }

    @Override
    public void sendNotification() {
        for(SubscriberInterface subscriber:subscribersList){
            subscriber.update();
        }
    }

    @Override
    public void setData(int data) {
        if(stock>0)
            this.sendNotification();
    }
}
