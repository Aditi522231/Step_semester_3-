package class_problems;

public class question3 {

    public boolean containsDuplicate(int[] nums) {
        // Outer loop picks element at position i
        for (int i = 0; i < nums.length; i++) {
            // Inner loop compares with every element at a different position j
            for (int j = i + 1; j < nums.length; j++) {
                // If a duplicate value is found at different positions, return true immediately
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        // Return false if no duplicate pairs are found
        return false;
    }

    public static void main(String[] args) {
        question3 q3 = new question3();

        // Sample Test Case 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Output 1: " + q3.containsDuplicate(nums1)); 
        // Expected: true

        // Sample Test Case 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Output 2: " + q3.containsDuplicate(nums2)); 
        // Expected: false
    }
}