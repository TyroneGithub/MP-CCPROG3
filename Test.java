public class Test {
    public static void main(String[] args) {
        Deck careerDeck = new Deck("career", 7);
        CareerCard c = (CareerCard) careerDeck.drawCard();
        // System.out.println(c.getCareerName());
        System.out.println(careerDeck.showCards());
        // Card careerCard = new CareerCard("Lawyer", 5, true);
        // CareerCard c = (CareerCard) careerCard.getCard();
        // System.out.println(c.getCareerName());
    }
}