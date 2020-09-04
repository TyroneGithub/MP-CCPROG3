import java.util.*;

public class Game {
    Scanner scanner = new Scanner(System.in);
    private Player[] players;
    private int NUM_PLAYERS;
    private Deck actionDeck;
    private Space spaces[];

    /**
     * Creates a game object that initalizes all decks and adds players to the game.
     * 
     * Number of players may be 2 to 3. For invalid values for number of players
     * provided, 2 will be used.
     * 
     * 
     * @param NUM_PLAYERS number of players; 2 will be used if invalid
     */
    public Game(int NUM_PLAYERS) {
        this.NUM_PLAYERS = checkPlayerNumber(NUM_PLAYERS);
        this.players = new Player[this.NUM_PLAYERS];

        for (int i = 0; i < NUM_PLAYERS; i++) {
            System.out.println("Enter Player " + (i + 1) + " name: ");
            players[i] = new Player(scanner.nextLine());
        }

        this.actionDeck = new Deck("action", 10);
        // actionDeck.generateDeck();
        actionDeck.shuffleDeck();

        this.spaces = new Space[100];
        generateSpaces();
    }

    public void generateSpaces() {
        for (int i = 0; i < 100; i++) {
            this.spaces[i] = new Space("orange", "dating daan", this.NUM_PLAYERS);
            if (i == 0) {
                for (int j = 0; j < NUM_PLAYERS; j++)
                    this.spaces[i].getPlayers().add(players[j]);
            }
        }
    }

    private int spinWheel() {
        return (int) (Math.random() * (12 - 1 + 1) + 1);
    }

    public void move(Player p) {
        int moveCnt = spinWheel();
        System.out.println("Moving Player " + p.getName() + " to +" + moveCnt + " steps");
        for (; moveCnt > 0; moveCnt--) {
            this.spaces[p.getSpaceTracker()].getPlayers().remove(p); // removes from a player to the current shit
            p.updateSpaceTracker();
            if (!this.spaces[p.getSpaceTracker()].isJunction())
                this.spaces[p.getSpaceTracker()].getPlayers().add(p);
            else
                moveCnt = 0;
        }
    }

    /**
     * returns Deck class of the actionDeck.
     * 
     * @return Deck class of the actionDeck.
     */
    public Deck getActionDeck() {
        return this.actionDeck;
    }

    /**
     * returns the number of players in the game.
     * 
     * @return the number of players in the game.
     */
    public int getNumPlayers() {
        return this.NUM_PLAYERS;
    }

    /**
     * returns Player class of the player chosen.
     * 
     * 
     * @param index of player chosen
     * @return Player class of the player chosen.
     */
    public Player getPlayer(int index) {
        return this.players[index];
    }

    /**
     * returns an array of Players containing the current players in the game.
     * 
     * @return an array of Players containing the current players in the game.
     */
    public Player[] getPlayers() {
        return this.players;
    }

    /**
     * Checks if the game is over when all the players are retired.
     * 
     * @return true if all players are retired; false if not.
     */
    public boolean gameOver() {
        for (int i = 0; i < NUM_PLAYERS; i++) {
            if (!players[i].getIsRetired())
                return false;
        }

        return true;
    }

    /**
     * Force retire all players to end the game. Temporary method to end the game.
     *
     */
    public void retireAll() { // to be removed after phase 1(?)
        for (int i = 0; i < NUM_PLAYERS; i++) {
            this.players[i].setToRetire(true);
        }
    }

    /**
     * Displays the current cash of each player.
     * 
     */
    public void displayState() {
        System.out.println("\nCurrent State: ");
        for (int i = 0; i < NUM_PLAYERS; i++) {
            System.out.println(this.players[i].getName() + " : $" + this.players[i].getCash());
        }
        System.out.println();

        for (int i = 0; i < 100; i++) {
            if (this.spaces[i].getPlayers().size() != 0) {
                System.out.println("Space " + (i + 1) + " Players: ");
                for (int j = 0; j < this.spaces[i].getPlayers().size(); j++)
                    System.out.println(this.spaces[i].getPlayers().get(j).getName());

            }
        }
    }

    /**
     * Checks if the number of players are valid or not.
     * 
     * 
     * @return number of players indicated.
     */
    private int checkPlayerNumber(int numPlayers) {
        return numPlayers = numPlayers > 3 || numPlayers < 2 ? 2 : numPlayers;
    }
}