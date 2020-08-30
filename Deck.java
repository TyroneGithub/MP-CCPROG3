
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private String type;
    private ArrayList<Card> cards;
    private int numCards;
    private final int MAX;

    public Deck(String type, int max) {
        this.type = type;
        this.MAX = max;
        this.numCards = max;
        cards = new ArrayList<>(this.MAX);
        generator();
    }

    private void generator() {
        switch (this.type) {
            case "action":
                generateActionDeck();
                break;
            case "salary":
                break;
            case "career":
                generateCareerDeck();
                break;
            case "blue":
                break;
        }
    }

    public void generateActionDeck() {
        int fortyPercent = (int) (this.MAX * 0.4);
        int tenPercent = (int) (this.MAX * 0.1);
        for (int i = 0; i < fortyPercent; i++)
            this.cards.add(new ActionCardv2(1));
        for (int i = fortyPercent; i < fortyPercent * 2; i++)
            this.cards.add(new ActionCardv2(2));
        for (int i = fortyPercent * 2; i < (fortyPercent * 2) + tenPercent; i++)
            this.cards.add(new ActionCardv2(3));
        for (int i = (fortyPercent * 2) + tenPercent; i < this.MAX; i++)
            this.cards.add(new ActionCardv2(4));

    }

    public void generateCareerDeck() {
        this.cards.add(new CareerCard("Lawyer", 5, true));// pay raise [5, 8]
        this.cards.add(new CareerCard("Accountant", 5, true));// pay raise [4, 7]
        this.cards.add(new CareerCard("Computer Consultant", 5, true));// pay raise [3, 7]
        this.cards.add(new CareerCard("Doctor", 5, true));// pay raise [5, 8]
        this.cards.add(new CareerCard("Server", 1, false));// pay raise [1, 4]
        this.cards.add(new CareerCard("Racecar Driver", 2, false));// pay raise [2, 8]
        this.cards.add(new CareerCard("Athlete", 5, false));// pay raise [1, 6]
        shuffleDeck();
    }

    public void shuffleDeck() {
        Collections.shuffle(this.cards);
    }

    public String showCards() {
        System.out.println("Showing Produced  and Shuffled Cards: ");
        String text = "";
        for (int i = 0; i < this.numCards; i++) {
            // if (this.cards.get(i) instanceof ActionCardv2)
            // text += ((ActionCardv2) this.cards.get(i)).getDescription() + "\n";
            text += this.cards.get(i).getType1() + "\n";
        }
        return text;
    }

    public Card drawCard() {
        checkDeck();
        Card a = this.cards.get(this.numCards - 1);
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