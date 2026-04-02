import java.util.*;

// Vehicle Class
class Vehicle {
    String vehicleNumber;

    Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
}

// Parking Slot Class
class ParkingSlot {
    int slotNumber;
    Vehicle vehicle;
    boolean isOccupied;

    ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.isOccupied = false;
        this.vehicle = null;
    }
}

// Parking System Class
class ParkingSystem {
    List<ParkingSlot> slots = new ArrayList<>();

    // Constructor - create slots
    ParkingSystem(int totalSlots) {
        for (int i = 1; i <= totalSlots; i++) {
            slots.add(new ParkingSlot(i));
        }
    }

    // Car Entry
    void carEntry(String vehicleNumber) {
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied) {
                slot.vehicle = new Vehicle(vehicleNumber);
                slot.isOccupied = true;
                System.out.println("Car parked at slot: " + slot.slotNumber);
                return;
            }
        }
        System.out.println("Parking Full!");
    }

    // Car Exit
    void carExit(String vehicleNumber) {
        for (ParkingSlot slot : slots) {
            if (slot.isOccupied && slot.vehicle.vehicleNumber.equals(vehicleNumber)) {
                slot.vehicle = null;
                slot.isOccupied = false;
                System.out.println("Car exited from slot: " + slot.slotNumber);
                return;
            }
        }
        System.out.println("Vehicle not found!");
    }

    // View Slots
    void viewSlots() {
        for (ParkingSlot slot : slots) {
            if (slot.isOccupied) {
                System.out.println("Slot " + slot.slotNumber + " : " + slot.vehicle.vehicleNumber);
            } else {
                System.out.println("Slot " + slot.slotNumber + " : Empty");
            }
        }
    }
}

// Main Class
public class ParkingSystemMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingSystem system = new ParkingSystem(5);

        while (true) {
            System.out.println("\n--- Parking System ---");
            System.out.println("1. Car Entry");
            System.out.println("2. Car Exit");
            System.out.println("3. View Slots");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle number: ");
                    String entryVehicle = sc.next();
                    system.carEntry(entryVehicle);
                    break;

                case 2:
                    System.out.print("Enter vehicle number: ");
                    String exitVehicle = sc.next();
                    system.carExit(exitVehicle);
                    break;

                case 3:
                    system.viewSlots();
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}