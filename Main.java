import java.util.*;

public class Main {
    public static void main(String[] args) {

        Deck actionDeck = new Deck("orange", 50);
        Player p = new Player("Tyrone");

        actionDeck.generateDeck();
        actionDeck.shuffleDeck();

        System.out.println(actionDeck.showCards());
        p.drawCard(actionDeck);

        System.out.println(p.getDrawnCard());

        // ActionCardv1[] actionCards = new ActionCardv1[50];

        // // generate 20 cards
        // for (int i = 0; i < 20; i++) {
        // actionCards[i] = new ActionCardv1(true);
        // }

        // for (int i = 0; i < 20; i++) {
        // System.out.println(actionCards[i].toString());
        // }

    }
}
