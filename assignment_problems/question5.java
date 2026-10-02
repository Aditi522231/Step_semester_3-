package assignment_problems;

public class question5 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Modified Binary Search
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Compare middle element with the rightmost element
            if (nums[mid] > nums[right]) {
                // The minimum element must be in the right unsorted portion
                left = mid + 1;
            } else {
                // The minimum element is at 'mid' or to its left
                right = mid;
            }
        }

        // 'left' and 'right' converge at the minimum element
        return nums[left];
    }

    public static void main(String[] args) {
        question5 q5 = new question5();

        // Sample Test Case 1
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Output 1: " + q5.findMin(nums1)); 
        // Expected: 1

        // Sample Test Case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Output 2: " + q5.findMin(nums2)); 
        // Expected: 0

        // Sample Test Case 3 (No rotation)
        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Output 3: " + q5.findMin(nums3)); 
        // Expected: 11
    }
}