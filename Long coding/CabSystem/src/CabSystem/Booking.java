package CabSystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking {
    String cname;
    int cabno;
    Date date;

    Booking(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Customer Name: ");
        cname=sc.next();
        System.out.println("Enter Cab Number: ");
        cabno=sc.nextInt();
        System.out.println("Enter Date(dd-mm-yyyy): ");
        String dateinput=sc.next();
        SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy");
        try{
            date=dateformat.parse(dateinput);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    public boolean isAvailable(ArrayList<Cab> cabs , ArrayList<Booking> bookings){
        int count=0;
        for(Cab c:cabs){
            if(c.getcab() == cabno){
                count=c.getcapacity();
            }
        }
        int booking=0;
        for(Booking b:bookings){
            if(b.cabno==cabno&&b.date.equals(date)){
                booking++;
            }
        }
        return booking<count?true:false;
    }
}
