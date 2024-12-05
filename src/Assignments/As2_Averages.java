package Assignments;

import java.util.ArrayList;

public class As2_Averages {

//    private int[] averages;

    private ArrayList<Integer> averages = new ArrayList<>();
    private double avgPlacement;

    public As2_Averages (ArrayList<Integer> a){
        averages = a;
        double total = 0;
        for (int i = 0; i < a.size(); i++) {
            total += a.get(i);
        }
        avgPlacement = total/a.size();

    }

    public double getAvgPlacement() {
        return avgPlacement;
    }

    public ArrayList<Integer> getAverages() {
        return averages;
    }
}
