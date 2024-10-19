import publisher.publisherImpl.IphonePublisher;
import publisher.publisherImpl.PixelPublisher;
import subscriber.subscriberImpl.EmailNotificationSubscriber;
import subscriber.subscriberImpl.MessageNotificationSubscriber;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        IphonePublisher iphonePublisher = new IphonePublisher();
        PixelPublisher pixelPublisher = new PixelPublisher();

        EmailNotificationSubscriber email1 = new EmailNotificationSubscriber("piyush@1",iphonePublisher);
        EmailNotificationSubscriber email2 = new EmailNotificationSubscriber("piyush@2",pixelPublisher);
        MessageNotificationSubscriber message1 = new MessageNotificationSubscriber("1234",iphonePublisher);
        MessageNotificationSubscriber message2 = new MessageNotificationSubscriber("2345",pixelPublisher);

        iphonePublisher.add(email1);
        iphonePublisher.add(message1);
        pixelPublisher.add(email1);
        pixelPublisher.add(message1);

        iphonePublisher.sendNotification();
        pixelPublisher.sendNotification();
    }
}