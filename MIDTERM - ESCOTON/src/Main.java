import java.util.Random; //randomizer
import java.util.Scanner; //needed for the enter thing lol i found out the hard way

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //game set up (the important stuff)
        String[] cardTypes = {"Fire", "Water", "Wind", "Earth", "Electric", "Dark", "Light", "Fairy", "Dragon", "Bug"};

        CardStack playerDeck = new CardStack(30);
        CardStack playerHand = new CardStack(10);
        CardStack discardPile = new CardStack(10);

        //card randomizer
        for (int i = 1; i <= 30; i++) {
            String cardName = cardTypes[random.nextInt(cardTypes.length)];
            playerDeck.push(new Card(i, cardName));
        }

        //continues the game until there is no more cards in the player deck
        while (!playerDeck.isEmpty()) {
            int command = random.nextInt(3);
            int numCards = random.nextInt(5) + 1;


            System.out.println("\n=== New Turn ===");
            //The randomized commands
            //thank you c++ lessons for reminding me of this method
            switch (command) {
                case 0: // Draw
                    System.out.println("Command: Draw " + numCards + " cards");
                    for (int i = 0; i < numCards && !playerDeck.isEmpty(); i++) {
                        Card card = playerDeck.pop();
                        if (card != null) {
                            playerHand.push(card);
                        }
                    }
                    break;
                case 1: // Discard
                    System.out.println("Command: Discard " + numCards + " cards");
                    for (int i = 0; i < numCards && !playerHand.isEmpty(); i++) {
                        Card card = playerHand.pop();
                        if (card != null) {
                            discardPile.push(card);
                        }
                    }
                    break;
                case 2: // Get from discard
                    System.out.println("Command: Get " + numCards + " cards from discard pile");
                    for (int i = 0; i < numCards && !discardPile.isEmpty(); i++) {
                        Card card = discardPile.pop();
                        if (card != null) {
                            playerHand.push(card);
                        }
                    }
                    break;
            }

            //In game text
            System.out.println("\nPlayer Hand:");
            playerHand.printStack();
            System.out.println("Cards in Player Deck: " + playerDeck.size());
            System.out.println("Cards in Discard Pile: " + discardPile.size());
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }

        //End
        System.out.println("Game Over: Player Deck is empty!");
        scanner.close();
    }
}