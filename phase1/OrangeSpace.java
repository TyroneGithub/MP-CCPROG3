package phase1;

public class OrangeSpace extends Space {
    private String deckType;

    public OrangeSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.deckType = "Action";
    }

    public String getDeckType() {
        return deckType;
    }

}
