public abstract class Card {
    private String type;

    public abstract String getDescription();

    public Card(String type) {
        this.type = type;
    }

    public String getType1() {
        return this.type;
    }

    public Card getCard() {
        return this;
    }

}