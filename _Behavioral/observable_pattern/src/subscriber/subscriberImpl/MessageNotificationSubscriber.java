package subscriber.subscriberImpl;

import publisher.Publisher;
import subscriber.Subscriber;

public class MessageNotificationSubscriber implements Subscriber {

    public Publisher publisherObj;
    public String mobileNumber;

    public MessageNotificationSubscriber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void update() {
        System.out.println("sending to the mobileNumber: " + mobileNumber + " stocks left: " + publisherObj.getData());
    }

    @Override
    public void setPublisher(Publisher publisher) {
        this.publisherObj = publisher;
    }

}
