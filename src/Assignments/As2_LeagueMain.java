package Assignments;

import TemplatesandLibrary.Library;
import TemplatesandLibrary.MySort;

import java.io.*;
import java.util.ArrayList;

public class As2_LeagueMain {

    public static void run(){

        //I DID SOMETHING UNNECESSARILY COMPLICATED WITH THE AVERAGES LOL

        ArrayList<As2_Team> allTeams= new ArrayList<>();
//        ArrayList<Integer> allAvgs = loadIntegerList("data/Teams Averages.csv");
        loadFile("data/OOP League Teams.csv", allTeams);
        ArrayList<As2_Averages> allAverages = new ArrayList<>();
        loadFileAvg("data/Teams Averages.csv", allAverages);
//        int[] arr = {1, 2, 3};
//        allAverages.add(new As2_Averages(arr));
//        System.out.println(allAverages.get(0).getAvgPlacement());


//        if (Library.input.nextLine().equalsIgnoreCase("yes")){
//            saveFileAvg("data/Teams Averages.csv", allAverages);
//        }

        allTeams.get(0).addPlayer("Phil", "Ph1LzA", 4);
        allTeams.get(0).addPlayer("Shelby", "Shubble", 4);
        allTeams.get(0).addPlayer("Alex", "Quackity", 1);
        allTeams.get(0).addPlayer("Toby", "Tubbo_", 1);
        allTeams.get(0).addPlayer("Mark", "Ranboo", 1);

        allTeams.get(1).addPlayer("Jack", "JackManifoldTV", 0);
        allTeams.get(1).addPlayer("Tom", "TommyInnit", 3);

        allTeams.get(2).addPlayer("Alex", "Technoblade", 2);
        allTeams.get(2).addPlayer("Bek", "bekyamon", 1);

        allTeams.get(3).addPlayer("Aimee", "aimsey", 2);
        allTeams.get(3).addPlayer("Saoirse", "guqqie", 1);

        allTeams.get(4).addPlayer("Michaela", "DarkEyebrows", 0);
        allTeams.get(4).addPlayer("Elaina", "ElainaExe", 2);

        allTeams.get(5).addPlayer("Callum", "Seapeekay", 4);
        allTeams.get(5).addPlayer("Brendan", "Sneegsnag", 3);

        allTeams.get(6).addPlayer("Jordan", "CaptainSparklez", 4);
        allTeams.get(6).addPlayer("Frank", "fruitberries", 4);

        allTeams.get(7).addPlayer("Scott", "Smajor1995", 7);
        allTeams.get(7).addPlayer("Cassie", "Snifferish", 2);

        allTeams.get(8).addPlayer("Sam", "GoodTimesWithScar", 2);
        allTeams.get(8).addPlayer("Taylor", "GeminiTay", 2);

        allTeams.get(9).addPlayer("Grayson", "Purpled", 1);
        allTeams.get(9).addPlayer("Harvey", "TapL", 1);

        while(true) {

            System.out.println("Press 1 to print List of Teams\nPress 2 to find highest and lowest of each statistic\nPress 3 to view division\nPress 4 to sort by average placement.\nPress 5 to update stats\nPress 6 to print players \nPress 7 to see each team's total crowns \nPress 8 to update a player's stats \nPress 9 to save and exit");

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
//                int[] allCoins = new int[allTeams.size()];
                for (int i = 0; i < allTeams.size(); i++) {
                    System.out.println("What place did the " + allTeams.get(i).getNickname() + " achieve the last game?");
                    int place = Library.input.nextInt();
                    Library.input.nextLine();
                    allAverages.get(i).getAverages().add(place);
                    allTeams.get(i).setAvgPlacement(allAverages.get(i).average());
                    if (place == 1){
                        allTeams.get(i).setNumWins(allTeams.get(i).getNumWins()+1);
                    }
                    else if (place == 10){
                        allTeams.get(i).setNumLasts(allTeams.get(i).getNumLasts()+1);
                    }

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
//                while(findHighest(allCoins)!== -1){
//
//                }
//
//                System.out.println("The " + allTeams.get(highestIndex).getNickname() + " won, and the " + allTeams.get(lowestIndex).getNickname() + " got last place.");
//                MySort.selectionSortIntArr(allCoins);

            }
            if (choice == 6){
                System.out.println("What team's players do you want to print?");
                String team = Library.input.nextLine();
                for (int i = 0; i < allTeams.size(); i++) {
                    if (allTeams.get(i).getNickname().equalsIgnoreCase(team)){
                        allTeams.get(i).printMyPlayers();
                    }
                }
            }
            if (choice == 7){
                for(As2_Team team : allTeams){
                    System.out.println("Team " + team.getNickname() + " has " + team.totalCrowns() + " total crowns.");
                }
            }
            if (choice == 8){
                System.out.println("What player's stats do you want to update? (type in their player ID)");
                String player = Library.input.nextLine();
                for (int i = 0; i < allTeams.size(); i++) {
                    int foundIndex = allTeams.get(i).searchByName(allTeams.get(i).getAllPlayers(), player);
                    if(foundIndex != -1) {
                        allTeams.get(i).getAllPlayers().get(foundIndex).addOneCrown();
                    }
                }
            }
            if (choice == 9) {
                saveFile("data/OOP League Teams.csv", allTeams);
                saveFileAvg("data/Teams Averages.csv", allAverages);
                break;
            }
            System.out.println();

        }//while

        System.out.println("Good bye");

    }//run

    public static int findHighest(int[] arr){
        int highestIndex = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] > arr[highestIndex]) {
                        highestIndex = i;
                    }
                }
                if (highestIndex == 0 && arr[0] == -1){
                    return -1;
                }
                return highestIndex;
    }

    public static double average(int[] arr){
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total/arr.length;
    }

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

    public static void loadFileAvg(String filename, ArrayList<As2_Averages> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String[] tempArray = dataToRead.split(",");
                ArrayList<Integer> arrayInt = new ArrayList<>();
                for (int i = 0; i < tempArray.length; i++) {
                    arrayInt.add(Integer.parseInt(tempArray[i]));
                }
//the next line is customized for whatever class you are creating.
//Here we create a new STUDENT so there are 5 variables
//Unfortunately, you need to Parse any variable that is not a String.  Integers, doubles and booleans are all demonstrated below.
                list.add( new As2_Averages(arrayInt));

            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile

//    public static ArrayList<Integer> loadIntegerList (String filename){
//        ArrayList<Integer> temp = new ArrayList();
//        try {
//            BufferedReader file = new BufferedReader(new FileReader(filename));
//            while (file.ready()) {
//                String addLines = file.readLine();
//                temp.add(Integer.parseInt(addLines));
//
//            }//end while
//            file.close();
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//        return temp;
//    }//end loadStringList from a text file


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

    public static void saveFileAvg(String filename, ArrayList <As2_Averages> tempList) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {
//the next lines are customized for whatever data you are getting.
                String toSave ="";
                toSave += tempList.get(i).getAverages().get(0);
                for (int j = 1; j < tempList.get(i).getAverages().size(); j++) {
                    toSave += "," + tempList.get(i).getAverages().get(j);
                }
                  //assumes getter method are used for private variables
//                toSave +="," + tempList.get(i).getAvgPlacement();

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

            As2_Team tempTeam = arr.get(i);
            arr.set(i, arr.get(lowestIndex));
            arr.set(lowestIndex, tempTeam);

//            String temp = arr.get(i).getNickname();
//            arr.get(i).setNickname(arr.get(lowestIndex).getNickname());
//            arr.get(lowestIndex).setNickname(temp);
//
//            String temp1 = arr.get(i).getBiome();
//            arr.get(i).setBiome(arr.get(lowestIndex).getBiome());
//            arr.get(lowestIndex).setBiome(temp1);
//
//            String temp2 = arr.get(i).getDivision();
//            arr.get(i).setDivision(arr.get(lowestIndex).getDivision());
//            arr.get(lowestIndex).setDivision(temp2);
//
//            int temp3 = arr.get(i).getNumWins();
//            arr.get(i).setNumWins(arr.get(lowestIndex).getNumWins());
//            arr.get(lowestIndex).setNumWins(temp3);
//
//            int temp4 = arr.get(i).getNumLasts();
//            arr.get(i).setNumLasts(arr.get(lowestIndex).getNumLasts());
//            arr.get(lowestIndex).setNumLasts(temp4);
//
//            double temp5 = arr.get(i).getAvgPlacement();
//            arr.get(i).setAvgPlacement(arr.get(lowestIndex).getAvgPlacement());
//            arr.get(lowestIndex).setAvgPlacement(temp5);

        }
    }

}//class
