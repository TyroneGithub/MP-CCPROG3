package phase1;

public class OrangeSpace extends Space {
    private String deckType;

    public OrangeSpace(String color, String path, int noOfPlayers) {
        super(color, path, noOfPlayers);
        this.deckType = "Action";
    }

    public String getDeckType() {
        return deckType;
    }

}
