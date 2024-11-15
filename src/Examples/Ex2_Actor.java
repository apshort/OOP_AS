package Examples;

public class Ex2_Actor {

    //instance variables
    public String role;
    public String name;
    public int sales;
    public boolean isPro;

    //constructor methods
    public Ex2_Actor (String r, String n){
        role = r;
        name = n;
        sales = 0;
        isPro = false;
    }//constructor

    public Ex2_Actor (String r, String n, boolean p){
        role = r;
        name = n;
        sales = 0;
        isPro = p;
    }//constructor

    //instance methods
    public String toString(){
        return role + "  " + name + "  " + sales + "  " + isPro;
    }//toString

    public void printMe(){
        System.out.println(role + " is played by " + name);
        System.out.println("Tickets Sold: " + sales);
        System.out.println("Professional actor: " + isPro);
    }

    public void sellTix(int n){
        sales += n;
    }

}
