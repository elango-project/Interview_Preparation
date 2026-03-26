import java.util.*;

class ParkingSystem {

    static String[] slots = new String[5]; // 5 parking slots
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Parking System ---");
            System.out.println("1. Car Entry");
            System.out.println("2. Car Exit");
            System.out.println("3. View Slots");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    carEntry();
                    break;
                case 2:
                    carExit();
                    break;
                case 3:
                    viewSlots();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // Car Entry
    public static void carEntry() {
        System.out.print("Enter Vehicle Number: ");
        String vehicleNumber = sc.next();

        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null) {
                slots[i] = vehicleNumber;
                System.out.println("Car Parked at Slot: " + (i + 1));
                return;
            }
        }

        System.out.println("Parking Full!");
    }

    // Car Exit
    public static void carExit() {
        System.out.print("Enter Vehicle Number: ");
        String vehicleNumber = sc.next();

        for (int i = 0; i < slots.length; i++) {
            if (vehicleNumber.equals(slots[i])) {
                slots[i] = null;
                System.out.println("Car Exited from Slot: " + (i + 1));
                return;
            }
        }

        System.out.println("Vehicle Not Found!");
    }

    // View Slots
    public static void viewSlots() {
        System.out.println("\nParking Slots Status:");
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null) {
                System.out.println("Slot " + (i + 1) + " : Empty");
            } else {
                System.out.println("Slot " + (i + 1) + " : " + slots[i]);
            }
        }
    }
}