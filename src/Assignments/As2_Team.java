package Assignments;

import java.util.ArrayList;

public class As2_Team {

    private String nickname;
    private String biome;
    private String division;
    private int numWins;
    private int numLasts;
    private double avgPlacement;

    private ArrayList<As3_Player> allPlayers = new ArrayList<>();


    public As2_Team (String n, String b, String d, int w, int l, double a){
        nickname = n;
        biome = b;
        division = d;
        numWins = w;
        numLasts = l;
        avgPlacement = a;

    }

    public void addPlayer(String n, String id, int c){
        allPlayers.add(new As3_Player(n, id, c));
    }

    public void printMyPlayers(){
        for (As3_Player temp: allPlayers){
            temp.printMe();
        }
    }

    public int totalCrowns(){
        int total = 0;
        for (int i = 0; i < allPlayers.size(); i++) {
            total += allPlayers.get(i).getNumCrowns();
        }
        return total;
    }

    public int searchByName(ArrayList<As3_Player> list, String searchTerm){
        for (int i = 0; i < list.size(); i++) {

            if(searchTerm.equalsIgnoreCase(list.get(i).getPlayerID())){
                return i;
            }

        }

        return -1;
    }//searchByName

    public String getNickname() {
        return nickname;
    }

    public String getBiome() {
        return biome;
    }

    public String getDivision() {
        return division;
    }

    public int getNumWins() {
        return numWins;
    }

    public int getNumLasts() {
        return numLasts;
    }

    public double getAvgPlacement() {
        return avgPlacement;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBiome(String biome) {
        this.biome = biome;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public void setNumWins(int numWins) {
        this.numWins = numWins;
    }

    public void setNumLasts(int numLasts) {
        this.numLasts = numLasts;
    }

    public void setAvgPlacement(double avgPlacement) {
        this.avgPlacement = avgPlacement;
    }

    public void printMe(){
        System.out.println("The " + nickname + " from the biome " + biome + " in the division " + division + " has " + numWins + " wins, " + numLasts + " last places and their average placement is " + avgPlacement );
    }

    public ArrayList<As3_Player> getAllPlayers() {
        return allPlayers;
    }

    public void setAllPlayers(ArrayList<As3_Player> allPlayers) {
        this.allPlayers = allPlayers;
    }

//    public void printMe() {
//        System.out.println( "As2_Team{" +
//                "nickname='" + nickname + '\'' +
//                ", biome='" + biome + '\'' +
//                ", division='" + division + '\'' +
//                ", numWins=" + numWins +
//                ", numLasts=" + numLasts +
//                ", avgPlacement=" + avgPlacement +
//                '}');
//    }
}
