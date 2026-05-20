package publisher;

import subscriber.Subscriber;

public abstract class Publisher {
    int stock = 0;
    public abstract void add(Subscriber subscriberObj);
    public abstract void remove(Subscriber subscriberObj);
    public abstract void sendNotification();

    public void setData(int data){
        if(stock==0) {
            stock = data;
            sendNotification();
        }
        stock = data;
    }
    public int getData(){
        return stock;
    }
}
