package assignment_problems;
public class Solution {

    public int maxSubArray(int[] nums) {
        // Initialize maxSoFar and currentSum with the first element
        int maxSoFar = nums[0];
        int currentSum = nums[0];

        // Loop through the remaining elements starting from index 1
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend the current running subarray or start fresh at nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update the overall maximum sum found so far
            maxSoFar = Math.max(maxSoFar, currentSum);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Sample Test Case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max Subarray Sum: " + sol.maxSubArray(nums1)); // Output: 6

        // Sample Test Case 2 (All negative numbers)
        int[] nums2 = {-3, -1, -2};
        System.out.println("Max Subarray Sum: " + sol.maxSubArray(nums2)); // Output: -1
    }
}