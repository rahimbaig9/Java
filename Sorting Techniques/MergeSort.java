/*
 * MergeSort:
 * Merge sort is a popular and efficient comparison-based sorting algorithm that falls under the category of divide and conquer algorithms. It was invented by John von Neumann in 1945. The algorithm's main idea is to divide an unsorted list into smaller sublists, sort these sublists, and then merge them back together to produce a sorted list.

Here's how the merge sort algorithm works:

Divide: The unsorted list is divided into two or more smaller sublists. This is typically done recursively until each sublist contains only one element.

Conquer: The sublists are sorted. This can be done by further dividing them or by using other sorting algorithms like merge sort itself.

Merge: The sorted sublists are merged back together into a single sorted list. This merging process involves comparing elements from the sublists and moving them into the final sorted list in the correct order.

The key operation in the merge step is comparing elements from the two sublists and placing them in the correct order. This is why merge sort is a comparison-based sorting algorithm.

Merge sort has some advantages and disadvantages:

Advantages:

Stable sorting: Merge sort is a stable sort, meaning it maintains the relative order of equal elements in the sorted list.
Consistent performance: It has a consistent and predictable performance of O(n log n) for worst-case, average-case, and best-case scenarios.
Excellent for linked lists: Merge sort's divide and conquer approach makes it suitable for sorting linked lists, as it requires minimal extra memory.
Disadvantages:

Additional memory usage: Merge sort requires additional memory to store temporary sublists during the merge step. This can be a drawback for very large lists.
Slower for small lists: For small lists, merge sort can be slower than more straightforward sorting algorithms like insertion sort or selection sort due to its divide and conquer overhead.
Here's a Java implementation of merge sort:
 */

/**
 * MergeSort
 */
import java.util.*;

class Solution {
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2 ;
        mergeSort(arr, low, mid);  // left half
        mergeSort(arr, mid + 1, high); // right half
        merge(arr, low, mid, high);  // merging sorted halves
    }
}
public class MergeSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = 7;
        int arr[] = { 9, 4, 7, 6, 3, 1, 5 };
        System.out.println("Before sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Solution.mergeSort(arr, 0, n - 1);
        System.out.println("After sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}
