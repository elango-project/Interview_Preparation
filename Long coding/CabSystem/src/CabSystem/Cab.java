package CabSystem;

public class Cab {
    private int cabno;
    private boolean ac;
    private int capacity;

    Cab(int cabno,boolean ac, int capacity){
        this.cabno=cabno;
        this.ac=ac;
        this.capacity=capacity;
    }
    public void setcab(int cabno){
        this.cabno=cabno;
    }
    public int getcab(){
        return cabno;
    }
    public void setac(boolean ac){
        this.ac=ac;
    }
    public boolean getac(){
        return ac;
    }
    public void setcapacity(){
        this.capacity=capacity;
    }
    public int getcapacity(){
        return capacity;
    }
    public void dispalycab(){
        System.out.println("Cabs no: "+cabno+
                            ", Ac: "+ac+
                            ", Capacity: "+capacity);
    }
}
