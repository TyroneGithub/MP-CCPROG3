package phase1;

public class BlueSpace extends Space {
    private String deckType;

    public BlueSpace(String color, String path, int noOfPlayers) {
        super(color, path, noOfPlayers);
        this.deckType = "Blue";
    }

    public String getDeckType() {
        return deckType;
    }

}
