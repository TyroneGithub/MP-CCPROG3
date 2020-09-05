package phase1;

public class MagentaSpace extends Space {
    private String deckType;
    private String type;

    public MagentaSpace(String color, String path, int noOfPlayers, String type) {
        super(color, path, noOfPlayers);
        this.type = type
    }

    public String getDeckType() {
        return deckType;
    }

    public String getType() {
        return type;
    }

    public void collegeCareerChoice(Deck careerDeck, Deck salaryDeck) {

    }

}
