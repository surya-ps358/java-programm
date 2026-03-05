package Multithreding;

class Petrolpump {
    public synchronized void refillcar(String carName) {
        try {
            System.out.println("<" + carName + "> started filling");
            Thread.sleep(3000);
            System.out.println("<" + carName + "completed refilling!..");
        } catch (InterruptedException e) {
            System.out.println("Refilling was interrupted for " + carName);
            e.printStackTrace();
        }

    }
}

class Car implements Runnable {
    private String name;
    private Petrolpump petrolpump;

    public Car(String name, Petrolpump petrolpump) {
        this.name = name;
        this.petrolpump = petrolpump;
    }

    @Override
    public void run() {
        petrolpump.refillcar(name);
    }

}

public class PetrolPumpSimulation {

    public static void main(String[] args) {

        Petrolpump petrolPump = new Petrolpump();

        String[] carNames = { "Ford", "Naxon", "Maruti" };

        Car[] cars = new Car[carNames.length];
        Thread[] threads = new Thread[carNames.length];

        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i], petrolPump);
            threads[i] = new Thread(cars[i]);
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted while waiting: " + t.getName());
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("All cars have completed refilling.");
    }
}
