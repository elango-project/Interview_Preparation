import java.util.*;

// Food class
class Food {
    int id;
    String name;
    double price;

    Food(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

// OrderItem class
class OrderItem {
    Food food;
    int quantity;

    OrderItem(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    double getTotal() {
        return food.price * quantity;
    }
}

// Order class
class Order {
    int orderId;    
    List<OrderItem> items = new ArrayList<>();

    Order(int orderId) {
        this.orderId = orderId;
    }

    void addItem(Food food, int qty) {
        items.add(new OrderItem(food, qty));
    }

    double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    void showBill() {
        System.out.println("\n===== BILL =====");
        for (OrderItem item : items) {
            System.out.println(item.food.name + " x " + item.quantity +
                    " = ₹" + item.getTotal());
        }
        System.out.println("Total Amount: ₹" + calculateTotal());
    }
}

// Customer class
class Customer {
    String username;
    String password;

    Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    boolean login(String u, String p) {
        return username.equals(u) && password.equals(p);
    }
}

// Main system class
public class FoodOrderingSystem {

    static Scanner sc = new Scanner(System.in);
    static List<Food> menu = new ArrayList<>();

    public static void main(String[] args) {

        // Sample menu
        menu.add(new Food(1, "Pizza", 200));
        menu.add(new Food(2, "Burger", 120));
        menu.add(new Food(3, "Pasta", 150));
        menu.add(new Food(4, "Sandwich", 100));

        // Sample user
        Customer user = new Customer("chan", "1234");
        Customer user1 = new Customer("elango", "1234");


        // Login
        System.out.println("===== FOOD ORDERING SYSTEM =====");
        System.out.print("Enter Username: ");
        String u = sc.next();
        System.out.print("Enter Password: ");
        String p = sc.next();

        if (!(user.login(u, p) || user1.login(u, p))) {
            System.out.println("Invalid Login!");
            return;
        }

        System.out.println("Login Successful!");

        Order order = new Order(1);

        int choice;
        do {
            showMenu();
            System.out.print("Enter Food ID: ");
            int id = sc.nextInt();

            Food selectedFood = findFood(id);

            if (selectedFood != null) {
                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();
                order.addItem(selectedFood, qty);
                System.out.println("Item Added to Cart!");
            } else {
                System.out.println("Invalid Food ID!");
            }

            System.out.println("1. Add More Items");
            System.out.println("2. Checkout");
            choice = sc.nextInt();

        } while (choice == 1);

        order.showBill();
        System.out.println("Order Placed Successfully!");
    }

    static void showMenu() {
        System.out.println("\n===== MENU =====");
        for (Food f : menu) {
            System.out.println(f.id + ". " + f.name + " - ₹" + f.price);
        }
    }

    static Food findFood(int id) {
        for (Food f : menu) {
            if (f.id == id) {
                return f;
            }
        }
        return null;
    }
}