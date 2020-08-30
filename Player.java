import java.util.Scanner;

public class Player {
    private String name;
    private double cash;
    private ActionCardv2 drawnCard;
    private boolean isRetired;
    private CareerCard career;

    Scanner scanner = new Scanner(System.in);

    /**
     * Initializes the player object with the given career. The starting cash value
     * is 20000.
     * 
     * @param career career card picked by the player
     */
    public Player(CareerCard career) {
        do {
            if (this.name != null)
                System.out.print("Enter valid name: ");
            this.name = scanner.nextLine();
        } while (!nameValid(this.name));

        this.career = career;
        this.cash = 20000;

    }

    /**
     * Initializes the player object with the given name. The starting cash value is
     * 20000. The default career given will be a racecar driver.
     * 
     * @param name name of the player
     */

    public Player() {
        do {
            if (this.name != null)
                System.out.print("Enter valid name: ");
            name = scanner.nextLine();
        } while (!nameValid(this.name));

        this.career = new CareerCard("Racecar Driver", 5, false);
        this.cash = 20000;
    }

    /**
     * Returns the player's name
     * 
     * @return the player's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the player's current cash
     * 
     * @return the player's current cash
     */
    public double getCash() {
        return this.cash;
    }

    /**
     * Updates the cash of the player given a value.
     * 
     * @param cash
     */
    public void updateCash(double cash) {
        this.cash += cash;
    }

    /**
     * Returns true if the player is retired, false if not.
     * 
     * @return true if the player is retired, false if not.
     */
    public boolean getIsRetired() {
        return this.isRetired;
    }

    /**
     * Sets the retirement status of the player to true or false.
     * 
     * @param isRetired
     */
    public void setToRetire(boolean isRetired) {
        this.isRetired = isRetired;
    }

    /**
     * Player draws a card from the given deck.
     * 
     * 
     * 
     * @param deck         chosen deck of cards
     * @param otherPlayers array of other players
     */
    public void drawCard(Deck deck, Player[] otherPlayers) {

        int i = 0, playerChosen = 0, currPlayerIndex = 0;
        this.drawnCard = deck.drawCard();
        System.out.println("Draws: " + this.drawnCard.getDescription() + "\nType: " + this.drawnCard.getTypeToString()
                + "\nValue: $" + this.drawnCard.getValue());
        // Update State/
        switch (this.drawnCard.getType()) {
            case 1: // +
                updateCash(this.drawnCard.getValue());
                break;

            case 2: // -
                updateCash(-this.drawnCard.getValue());
                break;
            case 3: // +
                if (this.drawnCard.getToAll()) {
                    for (Player p : otherPlayers) {
                        if (!equals(p)) {
                            p.updateCash(-this.drawnCard.getValue());
                            updateCash(this.drawnCard.getValue());
                        }
                    }
                } else {
                    System.out.println("Choose a player");
                    for (Player p : otherPlayers) {
                        i++;
                        if (!equals(p))
                            System.out.printf("[%d] - Player %d\n", i, i);
                        else
                            currPlayerIndex = i;
                    }

                    do {
                        System.out.print("Enter : ");
                        playerChosen = Integer.parseInt(scanner.nextLine());
                    } while (playerChosen == currPlayerIndex || playerChosen < 1 && playerChosen > i);

                    Player p = otherPlayers[playerChosen - 1];
                    p.updateCash(-this.drawnCard.getValue());
                    updateCash(this.drawnCard.getValue());

                }
                break;
            case 4: // -
                if (this.drawnCard.getToAll()) {
                    for (Player p : otherPlayers) {
                        if (!equals(p)) {
                            p.updateCash(-this.drawnCard.getValue());
                            updateCash(this.drawnCard.getValue());
                        }
                    }
                } else {
                    System.out.println("Choose a player");

                    for (Player p : otherPlayers) {
                        i++;
                        if (!equals(p))
                            System.out.printf("[%d] - Player %d\n", i, i);
                        else
                            currPlayerIndex = i;
                    }

                    do {
                        System.out.print("Enter : ");
                        playerChosen = Integer.parseInt(scanner.nextLine());
                    } while (playerChosen == currPlayerIndex || playerChosen < 1 && playerChosen > i);

                    Player p = otherPlayers[playerChosen - 1];
                    p.updateCash(-this.drawnCard.getValue());
                    updateCash(this.drawnCard.getValue());

                }
                break;

        }

    }

    /**
     * Checks if the user input is valid. The user input will only be valid if it
     * contains at least one alphanumeric character and if the String doesn't
     * contain all whitespaces.
     * 
     * @param name
     * @return true if name is valid; false otherwise
     */

    private boolean nameValid(String name) {
        boolean checkWhiteSpaceOnly = name.trim().isEmpty();
        boolean checkAlphaNumeric = name != null && name.matches("^[a-zA-Z0-9]*$");
        return !checkWhiteSpaceOnly && checkAlphaNumeric;
    }

    /**
     * Compares two player objects and returns true if their name and amount of cash
     * are equal, false if not.
     * 
     * @return true if their name and amount of cash are equal, false if not.
     */
    @Override
    public boolean equals(Object obj) {
        Player anotherPlayer = (Player) obj;
        return anotherPlayer.getName().equals(this.name) && anotherPlayer.getCash() == this.cash;
    }

}