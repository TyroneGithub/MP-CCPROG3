package phase1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * implements a Deck object that has a color, an arrayList of the action Card,
 * the current number of cards left and its maximum card per deck
 */

public class Deck {
    private String type;
    private ArrayList<ActionCard> actionCard;
    private int numCards;
    private final int MAX;

    /**
     * generates a Deck given the type and the max number of cards in it
     * 
     * @param type type of the card object which may either be <i>salary</i>,
     *             <i>career</i>, <i>action</i>, and <i>blue</i>
     * @param max  max number of cards in a deck
     */

    public Deck(String type, int max) {
        this.type = type;
        this.MAX = max;
        this.numCards = max;
        actionCard = new ArrayList<>(this.MAX);
        generateDeck();
    }

    /**
     * generates a deck of action cards which has a composition of 40% (Collect from
     * Bank) Cards, 40% (Pay Bank) Cards, 10% (Pay Player), and 10% (Collect from
     * Player) of the total number (<b>max</b>) of cards specified.
     * 
     */

    public void generateDeck() {
        int type;
        int fortyPercent = (int) (this.MAX * 0.4);
        int tenPercent = (int) (this.MAX * 0.1);
        for (int i = 0; i < fortyPercent; i++)
            this.actionCard.add(new ActionCard(1));
        for (int i = fortyPercent; i < fortyPercent * 2; i++)
            this.actionCard.add(new ActionCard(2));
        for (int i = fortyPercent * 2; i < (fortyPercent * 2) + tenPercent; i++)
            this.actionCard.add(new ActionCard(3));
        for (int i = (fortyPercent * 2) + tenPercent; i < this.MAX; i++)
            this.actionCard.add(new ActionCard(4));

    }

    /**
     * shuffles the deck generated
     * 
     */

    public void shuffleDeck() {
        Collections.shuffle(this.actionCard);
    }

    /**
     * prints the number of cards in order (from bottom of the stack to its top)
     * which is used for debugging the program specifically, when the user draws.
     * 
     * returns the appended/ concatenated list of cards
     * 
     * @return String of appended description of the cards.
     */

    public String showCards() {
        System.out.println("Showing Produced  and Shuffled Cards: ");
        String text = "";
        for (int i = 0; i < this.numCards; i++) {
            text += this.actionCard.get(i).getDescription() + "\n";
        }
        return text;
    }

    /**
     * draws a card from the deck which also decrements the current number of cards
     * 
     * returns the action card drawn
     * 
     * @return ActionCard
     */

    public ActionCard drawCard() {
        checkDeck();
        ActionCard a = this.actionCard.get(this.numCards - 1);
        this.numCards--;
        return a;
    }

    /**
     * helper function that checks the deck whenever a player draws. It calls the
     * shuffleDeck() method when current number of cards is 0.
     * 
     */
    private void checkDeck() {
        if (this.numCards == 0) {
            System.out.println("Deck is empty! Refilling and shuffling deck...\n\n\n");
            this.numCards = this.MAX;
            shuffleDeck();
        }
    }

}