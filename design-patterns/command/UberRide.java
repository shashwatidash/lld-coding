public class UberRide {
    public static void main(String[] args) {
        Uber uber = new Uber();
        UberRequest rideRequest1 = new UberRideRequest(uber, "Andrew", "Church Street");
        UberRequest rideRequest2 = new UberRideRequest(uber, "Andrew", "Bridage Road");
        UberRequest cancelRequest = new UberRideCancelRequest(uber, "Andrew", "Church Street");
        
        RideRequest requestInvoker = new RideRequest();

        requestInvoker.processRequest(rideRequest1);
        requestInvoker.processRequest(rideRequest2);
        requestInvoker.processRequest(cancelRequest);
    }
}

// Reciever
class Uber {

    public void bookRide(String passengerName, String dest) {
        System.out.println("Booking ride for " + passengerName + " travelling to " + dest);
    }

    public void cancelRide(String passengerName, String dest) {
        System.out.println("Cancelling ride for " + passengerName + " travelling to " + dest);
    }

}

// Command Interface
interface UberRequest {
    void execute();
}

// Concrete command
class UberRideRequest implements UberRequest {

    private Uber uber;
    private String passengerName;
    private String dest;

    public UberRideRequest(Uber uber, String passengerName, String dest) {
        this.uber = uber;
        this.passengerName = passengerName;
        this.dest = dest;
    }

    @Override
    public void execute() {
        uber.bookRide(passengerName, dest);
    }
}

class UberRideCancelRequest implements UberRequest {

    private Uber uber;
    private String passengerName;
    private String dest;

    public UberRideCancelRequest(Uber uber, String passengerName, String dest) {
        this.uber = uber;
        this.passengerName = passengerName;
        this.dest = dest;
    }

    @Override
    public void execute() {
        uber.cancelRide(passengerName, dest);
    }
}

// Invoker class 
class RideRequest {

    public void processRequest(UberRequest request) {
        request.execute();
    }
}

