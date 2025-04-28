package subscriber.subscriberImpl;

import publisher.PublisherInterface;
import publisher.publisherImpl.IphonePublisher;
import subscriber.SubscriberInterface;

public class MessageNotificationSubscriber implements SubscriberInterface {

    public PublisherInterface publisherObj;
    public String mobileNumber;

    public MessageNotificationSubscriber(String mobileNumber, PublisherInterface publisherObj){
        this.publisherObj = publisherObj;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void update(int stock) {
        System.out.println("sending to the mobileNumber: " + mobileNumber + "stocks left: " + stock);
    }

}
