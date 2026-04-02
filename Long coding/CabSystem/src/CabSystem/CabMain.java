package CabSystem;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class CabMain {
    public static void main(String[] args){
        ArrayList<Cab> cabs=new ArrayList<>();
        ArrayList<Booking> bookings=new ArrayList<>();

        cabs.add(new Cab(1,true,4));
        cabs.add(new Cab(2,true,4));
        cabs.add(new Cab(3,true,4));
        int useropt=1;
        Scanner sc=new Scanner(System.in);
        for(Cab c:cabs){
            c.dispalycab();
        }
        while(useropt==1) {
            System.out.println("Enter your option 1. Book, 2. Exit");
            useropt = sc.nextInt();
            if(useropt==1){
                Booking booking=new Booking();
                if(booking.isAvailable(cabs,bookings)){
                    bookings.add(booking);
                    System.out.println("Your Booking is Confirmed!");
                }else{
                    System.out.println("Sorry, Booking is full change bus No or Date.");
                }
            }
        }
    }
}
