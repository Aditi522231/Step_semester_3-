package assignment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Player class implementing Comparable<Player> for descending order by batting average
class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    // Constructor
    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Rule 1: Established players qualify on experience alone (matches >= 10)
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Rule 2: Newer players qualify if reasonably experienced (matches >= 5) AND not injured
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    // Compare players by batting average descending for Arrays.sort()
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}

public class question5 {

    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        List<Player> draftableList = new ArrayList<>();

        // Filter draftable players using overloaded isDraftable methods
        for (Player p : players) {
            boolean eligible = Player.isDraftable(p.matchesPlayed) || 
                              Player.isDraftable(p.matchesPlayed, p.injured);
            if (eligible) {
                draftableList.add(p);
            }
        }

        // Convert list to array to use Arrays.sort()
        Player[] draftableArray = draftableList.toArray(new Player[0]);

        // Sort using compareTo (descending order by batting average)
        Arrays.sort(draftableArray);

        // Format output string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            result.append(i + 1).append(". ").append(draftableArray[i].name);
            if (i < draftableArray.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Sample Test Case
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
        // Expected Output: "1. Rahul | 2. Virat | 3. Dev"
    }
}