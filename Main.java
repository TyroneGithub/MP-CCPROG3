import java.util.*;

public class Main {
    public static void main(String[] args) {

        Game game = new Game(2);
        int turn = 0;
        int playerIndex = 0;
        System.out.println(game.actionDeck.showCards());

        while(!game.GameOver() && turn != 50){

            playerIndex = turn % game.getNumPlayers();
            System.out.println("It's Player " + (playerIndex + 1) + " (" + game.getPlayer(playerIndex).getName() + "'s) turn: ");
            System.out.printf("Draws: ");
            game.getPlayer(playerIndex).drawCard(game.actionDeck);
            System.out.println(game.getPlayer(playerIndex).getDrawnCard());    

            turn++;
        }

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
