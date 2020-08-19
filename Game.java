import java.util.*;



public class Game{
    Scanner scanner = new Scanner(System.in);
    private Player[] players;
    int NUM_PLAYERS;
    Deck actionDeck;

    public Game(int NUM_PLAYERS){
        this.players = new Player[NUM_PLAYERS];
        this.NUM_PLAYERS = NUM_PLAYERS;

        for(int i = 0; i < NUM_PLAYERS; i++){
            System.out.println("Enter Player " + (i + 1) + " name: ");
            players[i] = new Player(scanner.nextLine());
        }

        this.actionDeck = new Deck("orange", 50);
        actionDeck.generateDeck();
        actionDeck.shuffleDeck();

    }

    public int getNumPlayers(){
        return this.NUM_PLAYERS;
    }

    public Player getPlayer(int index){
        return this.players[index];
    }

    public boolean GameOver(){
        for(int i = 0; i < NUM_PLAYERS; i++){
            if(!players[i].getIsRetired())
                return false;
        }

        return true;
    }





}