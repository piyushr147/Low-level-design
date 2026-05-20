package subscriber.subscriberImpl;

import publisher.Publisher;
import subscriber.Subscriber;

public class EmailNotificationSubscriber implements Subscriber {

    public Publisher publisherObj;
    public String emailId;

    public EmailNotificationSubscriber(String emailId){
        this.emailId = emailId;
    }

    @Override
    public void update() {
        System.out.println("sending email to the: " + emailId + " stocks left: " + publisherObj.getData());
    }

    @Override
    public void setPublisher(Publisher publisher) {
        this.publisherObj = publisher;
    }
}
