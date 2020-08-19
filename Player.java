public class Player {
    private String name;
    private double cash;
    private ActionCardv2 drawnCard;
    private boolean isRetired;
    public Player(String name) {
        this.name = name;
    }

    public void drawCard(Deck deck) {
        drawnCard = deck.drawCard();
    }

    public String getDrawnCard() {
        return this.drawnCard.getDescription();
    }

    public String getName(){
        return this.name;
    }

    public boolean getIsRetired(){
        return this.isRetired;
    }

}