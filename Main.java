import java.util.*;

public class Main {
    public static void main(String[] args) {

        Game game = new Game(2);
        int turn = 0;
        int playerIndex = 0;
        int action = 0;
        System.out.println(game.getActionDeck().showCards());
        Scanner scanner = new Scanner(System.in);

        while(!game.gameOver()){

            playerIndex = turn % game.getNumPlayers();
            System.out.println("It's Player " + (playerIndex + 1) + " (" + game.getPlayer(playerIndex).getName() + "'s) turn: ");
            

            System.out.println("Choose an action: ");
            System.out.println("[1] - Draw");
            System.out.println("[2] - End");
                action = Integer.parseInt(scanner.nextLine());
            
            while(action != 2 && action != 1){
                action = Integer.parseInt(scanner.nextLine());
            }

            if(action == 1){
                System.out.printf("Draws: ");
                game.drawCard(game.getActionDeck(), playerIndex);

                //display state
                game.displayState();

                //reshuffle if num cards = 0   
            }else{
                game.retireAll();
            }

            turn++;
        }


        System.out.println("Game has ended");

/*
        Deck actionDeck = new Deck("orange", 50);
        Player p = new Player("Tyrone");
        Player p2 = new Player("Gavin");
        actionDeck.generateDeck();
        actionDeck.shuffleDeck();

        System.out.println(actionDeck.showCards());
        p.drawCard(actionDeck);
        p2.drawCard(actionDeck);
        System.out.println(p.getDrawnCard());
       System.out.println(p2.getDrawnCard());
*/

    }
}
