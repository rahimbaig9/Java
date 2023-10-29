# 🐚 HEAP SORT 🐚

# DEFINITION 🥇

**Heap sort**, is a comparison-based sorting algorithm that can be implemented in JavaScript for dynamic input.

# 💡EXPLANATION 💡

 1.** Build Heap:** Build a heap from the input data. Build a max heap to sort in increasing order, and build a min heap to sort in decreasing order.

 2.**Swap Root:** Swap the root element with the last item of the heap. 

 3.** Reduce Heap Size:** Reduce the heap size by 1.

 4.**Re-Heapify:** Heapify the remaining elements into a heap of the new heap size by calling heapify on the root node.

 5.**Call Recursively:** Repeat steps 2,3,4 as long as the heap size is greater than 2.

 #  📖 Code related explanation 📖

 ## 1.'heapsort function' :
 ```bash
 function heapSort(arr) {
    function buildMaxHeap(arr) {
      const len = arr.length;
      for (let i = Math.floor(len / 2); i >= 0; i--) {
        heapify(arr, i, len);
      }
    }
```
   1.A max-heap from the input array is found by using buildMaxHeap function.
   2.In this function, the length of the input array arr, which is used to determine the number of elements in the array is found.Build
   3.The for loop is responsible for building the max-heap from the array. It starts at the last non-leaf node in the heap and works its way up to the root (the first element).
   4.Heapify function is called with the input array arr, the current node index i, and the length of the array len. Its role is to maintain the max-heap property for a subtree rooted at node i

   ## 2.'heapify function' :
   ```bash
   function heapify(arr, i, len) {
    const left = 2 * i + 1;
    const right = 2 * i + 2;
    let largest = i;

    if (left < len && arr[left] > arr[largest]) {
      largest = left;
    }

    if (right < len && arr[right] > arr[largest]) {
      largest = right;
    }

    if (largest !== i) {
     
      [arr[i], arr[largest]] = [arr[largest], arr[i]];

      heapify(arr, largest, len);
    }
  }
```1. Calculate the indices of the left and right children of the node at index i in the binary tree and initialize a variable largest.
   2. Check if the left child exists (i.e., left < len) and whether its value is greater than the value of the node at index largest. If so, update the largest index to the index of the left child.
      Similarly for the right child.
   3. Swap if necessary
   4. After swapping, the max-heap property in the affected subtree rooted at index largest may be violated. To correct this, the heapify function is called recursively on the affected subtree to ensure that the max-heap property is maintained throughout the entire subtree.

   ## 2.'Calling buildMaxHeap function' :

   ```bash
   buildMaxHeap(arr);

   for (let i = arr.length - 1; i > 0; i--) {
     
     [arr[0], arr[i]] = [arr[i], arr[0]];
 
     heapify(arr, 0, i);
   }
 
   return arr;
 }
 const inputArray = [4, 10, 3, 5, 1];
 const sortedArray = heapSort(inputArray);
 console.log(sortedArray);
```
1. buildMaxHeap function call to ensure that the largest element is at the root of the heap.
2. The code then enters a loop that iterates from the end of the array to the beginning by using for loop.
3.The heapify(arr, i, n) function is responsible for maintaining the max heap property. 
4.This code implements the Heap Sort algorithm, which repeatedly moves the maximum element (at the root) to the end of the array. 
By doing this in each iteration, it gradually builds the sorted portion of the array.
5.An example usage of the code is provided, demonstrating how to sort an input array using Heap Sort. 
In this example, the input array [4, 10, 3, 5, 1] is sorted in ascending order, and the sorted array is printed to the console.