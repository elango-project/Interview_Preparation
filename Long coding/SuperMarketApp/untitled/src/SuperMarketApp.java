import java.sql.SQLOutput;
import java.util.*;
class product{
    int id;
    String ProName;
    double amount;

    product(int id,String ProName,int amount){
        this.id=id;
        this.ProName=ProName;
        this.amount=amount;
    }

}

class Order{
    int id;
    ArrayList<orderitem> order=new ArrayList<>();
    Order(int id){
        this.id=id;
    }
    void additem(product item, int quantity){
        order.add(new orderitem(item,quantity));
    }

    double calculate(){
        int total=0;
        for(orderitem o: order){
            total+=o.gettotal();
        }
        return total;
    }

    void showbill(){
        System.out.println("------Bill-------");
        for(orderitem o: order){
            System.out.println(o.item.ProName+ " x "+ o.quantity+" = " + o.gettotal());
        }
        System.out.println("Total= "+calculate());
    }
}

class orderitem{
    product item;
    int quantity;

    orderitem(product item,int quantity){
        this.item=item;
        this.quantity=quantity;
    }

    double gettotal(){
        return item.amount * quantity;
    }

}

public class SuperMarketApp {
    static Scanner sc=new Scanner(System.in);
    static ArrayList<product> menu=new ArrayList<>();
    public static void main(String[] args){
        menu.add(new product(1,"icecream",20));
        menu.add(new product(2,"Biscuit",10));
        menu.add(new product(3,"Chocolate",200));

        for(product p: menu){
            System.out.println("id: "+p.id+", Prouduct: "+p.ProName+", amount: "+p.amount);
        }

        Order order=new Order(1);
        int opt=1;
        while(opt==1){
            System.out.println("Enter Your id: ");
            int id=sc.nextInt();
            product selectedpro=findid(id);
            if(selectedpro!=null){
                System.out.println("Enter Quantity: ");
                int quantity= sc.nextInt();
                order.additem(selectedpro,quantity);
                System.out.println("your order is added to cart");
            }else{
                System.out.println("Invalid Product ID!");
            }

            System.out.println("Enter your option \n" + "1. Add Cart \n" + "2. Exit");
            opt=sc.nextInt();
        }
        if(opt==2){order.showbill();}else{
            System.out.println("Invalid option!");
        }
    }
    static product findid(int id){
        for(product p: menu){
            if(p.id==id){
                return p;
            }
        }
        return null;
    }
}
