package Assignments;

import Examples.Ex3_Client;

import java.util.ArrayList;

public class As1_Main {

    public static void run(){

        ArrayList<As1_Crop> allCrops = new ArrayList<>();

        //https://data.ontario.ca/dataset/3d652a80-7936-4d0b-9454-52a22eaddb09/resource/02daebd7-a430-4220-83fa-7e7afc3d5efa/download/estimate_new.xlsx (2022 grains and oilseeds)
        allCrops.add(new As1_Crop("Oats",   93.1, "bushels",  5.98)  );
        allCrops.add(new As1_Crop("Barley",    75.6, "bushels",   7.52)  );
        allCrops.add(new As1_Crop("Canola",      50.9, "bushels",     18.14)  );
        allCrops.add(new As1_Crop("Grain Corn",     166.0, "bushels",    8.13)  );
        allCrops.add(new As1_Crop("Soybeans",     48.0, "bushels",    18.93)  );

        allCrops.get(0).setAcres(140);
        allCrops.get(1).setAcres(118);
        allCrops.get(2).setAcres(106);
        allCrops.get(3).setAcres(278);
        allCrops.get(4).setAcres(358);

        for (int i = 0; i < allCrops.size(); i++) {
            System.out.println(allCrops.get(i));
        }

    }

}
