package Assignments;

public class As2_Team {

    private String nickname;
    private String biome;
    private String division;
    private int numWins;
    private int numLasts;
    private double avgPlacement;

    public As2_Team (String n, String b, String d, int w, int l, double a){
        nickname = n;
        biome = b;
        division = d;
        numWins = w;
        numLasts = l;
        avgPlacement = a;

    }

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
