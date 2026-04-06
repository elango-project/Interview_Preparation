import java.util.ArrayList;
import java.util.Scanner;

class Book{
    int id;
    String name;
    String Author;
    boolean issued;
    Book(int id,String name,String Author){
        this.id=id;
        this.name=name;
        this.Author=Author;
        this.issued=false;
    }

}
class LibraryManagementApp{
    static Scanner sc=new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();
    public static void main(String[] args){
        books.add(new Book(1,"Harry Potter","Auhter1"));
        books.add(new Book(2,"Iron Man","Auther2"));
        books.add(new Book(3,"Ben 10","Auhter3"));
        int choice;
        do{
            System.out.println(" 1.View Books\n 2.Add Books \n 3.Issued \n 4. Return \n 5. Exit");
            System.out.println("Enter Your Choice: ");
            choice=sc.nextInt();
            switch (choice){
                case 1:
                    showbooks();
                    break;
                case 2:
                    addbooks();
                    break;
                case 3:
                    issuedbook();
                    break;
                case 4:
                    returnbook();
                    break;
                case 5:
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }while (choice!=5);

    }

    static void showbooks() {
        for (Book b:books){
            System.out.println("id: "+b.id+", Book Name: "+b.name+", Auther: "+b.Author+", Issued: "+b.issued);
        }
    }

    static void addbooks() {
        System.out.println("Enter id: ");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Book Name: ");
        String name=sc.nextLine();
        System.out.println("Enter Auther: ");
        String auther=sc.nextLine();
        books.add(new Book(id,name,auther));
    }

    static void issuedbook() {
        System.out.println("Enter id: ");
        int id=sc.nextInt();
        for(Book b:books){
            if(b.id==id&&!b.issued){
                b.issued=true;
                return;
            }
        }
        System.out.println("Invalid Issue!");
    }

    static void returnbook() {
        System.out.println("Enter id: ");
        int id=sc.nextInt();
        for(Book b:books){
            if(b.id==id&&b.issued){
                b.issued=false;
            }
        }
        System.out.println("Invalid Return!");
    }


}