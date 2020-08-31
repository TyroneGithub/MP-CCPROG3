import phase1.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /** DECK TESTER */

        // Deck deck = new Deck("orange", 10);
        // deck.generateDeck();
        // ActionCardv2 d;
        // System.out.println(deck.showCards());

        // for (int i = 0; i < 21; i++) {
        // d = deck.drawCard();
        // }

        int turn = 0;
        int playerIndex = 0;
        int action = 0;
        int noOfPlayers;

        System.out.print("Enter number of players: ");
        noOfPlayers = Integer.parseInt(scanner.nextLine());

        Game game = new Game(noOfPlayers);

        System.out.println(game.getActionDeck().showCards());

        while (!game.gameOver()) {
            playerIndex = turn % game.getNumPlayers();
            Player currPlayer = game.getPlayer(playerIndex);

            System.out.println("It's Player " + (playerIndex + 1) + " (" + currPlayer.getName() + "'s) turn: ");

            System.out.println("Choose an action: ");
            System.out.println("[1] - Draw");
            System.out.println("[2] - End");
            System.out.print("Enter : ");
            action = Integer.parseInt(scanner.nextLine());

            while (action != 2 && action != 1) {
                action = Integer.parseInt(scanner.nextLine());
            }

            if (action == 1) {
                currPlayer.drawCard(game.getActionDeck(), game.getPlayers());

                // display state
                game.displayState();

            } else {
                game.retireAll();
            }

            turn++;
        }

        System.out.println("Game has ended");
        scanner.close();
    }
}
