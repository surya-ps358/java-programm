package Multithreding;

import java.util.Random;

class ParkingGarage {
    private int availableSpots;
    private final int MAX_SPOTS;

    public ParkingGarage(int maxSpots) {
        this.MAX_SPOTS = maxSpots;
        this.availableSpots = maxSpots;
    }

    public synchronized void parkCar(String carName) {
        while (availableSpots == 0) {
            System.out.println(carName + " is waiting for a spot.");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        availableSpots--;
        System.out.println(carName + " parked. Available spots: " + availableSpots);
        notifyAll();
    }

    public synchronized void freeSpot(String carName) {
        while (availableSpots == MAX_SPOTS) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        availableSpots++;
        System.out.println(carName + " left. Available spots: " + availableSpots);
        notifyAll();
    }

    public int getAvailableSpots() {
        return availableSpots;
    }
}

class Car implements Runnable {
    private ParkingGarage garage;
    private String carName;

    public Car(ParkingGarage garage, String carName) {
        this.garage = garage;
        this.carName = carName;
    }

    @Override
    public void run() {
        try {
            garage.parkCar(carName);

            Thread.sleep(new Random().nextInt(3000) + 1000);
            garage.freeSpot(carName);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class CarParkingProject {
    public static void main(String[] args) {
        System.out.println("Welcome to D-Mart Parking");

        int maxSpots = 5;
        ParkingGarage garage = new ParkingGarage(maxSpots);
        System.out.println("Total Available spots are :" + garage.getAvailableSpots());

        String[] cars = {
                "Maruti Brezza",
                "Tata Naxon",
                "Mahindra BE6",
                "Kia Seltos",
                "Honda city",
                "Toyota Fortuner",
                "Hundai i20"
        };

        Thread[] carThreads = new Thread[cars.length];
        for (int i = 0; i < cars.length; i++) {
            carThreads[i] = new Thread(new Car(garage, cars[i]));
            carThreads[i].start();
        }

        for (Thread t : carThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Parking garage simulation is complete.");
    }
}
