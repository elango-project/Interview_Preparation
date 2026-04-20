import java.util.*;
class Users{
    int id;
    int unit;
    String type;
    Users(int id,int unit,String type){
        this.id=id;
        this.unit=unit;
        this.type=type;
    }
}

class services {
    int sid;
    ArrayList<Users> user = new ArrayList<>();

    services(int sid) {
        this.sid=sid;
    }
    
    void adduserbill(int id,int unit,String type){
        user.add(new Users(id,unit,type));
    }
}
public class ElectricityApplication {
    public static void main(String[] args){
        int opt;
        Scanner sc=new Scanner(System.in);
        services s=new services(1);
        do {
            System.out.println("Enter option: ");
            opt=sc.nextInt();
            switch (opt) {
                case 1:
                    System.out.println("Enter your Details");
                    System.out.println("Enter id: ");
                    int id= sc.nextInt();
                    System.out.println("Enter unit: ");
                    int unit= sc.nextInt();
                    System.out.println("Enter Type(Consumer or Business): ");
                    String type= sc.next();
                    if(!(type.equals("consumer")||type.equals("business"))){
                        System.out.println("Wrong Type!...");
                        return;
                    }
                    s.adduserbill(id,unit,type);
                    System.out.println("Start Generate...");
                case 2:
                    System.out.println("THank You!");
                    break;

            }
        }while(opt!=2);
    }
}
