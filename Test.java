import phase1.*;

public class Test {
    public static void main(String[] args) {
        Deck d = new Deck("Action", 50);
        Player p = new Player();
        p.drawCard(d);
        System.out.println(p.toString());
        // Card d = new CollectFromBank("h", false);
        // ActionCard a = (ActionCard) d;
        // a.activate();

    }
}
