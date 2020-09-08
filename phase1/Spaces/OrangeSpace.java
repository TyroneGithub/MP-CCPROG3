package phase1.Spaces;

import phase1.Player;
import phase1.Deck;
import java.util.ArrayList;

public class OrangeSpace extends Space {
    private String deckType;

    public OrangeSpace(String path, int noOfPlayers) {
        super(path, noOfPlayers);
        this.deckType = "Action";
    }

    public String getDeckType() {
        return deckType;
    }

    public void doAction(Player p, Player[] others, ArrayList<Deck> actionDeck) {
        System.out.println("O");
    }

}
