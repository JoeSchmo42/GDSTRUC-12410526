import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayQueue playerQueue = new ArrayQueue(10); // Initial capacity
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int gamesCreated = 0;
        int playerId = 1;

        while (gamesCreated < 10) {
            // Add random number of players (1 to 7) each turn
            int playersToAdd = random.nextInt(7) + 1; // Random from 1 to 7
            System.out.println("\nTurn: Adding " + playersToAdd + " players to the queue...");
            for (int i = 0; i < playersToAdd; i++) {
                String playerName = "Player" + playerId;
                playerQueue.enqueue(new Player(playerId++, playerName, random.nextInt(1000)));
            }

            // Print current queue
            System.out.println("Current Queue:");
            playerQueue.printQueue();

            // Check if enough players for a game (at least 5)
            while (playerQueue.size() >= 5 && gamesCreated < 10) {
                System.out.println("\nStarting Game " + (gamesCreated + 1) + ":");
                System.out.print("Players: ");
                for (int i = 0; i < 5; i++) {
                    Player player = playerQueue.dequeue();
                    System.out.print(player + (i < 4 ? ", " : ""));
                }
                System.out.println();
                gamesCreated++;
            }

            // Wait for user to press Enter to proceed to next turn
            System.out.println("\nPress Enter to continue to the next turn...");
            scanner.nextLine();
        }

        System.out.println("\n10 games have been created. Matchmaking terminated.");
        scanner.close();
    }
}