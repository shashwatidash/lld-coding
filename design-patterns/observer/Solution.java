import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Order order = new Order(123, "Ordinary Sunscreen");
        Observer sender = new SenderObserver("anonymous@hotmail.com");
        Observer reciever = new RecieverObserver("nonanonymous@hotmail.com");

        order.addObserver(sender);
        order.addObserver(reciever);
        order.setStatus("Dispatched");

        order.removeObserver(sender);
        order.setStatus("Out for Delivery");
    }
}

class Order {

    List<Observer> observers = new ArrayList<>();

    private int orderId;
    private String name;
    private String status;

    public Order(int orderId, String name) {
        this.orderId = orderId;
        this.name = name;
        this.status = "Order Placed";
    }

    public String getName() {
        return this.name;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer ob : observers) {
            ob.update(this);
        }
    }

    public void addObserver(Observer ob) {
        observers.add(ob);
    }

    public void removeObserver(Observer ob) {
        observers.remove(ob);
    }
}

interface Observer {
    void update(Order order);
}

class SenderObserver implements Observer {
    String emailId;

    public SenderObserver(String emailId) {
        this.emailId = emailId;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void update(Order order) {
        System.out.println("Hi, " + emailId + " your order for item " + order.getName() + " is now " + order.getStatus());
    }
}

class RecieverObserver implements Observer {
    String emailId;

    public RecieverObserver(String emailId) {
        this.emailId = emailId;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public void update(Order order) {
        System.out.println("Hi, " + emailId + " your order for item " + order.getName() + " is now " + order.getStatus());
    }
}