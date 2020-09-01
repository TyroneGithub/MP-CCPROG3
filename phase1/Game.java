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

        this.actionDeck = new Deck("orange", 50);
        actionDeck.shuffleDeck();

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