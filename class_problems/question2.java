package class_problems;

// Class encapsulating quiz scorecard logic and results
class Scorecard {
    private final boolean[] results;
    private int count;

    // Constructor setting total questions capacity
    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.count = 0;
    }

    // Records the next answer result if capacity permits
    public void recordAnswer(boolean isCorrect) {
        if (this.count < this.results.length) {
            this.results[this.count] = isCorrect;
            this.count++;
        } else {
            System.out.println("All answers recorded. Cannot add more.");
        }
    }

    // Computes and returns the total count of correct answers on request
    public int getScore() {
        int score = 0;
        for (int i = 0; i < this.count; i++) {
            if (this.results[i]) {
                score++;
            }
        }
        return score;
    }
}

public class question2 {

    public static void main(String[] args) {
        // Instantiate Scorecard for 4 questions
        Scorecard sc = new Scorecard(4);

        // Record answers: correct (true), correct (true), wrong (false), correct (true)
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        // Print final score
        System.out.println("sc.getScore() -> " + sc.getScore());
    }
}
