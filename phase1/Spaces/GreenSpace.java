package phase1.Spaces;

import phase1.Player;
import phase1.Deck;
import java.util.ArrayList;

public class GreenSpace extends Space {
    private String type;

    public GreenSpace(String path, int noOfPlayers, String type) {
        super(path, noOfPlayers);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void doAction(Player p, Player[] others, ArrayList<Deck> actionDeck) {
        System.out.println("G");
    }
}
