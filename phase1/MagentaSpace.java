package phase1;

public class MagentaSpace extends Space {
    private String deckType;
    private String type;

    public MagentaSpace(String path, int noOfPlayers, String type) {
        super(path, noOfPlayers);
        this.type = type;
    }

    public String getDeckType() {
        return deckType;
    }

    public String getType() {
        return type;
    }

    public void collegeCareerChoice(Deck careerDeck, Deck salaryDeck) {
        this.getPlayers().get(this.getPlayers().size() - 1).drawCard(careerDeck);
        this.getPlayers().get(this.getPlayers().size() - 1).drawCard(salaryDeck);

    }

}
