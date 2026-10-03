package class_problems;
import java.util.Random;

public class question1 {

    // Evaluates a single round and returns the result string
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        String[] possibleMoves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();

        // Sample player moves for demo (N = 5)
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int N = playerMoves.length;

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < N; i++) {
            String playerMove = playerMoves[i];
            // Randomly select move for computer
            String computerMove = possibleMoves[random.nextInt(3)];

            String result = playRound(playerMove, computerMove);

            // Update stats
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            // Print summary row for each round
            System.out.printf("Round %d | %-11s | %-13s | %s\n", (i + 1), playerMove, computerMove, result);
        }

        // Calculate win percentage
        double winPercentage = ((double) wins / N) * 100;

        System.out.println("\nFinal Summary:");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
    }
}