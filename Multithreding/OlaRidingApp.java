package Multithreding;

class RideRequest extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("User requested a ride..");
            Thread.sleep(2000);
            System.err.println("Searching for nearby drivers...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class DriverAssignment extends Thread {

    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("Driver found and assigned!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class FareCalculation extends Thread {
    public void run() {
        try {
            System.out.println("Calculating estimated fare...");
            Thread.sleep(1500);
            System.out.println("Estimated fare: 135.75 RS.");
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

}

class LiveTracking extends Thread {
    public void run() {
        try {
            for (int i = 20; i <= 100; i += 20) {
                System.out.println("Updating ride location... " + i + "% completed");
                Thread.sleep(2000);
            }
            System.out.println("Ride Completed....");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PaymentProcessing extends Thread {
    public void run() {
        try {
            System.out.println("Processing payment...");
            Thread.sleep(2000);
            System.out.println("Payment successfull !!");
        }

        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class RatingSystem extends Thread {
    public void run() {
        try {
            System.out.println("Requesting user rating...");
            Thread.sleep(1000);
            System.out.println("User rated the ride 5 Star");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class OlaRidingApp {
    public static void main(String[] args) {
        try {
            RideRequest ride = new RideRequest();
            DriverAssignment assignment = new DriverAssignment();
            FareCalculation calculation = new FareCalculation();
            LiveTracking tracking = new LiveTracking();
            PaymentProcessing payment = new PaymentProcessing();
            RatingSystem rataing = new RatingSystem();

            ride.start();

            calculation.start();
            ride.join();

            assignment.start();
            assignment.join();

            tracking.start();
            tracking.join();

            payment.start();
            payment.join();
            rataing.start();
            rataing.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
