package Examples;

import java.util.ArrayList;

public class Ex3_Main {

    public static void run(){

        ArrayList<Ex3_Client>allClients = new ArrayList<>();

        allClients.add(new Ex3_Client("Han Solo", "5 Hoth St", 120, false));
        allClients.add(new Ex3_Client("Yoda", "16 Degobah Swamp", 2000, true));
        allClients.add(new Ex3_Client("Princess Leia", "Alderon Palace", 1000, true));
        allClients.add(new Ex3_Client("R2D2", "3 BackOfShip", 40, false));
        allClients.add(new Ex3_Client("Darth Vader", "1 Death Star", 500, true));

        for (int i = 0; i < allClients.size(); i++) {

            allClients.get(i).mowLawn();

        }

        for(Ex3_Client clientTemp: allClients){
            clientTemp.mowLawn();
        }

        for (int i = 0; i < allClients.size(); i++) {

            System.out.println(allClients.get(i));

        }

    }//run

}
