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
        
        for (int i = 0; i < 20; i++) 
            this.actionCard.add(new ActionCardv2(1));
        for (int i = 20; i < 40; i++) 
            this.actionCard.add(new ActionCardv2(2));
        for (int i = 40; i < 45; i++) 
            this.actionCard.add(new ActionCardv2(3));
        for (int i = 45; i < 50; i++) 
            this.actionCard.add(new ActionCardv2(4));
        
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