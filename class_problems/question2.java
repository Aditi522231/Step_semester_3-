package class_problems;

public class question2 {

    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null) {
            return "No Duplicates Found";
        }

        // Outer loop picks each team name sequentially
        for (int i = 0; i < teamNames.length; i++) {
            // Inner loop compares with every name that comes after it
            for (int j = i + 1; j < teamNames.length; j++) {
                // Use .equals() for string comparison without Collections
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        // Return when no duplicates are found after checking all pairs
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        // Sample Test Case
        String[] teams = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println(findDuplicateTeam(teams));
        // Expected Output: "Duplicate Found: ByteForce"
    }
}
