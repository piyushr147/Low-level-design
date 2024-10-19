package subscriber.subscriberImpl;

import publisher.PublisherInterface;
import publisher.publisherImpl.IphonePublisher;
import subscriber.SubscriberInterface;

public class EmailNotificationSubscriber implements SubscriberInterface {

    public PublisherInterface publisherObj;
    public String emailId;
    public EmailNotificationSubscriber(String emailId, PublisherInterface publisherObj){
        this.publisherObj = publisherObj;
        this.emailId = emailId;
    }
    @Override
    public void update() {
        System.out.println("sending email to the: "+emailId);
    }
}
