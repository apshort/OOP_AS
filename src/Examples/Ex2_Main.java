package Examples;

import java.util.ArrayList;

public class Ex2_Main {

    public static void run(){

        ArrayList <Ex2_Actor> allActors = new ArrayList<>();

        allActors.add(new Ex2_Actor("Othello", "Smith", true)); //smith i promise this was not me i promise
        allActors.add(new Ex2_Actor("Iago", "Mrs. Bone"));
        allActors.add(new Ex2_Actor("Cassio", "Ms. Shewchuck"));
        allActors.add(new Ex2_Actor("Desdemona", "Mr.Hodgkins", true));
        allActors.add(new Ex2_Actor("Roderigo", "Ms. Lei"));

        allActors.get(1).sellTix(125);
        allActors.get(4).sellTix(76);

        String seller = "Smith";
        int sold = 50;

        int foundIndex = searchByName(allActors, seller);
        allActors.get(foundIndex).sellTix(sold);

        for (int i = 0; i < allActors.size(); i++) {
//            System.out.println(allActors.get(i));    //uses toString
//            System.out.println(allActors.get(i).role + " is played by " + allActors.get(i).name);   //direct access
            allActors.get(i).printMe();
            System.out.println();
        }

        //calculate revenue at $20 per ticket
        int totalTix = 0;
        for (int i = 0; i < allActors.size(); i++) {
            totalTix += allActors.get(i).sales;
        }
        System.out.println("We sold " + totalTix + " tickets for revenue of $" + (20*totalTix));

    }//run

    public static int searchByName(ArrayList<Ex2_Actor> list, String searchTerm){
        for (int i = 0; i < list.size(); i++) {

            if(searchTerm.equalsIgnoreCase(list.get(i).name)){
                return i;
            }

        }

        return -1;
    }//searchByName

}//Ex2_Main

