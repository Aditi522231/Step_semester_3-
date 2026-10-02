package class_problems;

import java.util.Arrays;

public class question4 {

    public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];

        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for arr2
        int k = 0; // Pointer for result

        // Compare elements from both arrays and copy the smaller element
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1, if any
        while (i < n1) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2, if any
        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        question4 q4 = new question4();

        // Sample Test Case 1
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        System.out.println("Output 1: " + Arrays.toString(q4.mergeSortedArrays(arr1, arr2)));
        // Expected: [1, 2, 3, 4, 5, 6]

        // Sample Test Case 2
        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        System.out.println("Output 2: " + Arrays.toString(q4.mergeSortedArrays(arr3, arr4)));
        // Expected: [1, 2, 3]
    }
}
