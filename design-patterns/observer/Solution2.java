import java.util.List;
import java.util.ArrayList;

public class Solution2 {
    public static void main(String[] args) {
        OrderSubject regularOrder = new RegularOrder(100, "Ipad");

        Observer sender = new SenderObserver("anonymous@hotmail.com", regularOrder);
        Observer receiver = new ReceiverObserver("nonanonymous@hotmail.com", regularOrder);

        System.out.println("Observers are implementing OrderSubject of type: " + regularOrder.getClass());

        regularOrder.addObserver(sender);
        regularOrder.addObserver(receiver);
        regularOrder.setStatus("Out for Delivery");
    }
}

abstract class OrderSubject {
    
    protected int orderId;
    protected String name;
    protected String status;
    protected List<Observer> observers;

    abstract void notifyObservers();
    abstract void addObserver(Observer ob);
    abstract void removeObserver(Observer ob);
    abstract void setStatus(String status);

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }

    public int getOrderId() {
        return this.orderId;
    }
}

class RegularOrder extends OrderSubject {

    public RegularOrder(int orderId, String name) {
        this.orderId = orderId;
        this.name = name;
        this.status = "Order Placed";
        this.observers = new ArrayList<>();
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer ob : observers) {
            ob.update();
        }
    }

    @Override
    public void addObserver(Observer ob) {
        observers.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        observers.remove(ob);
    }
}


class PrimeDeliveryOrder extends OrderSubject {

    public PrimeDeliveryOrder(int orderId, String name) {
        this.orderId = orderId;
        this.name = name;
        this.status = "Order Placed";
        this.observers = new ArrayList<>();
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer ob : observers) {
            ob.update();
        }
    }

    @Override
    public void addObserver(Observer ob) {
        observers.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        observers.remove(ob);
    }
}

interface Observer {
    void update();
}

class SenderObserver implements Observer {

    private String emailId;
    private final OrderSubject order;

    public SenderObserver(String emailId, OrderSubject order) {
        this.emailId = emailId;
        this.order = order;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void update() {
        System.out.println("Hi, " + emailId + " your order for item " + this.order.getName() + " is now " + this.order.getStatus());
    }
}

class ReceiverObserver implements Observer {
    private String emailId;
    private final OrderSubject order;

    public ReceiverObserver(String emailId, OrderSubject order) {
        this.emailId = emailId;
        this.order = order;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void update() {
        System.out.println("Hi, " + emailId + " your order for item " + this.order.getName() + " is now " + this.order.getStatus());
    }
}