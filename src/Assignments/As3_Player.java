package Assignments;

public class As3_Player {

    private String name;
    private String playerID;
    private int numCrowns;

    public As3_Player (String n, String id, int c){
        name = n;
        playerID = id;
        numCrowns = c;
    }

    public void printMe(){
        System.out.println(name + " with player ID " + playerID + " has " + numCrowns + " crowns.");
    }

    public void addOneCrown(){
        numCrowns += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public int getNumCrowns() {
        return numCrowns;
    }

    public void setNumCrowns(int numCrowns) {
        this.numCrowns = numCrowns;
    }
}
