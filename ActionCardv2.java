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
                this.description = "Pay bank";
                // System.out.println("X");
                break;
            case 3: // Collect From Player
                this.description = "collect from player";
                // System.out.println("Y");
                break;
            case 4: // Pay Player
                this.description = "pay player";
                // System.out.println("Z");
                break;
        }

    }

    public String getDescription() {
        return this.description;
    }

}
