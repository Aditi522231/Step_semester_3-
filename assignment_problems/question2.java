package assignment_problems;

public class question2 {

    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null) {
            return "No Duplicates Found";
        }

        // Outer loop picks each player name sequentially
        for (int i = 0; i < playerNames.length; i++) {
            // Inner loop compares with every name that comes after it
            for (int j = i + 1; j < playerNames.length; j++) {
                // Use .equals() for case-sensitive string equality check
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        // Return when no duplicates are found after complete scan
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println(findDuplicatePick(lineup1));
        // Expected: "Duplicate Found: Kohli"

        // Sample Test Case 2
        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println(findDuplicatePick(lineup2));
        // Expected: "No Duplicates Found"
    }
}