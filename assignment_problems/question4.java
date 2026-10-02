package assignment_problems;

import java.util.HashMap;
import java.util.Map;

public class question4 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        
        // Map to store frequency of running prefix sums: <PrefixSum, Frequency>
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // Base Case: A prefix sum of 0 has occurred once before starting the loop
        prefixSumMap.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            
            // Check if there is a previous prefix sum such that:
            // currentSum - previousPrefixSum = k  =>  previousPrefixSum = currentSum - k
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }
            
            // Record or update the frequency of the current running sum
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        question4 q4 = new question4();

        // Sample Test Case 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Output 1: " + q4.subarraySum(nums1, k1)); 
        // Expected: 2

        // Sample Test Case 2
        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println("Output 2: " + q4.subarraySum(nums2, k2)); 
        // Expected: 3
    }
}