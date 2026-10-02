package class_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Candidate class implementing Comparable<Candidate> for ranking by composite score descending
class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;

    // Constructor
    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // CGPA-only filter for strong candidates (e.g., CGPA >= 8.0)
    public static boolean isEligible(double cgpa) {
        return cgpa >= 8.0;
    }

    // Combined CGPA and coding score filter for borderline cases (e.g., CGPA >= 6.5 AND coding score >= 75)
    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 75;
    }

    // Composite score formula (e.g., CGPA * 10 + codingScore)
    public double getCompositeScore() {
        return (this.cgpa * 10.0) + this.codingScore;
    }

    // Compare candidates descending by composite score for Arrays.sort()
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }
}

public class question5 {

    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> shortlisted = new ArrayList<>();

        // Filter eligible candidates using overloaded isEligible checks
        for (Candidate c : candidates) {
            boolean eligible = Candidate.isEligible(c.cgpa) || 
                              Candidate.isEligible(c.cgpa, c.codingScore);
            if (eligible) {
                shortlisted.add(c);
            }
        }

        // Convert list to array for Arrays.sort()
        Candidate[] shortlistedArray = shortlisted.toArray(new Candidate[0]);

        // Sort using compareTo (descending order by composite score)
        Arrays.sort(shortlistedArray);

        // Format output string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            result.append(i + 1).append(". ").append(shortlistedArray[i].name);
            if (i < shortlistedArray.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Sample Test Case
        Candidate[] candidates = {
            new Candidate("Aman", 8.5, 60),   // Eligible on CGPA alone (8.5 >= 8.0) -> Composite = 145.0
            new Candidate("Riya", 7.0, 85),   // Eligible via combined rule (7.0 >= 6.5 && 85 >= 75) -> Composite = 155.0
            new Candidate("Karan", 6.0, 90),  // Not eligible (CGPA < 6.5)
            new Candidate("Priya", 8.2, 80)   // Eligible on CGPA alone (8.2 >= 8.0) -> Composite = 162.0
        };

        System.out.println(shortlistAndRank(candidates));
        // Expected Output: "1. Priya | 2. Riya | 3. Aman"
    }
}