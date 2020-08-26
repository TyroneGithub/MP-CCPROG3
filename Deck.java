import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private String color;
    private ArrayList<ActionCardv2> actionCard;
    private int numCards;
    private final int MAX;

    public Deck(String color, int max) {
        this.color = color;
        this.MAX = max;
        this.numCards = max;
        actionCard = new ArrayList<>(this.MAX);
    }

    public void generateDeck() {
        int type;
        int fortyPercent = (int) (this.MAX * 0.4);
        int tenPercent = (int) (this.MAX * 0.1);
        for (int i = 0; i < fortyPercent; i++)
            this.actionCard.add(new ActionCardv2(1));
        for (int i = fortyPercent; i < fortyPercent * 2; i++)
            this.actionCard.add(new ActionCardv2(2));
        for (int i = fortyPercent * 2; i < (fortyPercent * 2) + tenPercent; i++)
            this.actionCard.add(new ActionCardv2(3));
        for (int i = (fortyPercent * 2) + tenPercent; i < this.MAX; i++)
            this.actionCard.add(new ActionCardv2(4));

    }

    public void shuffleDeck() {
        Collections.shuffle(this.actionCard);
    }

    public String showCards() {
        System.out.println("Showing Produced  and Shuffled Cards: ");
        String text = "";
        for (int i = 0; i < this.numCards; i++) {
            text += this.actionCard.get(i).getDescription() + "\n";
        }
        return text;
    }

    public ActionCardv2 drawCard() {
        checkDeck();
        ActionCardv2 a = this.actionCard.get(this.numCards - 1);
        this.numCards--;
        return a;
    }

    private void checkDeck() {
        if (this.numCards == 0) {
            System.out.println("Deck is empty! Refilling and shuffling deck...\n\n\n");
            this.numCards = this.MAX;
            shuffleDeck();
        }
    }

}