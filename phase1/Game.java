package phase1;

import java.util.*;

/**
 * Creates a game that initalizes all decks and adds players to the game.
 * 
 */
public class Game {
    Scanner scanner = new Scanner(System.in);
    private Player[] players;
    private int NUM_PLAYERS;
    private Deck actionDeck;
    private Space spaces[];

    /**
     * Implements a game object that has the number of players as a parameter. The
     * number of players may be 2 to 3. For invalid values for number of players
     * provided, 2 will be used.
     * 
     * @param NUM_PLAYERS number of players; 2 will be used if invalid
     */
    public Game(int NUM_PLAYERS) {
        this.NUM_PLAYERS = checkPlayerNumber(NUM_PLAYERS);

        this.players = new Player[this.NUM_PLAYERS];

        for (int i = 0; i < this.NUM_PLAYERS; i++) {
            System.out.println("Enter Player " + (i + 1) + " name: ");
            players[i] = new Player();
        }

        this.actionDeck = new Deck("Action", 50);
        actionDeck.shuffleDeck();
        this.spaces = new Space[100];
        generateSpaces();
    }

    public void generateSpaces() {
        this.spaces[0] = new Space("", this.NUM_PLAYERS);
        for (int j = 0; j < NUM_PLAYERS; j++)
            this.spaces[0].getPlayers().add(players[j]);

        // Career Path
        this.spaces[1] = new OrangeSpace("career", this.NUM_PLAYERS);
        this.spaces[2] = new OrangeSpace("career", this.NUM_PLAYERS);
        this.spaces[3] = new OrangeSpace("career", this.NUM_PLAYERS);
        this.spaces[4] = new OrangeSpace("career", this.NUM_PLAYERS);
        this.spaces[5] = new OrangeSpace("career", this.NUM_PLAYERS);
        this.spaces[6] = new MagentaSpace("career", this.NUM_PLAYERS, "Get Married");
        this.spaces[7] = new OrangeSpace("career", this.NUM_PLAYERS);
        this.spaces[8] = new OrangeSpace("career", this.NUM_PLAYERS);
        this.spaces[9] = new OrangeSpace("career", this.NUM_PLAYERS);
        this.spaces[10] = new OrangeSpace("career", this.NUM_PLAYERS);
        this.spaces[11] = new OrangeSpace("career", this.NUM_PLAYERS);

        // College Path

        this.spaces[12] = new OrangeSpace("college", this.NUM_PLAYERS);
        this.spaces[13] = new OrangeSpace("college", this.NUM_PLAYERS);
        this.spaces[14] = new OrangeSpace("college", this.NUM_PLAYERS);
        this.spaces[15] = new OrangeSpace("college", this.NUM_PLAYERS);
        this.spaces[16] = new OrangeSpace("college", this.NUM_PLAYERS);
        this.spaces[17] = new OrangeSpace("college", this.NUM_PLAYERS);
        this.spaces[18] = new MagentaSpace("college", this.NUM_PLAYERS, "Graduation");
        this.spaces[19] = new OrangeSpace("college", this.NUM_PLAYERS);
        this.spaces[20] = new MagentaSpace("college", this.NUM_PLAYERS, "College Career Choice");
        this.spaces[21] = new OrangeSpace("college", this.NUM_PLAYERS);

        // Meet at Some Point

        for (int i = 22; i < 38; i++) {
            this.spaces[i] = new OrangeSpace("main", this.NUM_PLAYERS);
        }

        // Junction
        this.spaces[38] = new MagentaSpace("main", this.NUM_PLAYERS, "Which path?");

        // Change Career Path

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
     * @return Player class o f the player chosen.
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
     * Displays the current cash of each player and career.
     * 
     */
    public void displayState() {
        System.out.println("\nCurrent State: ");
        for (int i = 0; i < NUM_PLAYERS; i++) {
            System.out.println(this.players[i].getName() + " : $" + this.players[i].getCash() + " Career: "
                    + this.players[i].getCareer());
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
     * @param numPlayers indicated the specified number of player
     * 
     * @return the final number of players indicated.
     */
    private int checkPlayerNumber(int numPlayers) {
        if (numPlayers > 3 || numPlayers < 2) {
            System.out.println("Invalid player numbers. The player number was adjusted to two.");
            numPlayers = 2;
        }
        return numPlayers;
    }
}