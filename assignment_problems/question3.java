package assignment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class question3 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the outer loop element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            // Step 3: Two-pointer search for pairs summing to -nums[i]
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for the left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for the right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Need a larger sum
                } else {
                    right--; // Need a smaller sum
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        question3 q3 = new question3();

        // Sample Test Case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Output 1: " + q3.threeSum(nums1)); 
        // Expected: [[-1, -1, 2], [-1, 0, 1]]

        // Sample Test Case 2
        int[] nums2 = {0, 0, 0};
        System.out.println("Output 2: " + q3.threeSum(nums2)); 
        // Expected: [[0, 0, 0]]
    }
}
