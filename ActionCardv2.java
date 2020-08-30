import java.lang.Math;

public class ActionCardv2 extends Card {
    private String description;
    private boolean toAll;
    private double value;
    private int type;

    public ActionCardv2(int type) {
        super("Action");
        String[] description;
        this.type = type;
        this.value = 100 * ((int) (Math.random() * 100)); // multiply 100 to a number (1-100)
        switch (type) {
            case 1: // Collect From Bank
                description = new String[] { "Tax Refund", "Sell an Item", "Bonus Payday", "Setup School",
                        "Write a Book" };
                this.description = description[(int) (Math.random() * description.length)];

                break;
            case 2: // Pay Bank
                description = new String[] { "Buy an Item", "Visit a place", "Hiking", "Watch a show",
                        "Win a competition", "Traffic violation" };
                this.description = description[(int) (Math.random() * description.length)];
                break;
            case 3: // Collect From Player
                description = new String[] { "File a Lawsuit", "It's your Birthday" };
                this.description = description[(int) (Math.random() * description.length)];
                if (this.description.equals(description[1]))
                    toAll = true;

                break;
            case 4: // Pay Player
                description = new String[] { "Lawsuit", "Christmas Bonus" };
                this.description = description[(int) (Math.random() * description.length)];
                if (this.description.equals(description[1]))
                    toAll = true;

                break;
        }

    }

    public String getDescription() {
        return this.description;
    }

    public double getValue() {
        return this.value;
    }

    public int getType() {
        return this.type;
    }

    public boolean getToAll() {
        return this.toAll;
    }

}
