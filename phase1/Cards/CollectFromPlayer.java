package phase1.Cards;

import phase1.Player;

public class CollectFromPlayer extends ActionCard {

    public CollectFromPlayer(String description, boolean toAll) {
        super(description, toAll);
    }

    // @Override
    public void activate(Player p) {

        System.out.println("collected from player");
    }

}
