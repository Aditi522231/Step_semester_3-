package assignment_problems;

public class question4 {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        // Handle empty arrays
        if (sectionA == null || sectionB == null || sectionA.length == 0) {
            System.out.println("Invalid inventory data.");
            return;
        }

        int totalA = 0;
        int totalB = 0;

        int maxQuantity = sectionA[0];
        String maxSection = "Section A";
        int maxItemIndex = 1; // 1-based index to match sample output

        // Process Section A: calculate sum and search for maximum value
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxItemIndex = i + 1;
            }
        }

        // Process Section B: calculate sum and search for maximum value
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxItemIndex = i + 1;
            }
        }

        // Determine if total quantities match
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        // Print output in exact format required by sample
        System.out.println("Section A Total: " + totalA + 
                           " | Section B Total: " + totalB + 
                           " | Status: " + status + 
                           " | Highest Quantity: " + maxQuantity + 
                           " (" + maxSection + ", Item " + maxItemIndex + ")");
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}