package Examples;

public class Ex3_Client {

    //instance variables
    private String name;
    private String address;
    private int lawnSize;
    private boolean hasDog;
    private double outstandingFees;

    //constructor method
    public Ex3_Client(String n, String a, int s, boolean d){
        name = n;
        address = a;
        lawnSize = s;
        hasDog = d;
        outstandingFees = 0;
    }

    //instance methods
    public String toString(){
        return name + "  " + address + "  " + lawnSize + "  " + hasDog + "  " + outstandingFees;
    }//toString

    public void mowLawn(){

        double baseFee = 20;
        if(lawnSize < 300){
            baseFee += 0.1*lawnSize;
        }
        else {
            baseFee += 0.15*lawnSize;
        }

        if(hasDog){
            baseFee += 40;
        }

        outstandingFees += baseFee;

        System.out.println(name + " your lawn was mowed today for a charge of $" + baseFee);
        System.out.println("You currently owe: $" + outstandingFees);

    }//mowLawn

}
