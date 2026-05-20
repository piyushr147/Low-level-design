package publisher.publisherImpl;

import publisher.Publisher;
import subscriber.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class PixelPublisher extends Publisher {
    public String name="pixel";
    public List<Subscriber> subscribersList = new ArrayList<>();

    @Override
    public void add(Subscriber subscriberObj) {
        subscribersList.add(subscriberObj);
    }

    @Override
    public void remove(Subscriber subscriberObj) {
        subscribersList.remove(subscriberObj);
    }

    @Override
    public void sendNotification() {
        for(Subscriber subscriber:subscribersList){
            subscriber.setPublisher(this);
            subscriber.update();
        }
    }
}
