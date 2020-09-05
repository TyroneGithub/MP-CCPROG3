package phase1;

public class BlueSpace extends Space {
    private String deckType;

    public BlueSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.deckType = "Blue";
    }

    public String getDeckType() {
        return deckType;
    }

}
