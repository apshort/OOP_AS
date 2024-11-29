package Assignments;

import TemplatesandLibrary.Library;
import TemplatesandLibrary.MySort;

import java.io.*;
import java.util.ArrayList;

public class As2_LeagueMain {

    public static void run(){

        ArrayList<As2_Team> allTeams= new ArrayList<>();
        loadFile("data/OOP League Teams.csv", allTeams);

        while(true) {

            System.out.println("Press 1 to print List of Teams\nPress 2 to find highest and lowest of each statistic\nPress 3 to view division\nPress 4 to sort by average placement.\nPress 5 to update stats\nPress 6 to save and exit");

            // int choice = 2;//to be removed
            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
                for (As2_Team temp: allTeams){
                    temp.printMe();
                }
            }
            if (choice == 2) {
                int highestIndex = 0;
                int highestIndex1 = 0;
                int highestIndex2 = 0;
                int lowestIndex = 0;
                int lowestIndex1 = 0;
                int lowestIndex2 = 0;
                for (int i = 0; i < allTeams.size(); i++) {
                    if (allTeams.get(i).getNumWins() > allTeams.get(highestIndex).getNumWins()){
                        highestIndex = i;
                    }
                    if (allTeams.get(i).getNumWins() < allTeams.get(lowestIndex).getNumWins()){
                        lowestIndex = i;
                    }
                    if (allTeams.get(i).getNumLasts() > allTeams.get(highestIndex1).getNumLasts()){
                        highestIndex1 = i;
                    }
                    if (allTeams.get(i).getNumLasts() < allTeams.get(lowestIndex1).getNumLasts()){
                        lowestIndex1 = i;
                    }
                    if (allTeams.get(i).getAvgPlacement() < allTeams.get(highestIndex2).getAvgPlacement()){
                        highestIndex2 = i;
                    }
                    if (allTeams.get(i).getAvgPlacement() > allTeams.get(lowestIndex2).getAvgPlacement()){
                        lowestIndex2 = i;
                    }
                }
                System.out.println("The team with the most wins is " + allTeams.get(highestIndex).getNickname() + " with " + allTeams.get(highestIndex).getNumWins() + " wins.  The team with the least wins is " + allTeams.get(lowestIndex).getNickname() + " with " + allTeams.get(lowestIndex).getNumWins() + " wins." );
                System.out.println("The team with the most last places is " + allTeams.get(highestIndex1).getNickname() + " with " + allTeams.get(highestIndex1).getNumLasts() + " last places.  The team with the least last places is " + allTeams.get(lowestIndex1).getNickname() + " with " + allTeams.get(lowestIndex1).getNumLasts() + " last places.");
                System.out.println("The team with the highest average score is " + allTeams.get(highestIndex2).getNickname() + " with an average score of " + allTeams.get(highestIndex2).getAvgPlacement() + "  The team with the lowest average score is " + allTeams.get(lowestIndex2).getNickname() + " with an average score of " + allTeams.get(lowestIndex2).getAvgPlacement());
            }
            if (choice == 3) {
                System.out.println("What division are you looking for?");
                String div = Library.input.nextLine();
                for (int i = 0; i < allTeams.size(); i++) {
                    if (allTeams.get(i).getDivision().equalsIgnoreCase(div)){
                        System.out.println(allTeams.get(i).getNickname() + " is from " + allTeams.get(i).getBiome() + ". Average score: " + allTeams.get(i).getAvgPlacement());
                    }
                }
            }
            if (choice == 4) {
                selectionSortDoubleArr(allTeams);
                System.out.println("Sorted");
            }
            if (choice == 5) {
                int[] allCoins = new int[allTeams.size()];
                for (int i = 0; i < allTeams.size(); i++) {
                    System.out.println("How many coins did the " + allTeams.get(i).getNickname() + " receive the last game?");
                    allCoins[i] = Library.input.nextInt();
                    Library.input.nextLine();
                }
//                int highestIndex = 0;
//                int lowestIndex = 0;
//                for (int i = 0; i < allCoins.length; i++) {
//                    if (allCoins[i] > allCoins[highestIndex]) {
//                        highestIndex = i;
//                    }
//                    if (allCoins[i] < allCoins[lowestIndex]){
//                        lowestIndex = i;
//                    }
//                }
//
//                System.out.println("The " + allTeams.get(highestIndex).getNickname() + " won, and the " + allTeams.get(lowestIndex).getNickname() + " got last place.");
                MySort.selectionSortIntArr(allCoins);

            }
            if (choice == 6) {
                saveFile("data/OOP League Teams.csv", allTeams);
                break;
            }
            System.out.println();

        }//while

        System.out.println("Good bye");

    }//run

    public static void loadFile(String filename, ArrayList<As2_Team> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");
//the next line is customized for whatever class you are creating.
//Here we create a new STUDENT so there are 5 variables
//Unfortunately, you need to Parse any variable that is not a String.  Integers, doubles and booleans are all demonstrated below.
                list.add( new As2_Team(  tempArray[0],(tempArray[1]), (tempArray[2]),Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]), Double.parseDouble(tempArray[5])));

            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile

    public static void saveFile(String filename, ArrayList <As2_Team> tempList ) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {
//the next lines are customized for whatever data you are getting.
                String toSave ="";
                toSave = tempList.get(i).getNickname();  //assumes getter method are used for private variables
                toSave +="," + tempList.get(i).getBiome();
                toSave += "," + tempList.get(i).getDivision();
                toSave +="," + tempList.get(i).getNumWins();
                toSave +="," + tempList.get(i).getNumLasts();
                toSave +="," + tempList.get(i).getAvgPlacement();

//The above 6 lines could be replaced by a call to a carefully made toString() function

                file.println(toSave);

            }
            file.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile

    public static void selectionSortDoubleArr(ArrayList<As2_Team> arr){
        for(int i=0; i<arr.size()-1; i++){
            int lowestIndex = i;
            for(int j=i+1; j<arr.size(); j++){
                if(arr.get(j).getAvgPlacement() < arr.get(lowestIndex).getAvgPlacement()){
                    lowestIndex = j;
                }
            }
            String temp = arr.get(i).getNickname();
            arr.get(i).setNickname(arr.get(lowestIndex).getNickname());
            arr.get(lowestIndex).setNickname(temp);

            String temp1 = arr.get(i).getBiome();
            arr.get(i).setBiome(arr.get(lowestIndex).getBiome());
            arr.get(lowestIndex).setBiome(temp1);

            String temp2 = arr.get(i).getDivision();
            arr.get(i).setDivision(arr.get(lowestIndex).getDivision());
            arr.get(lowestIndex).setDivision(temp2);

            int temp3 = arr.get(i).getNumWins();
            arr.get(i).setNumWins(arr.get(lowestIndex).getNumWins());
            arr.get(lowestIndex).setNumWins(temp3);

            int temp4 = arr.get(i).getNumLasts();
            arr.get(i).setNumLasts(arr.get(lowestIndex).getNumLasts());
            arr.get(lowestIndex).setNumLasts(temp4);

            double temp5 = arr.get(i).getAvgPlacement();
            arr.get(i).setAvgPlacement(arr.get(lowestIndex).getAvgPlacement());
            arr.get(lowestIndex).setAvgPlacement(temp5);

        }
    }

}//class
