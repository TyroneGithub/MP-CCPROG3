import java.util.*;



public class Game{
    Scanner scanner = new Scanner(System.in);
    private Player[] players;
    private int NUM_PLAYERS;
    private Deck actionDeck;

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

    public Deck getActionDeck(){
        return this.actionDeck;
    }

    public int getNumPlayers(){
        return this.NUM_PLAYERS;
    }

    public Player getPlayer(int index){
        return this.players[index];
    }

    public void drawCard(Deck deck, int playerIndex) {

        int i, playerChosen = 0;
        ActionCardv2 drawnCard = deck.drawCard();
        System.out.println(drawnCard.getDescription() + " TYPE: " + drawnCard.getType() + " Value: $" + drawnCard.getValue());

        //Update State/
        switch(drawnCard.getType()){
            case 1: //+
                this.players[playerIndex].updateCash(drawnCard.getValue());
                break;

            case 2: //-
                this.players[playerIndex].updateCash(-drawnCard.getValue());
                break;    
            case 3: //+
                if(drawnCard.getToAll()){
                    for(i = 0; i < NUM_PLAYERS; i++){
                        if(i != playerIndex){
                            this.players[i].updateCash(-drawnCard.getValue());
                            this.players[playerIndex].updateCash(drawnCard.getValue());
                        }
                    }
                }else{
                    System.out.println("Choose a player");
                    playerChosen = Integer.parseInt(scanner.nextLine());

                    this.players[playerChosen].updateCash(-drawnCard.getValue());
                    this.players[playerIndex].updateCash(drawnCard.getValue());

                }
                break;
            case 4: //-
                if(drawnCard.getToAll()){
                    for(i = 0; i < NUM_PLAYERS; i++){
                        if(i != playerIndex){
                            this.players[playerIndex].updateCash(-drawnCard.getValue());
                            this.players[i].updateCash(drawnCard.getValue());
                        }
                    }
                }else{
                    System.out.println("Choose a player");
                    playerChosen = Integer.parseInt(scanner.nextLine());
                    
                    this.players[playerIndex].updateCash(-drawnCard.getValue());
                    this.players[playerChosen].updateCash(drawnCard.getValue());

                }
                break;

        }

    }


    public boolean gameOver(){
        for(int i = 0; i < NUM_PLAYERS; i++){
            if(!players[i].getIsRetired())
                return false;         
        }

        return true;
    }

    public void retireAll(){ // to be removed after phase 1(?)
        for(int i = 0; i < NUM_PLAYERS; i++){
            this.players[i].setToRetire(true);
        }
    }

    public void displayState(){
        System.out.println("\nCurrent State: ");
        for(int i = 0; i < NUM_PLAYERS; i++){
            System.out.println(this.players[i].getName() + " : $" + this.players[i].getCash());
        }   
        System.out.println();
    }
}