import java.util.Scanner;

public class Player {
    private String name;
    private double cash;
    private ActionCardv2 drawnCard;
    private boolean isRetired;

    public Player(String name) {
        this.name = name;
        this.cash = 20000;
    }

    public String getName() {
        return this.name;
    }

    public double getCash() {
        return this.cash;
    }

    public void updateCash(double cash) {
        this.cash += cash;
    }

    public boolean getIsRetired() {
        return this.isRetired;
    }

    public void setToRetire(boolean isRetired) {
        this.isRetired = isRetired;
    }

    public void drawCard(Deck deck, Player[] otherPlayers) {

        int i = 0, playerChosen = 0, currPlayerIndex = 0;
        Scanner scanner = new Scanner(System.in);
        this.drawnCard = deck.drawCard();
        System.out.println("Draws: " + this.drawnCard.getDescription() + " TYPE: " + this.drawnCard.getType()
                + " Value: $" + this.drawnCard.getValue());
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

    @Override
    public boolean equals(Object obj) {
        Player anotherPlayer = (Player) obj;
        return anotherPlayer.getName().equals(this.name) && anotherPlayer.getCash() == this.cash;
    }

}