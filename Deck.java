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
        int min = 1;
        int max = 4;
        int range = max - min + 1;
        for (int i = 0; i < this.MAX; i++) {
            type = (int) (Math.random() * range) + min;
            this.actionCard.add(new ActionCardv2(type));
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(this.actionCard);
    }

    public String showCards() {
        String text = "";
        for (ActionCardv2 a : actionCard) {
            text += a.getDescription() + "\n";
        }
        return text;
    }

    public ActionCardv2 drawCard() {
        ActionCardv2 a = this.actionCard.get(this.numCards - 1);
        this.numCards--;
        return a;
    }

}