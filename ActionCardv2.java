/**
 * implements an Action Card that has a description a cash value and a type. It
 * also has a boolean toAll which sets whether the cash value will be
 * distributed to all.
 */

public class ActionCardv2 {
    private String description;
    private boolean toAll;
    private double value;
    private int type;

    /**
     * Creates an action card object with the specified type
     * 
     * @param type type will either be 1 (collect from the bank), 2 (pay the bank),
     *             3 (Collect from the player), or 4 (pay player).
     */
    public ActionCardv2(int type) {
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

    /**
     * returns the description of the action card
     * 
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * returns the cash value of the action card
     * 
     * @return value
     */

    public double getValue() {
        return this.value;
    }

    /**
     * returns the type of the action card
     * 
     * @return type
     */

    public int getType() {
        return this.type;
    }

    /**
     * returns whether the boolean toAll of the action card
     * 
     * @return toAll
     */

    public boolean getToAll() {
        return this.toAll;
    }

}
