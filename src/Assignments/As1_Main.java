package Assignments;

import Examples.Ex3_Client;
import TemplatesandLibrary.Library;

import java.util.ArrayList;

import java.io.*;

public class As1_Main {

    public static void run(){

        ArrayList<As1_Crop> allCrops = new ArrayList<>();
        loadFile("data/Crop Management.csv", allCrops);

        //https://data.ontario.ca/dataset/3d652a80-7936-4d0b-9454-52a22eaddb09/resource/02daebd7-a430-4220-83fa-7e7afc3d5efa/download/estimate_new.xlsx (2022 grains and oilseeds)
//        allCrops.add(new As1_Crop("oats",   93.1, "bushels",  5.98)  );
//        allCrops.add(new As1_Crop("barley",    75.6, "bushels",   7.52)  );
//        allCrops.add(new As1_Crop("canola",      50.9, "bushels",     18.14)  );
//        allCrops.add(new As1_Crop("grain corn",     166.0, "bushels",    8.13)  );
//        allCrops.add(new As1_Crop("soybeans",     48.0, "bushels",    18.93)  );

        allCrops.get(0).setAcres(140);
        allCrops.get(1).setAcres(118);
        allCrops.get(2).setAcres(106);
        allCrops.get(3).setAcres(278);
        allCrops.get(4).setAcres(358);

        for (int i = 0; i < allCrops.size(); i++) {
            System.out.println(allCrops.get(i));
        }

        double totalRevenue = 0;

        while(true) {

            System.out.println("1. Print farm summary\n2. Search & harvest a crop\n3. Get total revenue\n4. Plant a crop\n5. Save and Exit");

            // int choice = 2;//to be removed
            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
                for (int i = 0; i < allCrops.size(); i++) {
                    allCrops.get(i).printMe();
                }
            }
            if (choice == 2) {
                System.out.println("What crop do you want to find?");
                String name = Library.input.nextLine();
                int foundIndex = searchByName(allCrops, name);
                if (foundIndex == -1){
                    System.out.println("Not found");
                }
                else {
                    allCrops.get(foundIndex).printMe();
                    System.out.println("Do you want to harvest the crop?");
                    if (Library.input.nextLine().startsWith("y")){
                        totalRevenue += allCrops.get(foundIndex).harvest();
                    }
                }
            }
            if (choice == 3) {
                System.out.println("Total revenue from all harvested crops:  $" + totalRevenue);
            }
            if (choice == 4){
                System.out.println("What crop do you want to plant?");
                String n = Library.input.nextLine();
                System.out.println("How many acres of this crop do you want to plant?");
                int a = Library.input.nextInt();
                Library.input.nextLine();
                int fIndex = searchByName(allCrops, n);
                if (fIndex == -1){
                    System.out.println("What units?");
                    String newUnits = Library.input.nextLine();
                    System.out.println("What does this new crop yield? (given units/acre");
                    double newYield = Library.input.nextDouble();
                    Library.input.nextLine();
                    System.out.println("What is the price of this new crop per given unit?");
                    double newPrice = Library.input.nextDouble();
                    Library.input.nextLine();
                    allCrops.add(new As1_Crop(n,     newYield, newUnits,    newPrice)  );
                    allCrops.get(allCrops.size()-1).setAcres(a);
                }
                else {
                    allCrops.get(fIndex).addAcres(a);
                }
            }
            if (choice == 5) {
                saveFile("data/Crop Management.csv", allCrops);
                break;
            }
            System.out.println();

        }//while

        System.out.println("Good bye");

    }//run

    public static int searchByName(ArrayList<As1_Crop> list, String searchTerm){
        for (int i = 0; i < list.size(); i++) {

            if(searchTerm.equalsIgnoreCase(list.get(i).getName())){
                return i;
            }

        }

        return -1;
    }//searchByName

    public static void loadFile(String filename, ArrayList<As1_Crop> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");
//the next line is customized for whatever class you are creating.
//Here we create a new STUDENT so there are 5 variables
//Unfortunately, you need to Parse any variable that is not a String.  Integers, doubles and booleans are all demonstrated below.
                list.add( new As1_Crop(  tempArray[0],Double.parseDouble(tempArray[1]), (tempArray[2]),Double.parseDouble(tempArray[3]), Integer.parseInt(tempArray[4])));

            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile

    public static void saveFile(String filename, ArrayList <As1_Crop> tempList ) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {
//the next lines are customized for whatever data you are getting.
                String toSave ="";
                toSave = tempList.get(i).getName();  //assumes getter method are used for private variables
                toSave +="," + tempList.get(i).getYield();
                toSave += "," + tempList.get(i).getUnits();
                toSave +="," + tempList.get(i).getPrice();
                toSave +="," + tempList.get(i).getAcres();

//The above 6 lines could be replaced by a call to a carefully made toString() function

                file.println(toSave);

            }
            file.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile



}//class
