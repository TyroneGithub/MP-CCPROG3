package phase1.Spaces;

import phase1.Deck;
import phase1.Player;
import java.util.ArrayList;

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

    public void doAction(Player p, Player[] others, ArrayList<Deck> decks) {
        System.out.println("M");
    }

}
