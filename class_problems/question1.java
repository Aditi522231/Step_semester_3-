package class_problems;

public class question1 {

    public int[] twoSum(int[] nums, int target) {
        // Outer loop iterates through each element
        for (int i = 0; i < nums.length; i++) {
            // Inner loop checks every subsequent element
            for (int j = i + 1; j < nums.length; j++) {
                // If pair adds up to target, return indices immediately
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // Fallback in case no solution is found
        return new int[]{};
    }
}