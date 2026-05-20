package subscriber;

import publisher.Publisher;

public interface Subscriber {
    public void update();
    public void setPublisher(Publisher publisher);
}
