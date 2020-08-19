public class ActionCardv2 {
    private String description;
    private boolean toAll;
    private double value;

    public ActionCardv2(int type) {
        String[] description;

        switch (type) {
            case 1: // Collect From Bank
                description = new String[] { "Tax Refund", "Sell an Item", "Bonus Payday", "Setup School",
                        "Write a Book" };
                this.description = description[(int) (Math.random() * description.length)];
                this.value = 1000 * ((int) (Math.random() * (100 - 1 + 1) * 1)); // multiply 1000 to a number (1-100)
                break;
            case 2: // Pay Bank
                description = new String[] { "Buy an Item", "Visit a place", "Hiking", "Watch a show",
                        "Win a competition", "Traffic violation"};
                this.description = description[(int) (Math.random() * description.length)];
                this.value = 1000 * ((int) (Math.random() * (100 - 1 + 1) * 1)); // multiply 1000 to a number (1-100)
                break;
            case 3: // Collect From Player
                description = new String[] { "File a Lawsuit", "It's your Birthday"};
                this.description = description[(int) (Math.random() * description.length)];
                if(this.description.equals(description[1]))
                    toAll = true;
                    
                this.value = 1000 * ((int) (Math.random() * (100 - 1 + 1) * 1)); // multiply 1000 to a number (1-100)
                break;
            case 4: // Pay Player
                description = new String[] { "File a Lawsuit", "It's your Birthday"};
                this.description = description[(int) (Math.random() * description.length)];
                if(this.description.equals(description[1]))
                    toAll = true;

                this.value = 1000 * ((int) (Math.random() * (100 - 1 + 1) * 1)); // multiply 1000 to a number (1-100)
                break;
        }

    }

    public String getDescription() {
        return this.description;
    }

}
