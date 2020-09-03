import phase1.*;

public class Test {
    public static void main(String[] args){
        Deck d = new Deck("Action Card", 10);
        d.shuffleDeck();
        System.out.println(d.showCards());
    }
}
