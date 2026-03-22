package Zad5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        ArrayList<Passenger> passengers = new ArrayList<>();

        passengers.add(new RegularPassenger("John Smith", true));
        passengers.add(new VipPassenger("Alice Wonderland", "VIP_001"));
        passengers.add(new RegularPassenger("Bob Builder", false));
        passengers.add(new VipPassenger("Charlie Chocolate", "VIP_999"));
        passengers.add(new RegularPassenger("David Beckham", true));
        passengers.add(new RegularPassenger("Eve Online", false));

        for (Passenger p : passengers) {
            if (p instanceof VipPassenger) {
                p.setCheckedIn(true);
            }
        }

        for (Passenger p : passengers) {
            if (p instanceof RegularPassenger) {
                if (p.getName().startsWith("D") || p.getName().startsWith("J")) {
                    p.setCheckedIn(true);
                }
            }
        }

        passengers.removeIf(p -> !p.isCheckedIn());

        int vipCount = 0;
        int regularWithLuggageCount = 0;

        for (Passenger p : passengers) {
            if (p instanceof VipPassenger) {
                vipCount++;
            } else if (p instanceof RegularPassenger) {
                RegularPassenger rp = (RegularPassenger) p;
                if (rp.isHasExtraLuggage()) {
                    regularWithLuggageCount++;
                }
            }
        }

        System.out.println("--- Statistics ---");
        System.out.println("Total VIPs: " + vipCount);
        System.out.println("Regular passengers with extra luggage: " + regularWithLuggageCount);

        Queue<Passenger> boardingQueue = new LinkedList<>();

        for (Passenger p : passengers) {
            if (p instanceof VipPassenger) {
                boardingQueue.add(p);
            }
        }

        for (Passenger p : passengers) {
            if (p instanceof RegularPassenger) {
                boardingQueue.add(p);
            }
        }

        System.out.println("\n--- Boarding Queue (VIPs at front) ---");
        while (!boardingQueue.isEmpty()) {
            System.out.println("Boarding: " + boardingQueue.poll());
        }
    }
}
