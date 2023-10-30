/*
 * Quick Sort:
 * Quick Sort is another efficient comparison-based sorting algorithm that falls under the category of divide and conquer algorithms. It was developed by Tony Hoare in 1960 and is widely used for its speed and effectiveness. Quick Sort works by selecting a "pivot" element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot.

Here's how the Quick Sort algorithm works:

Partition: The algorithm selects a pivot element from the array. The choice of the pivot can vary, but it's usually the first, last, or a random element. The elements in the array are then rearranged into two sub-arrays. Elements less than the pivot are moved to the left sub-array, and elements greater than the pivot are moved to the right sub-array. The pivot is now in its final sorted position.

Recursion: The Quick Sort algorithm is applied recursively to the left and right sub-arrays. This process is repeated until the entire array is sorted. Each recursive call operates on a smaller portion of the original array.

Combination: No additional work is needed to combine the sorted sub-arrays, as they are already in their correct positions. The array is considered sorted when all sub-arrays are sorted.

Key points about Quick Sort:

Advantages:

Fast average-case performance: Quick Sort has an average-case time complexity of O(n log n), which makes it one of the fastest sorting algorithms for most practical cases.
In-place sorting: Quick Sort is often implemented as an in-place sorting algorithm, meaning it doesn't require additional memory for temporary data structures.
Efficient for large data sets: Quick Sort is particularly efficient when dealing with large data sets.
Disadvantages:

Unstable sorting: Quick Sort is an unstable sorting algorithm, meaning it doesn't guarantee the preservation of the relative order of equal elements.
Worst-case time complexity: In the worst-case scenario (e.g., when the array is nearly sorted), Quick Sort can have a time complexity of O(n^2), which is significantly slower than its average-case performance. However, good pivot selection strategies and randomization can mitigate this issue.
Here's a Java implementation of Quick Sort:
 */
//import java.io.*;
class QuickSort 
{
	static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	static int partition(int[] arr, int low, int high)
	{
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) 
		{
			if (arr[j] < pivot) 
			{
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}
	static void quickSort(int[] arr, int low, int high)
	{
		if (low < high) 
		{
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high); 
		}
	}
	static void printArray(int[] arr, int size)
	{
		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	public static void main(String[] args)
	{
		int[] arr = { 10, 7, 8, 9, 1, 11 };
		int n = arr.length;
		quickSort(arr, 0, n - 1);
		System.out.println("Sorted array: ");
		printArray(arr, n);
	}
}