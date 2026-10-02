package class_problems;

import java.util.Arrays;

public class question5 {

    public int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = nums.length;
        // Normalize k in case k is greater than the array length
        k = k % n;

        int[] newArray = new int[n];

        // Place each element at its rotated position
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        // Copy elements back to original array (or return newArray)
        for (int i = 0; i < n; i++) {
            nums[i] = newArray[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        question5 q5 = new question5 ();

        // Sample Test Case 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Output 1: " + Arrays.toString(q5.rotateArray(nums1, k1)));
        // Expected: [5, 6, 7, 1, 2, 3, 4]

        // Sample Test Case 2
        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.println("Output 2: " + Arrays.toString(q5.rotateArray(nums2, k2)));
        // Expected: [2, 1]
    }
}
