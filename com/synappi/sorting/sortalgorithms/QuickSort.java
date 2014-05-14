package com.synappi.sorting.sortalgorithms;

/**
 * Quick sort algorithm adapted from Lars Vogel.
 * Steps:
 * 1. Pick an element, called a pivot, from the list.
 * 2. Reorder the list so that all elements with values less than the pivot come before the pivot, while all elements with values greater than the pivot come after it (equal values can go either way). After this partitioning, the pivot is in its final position. This is called the partition operation.
 * 3. Recursively apply the above steps to the sub-list of elements with smaller values and separately to the sub-list of elements with greater values.
 * Best, Average Case: O(n log(n))
 * Worst Case: O(n^2)
 * @author Lars Vogel, Jeremy Wallace
 * @website http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html
 * @website http://www.synappi.com/
 */
public class QuickSort extends Sort  {
	
	  /**
	   * Constructor to set the integer array to sort.
	   * @param arrayToSort the array to sort.
	   */
	  public QuickSort(int[] arrayToSort) {
		  super("Quick Sort", arrayToSort);
	  }
	  
	 
	  /**
	   * This method will run the quick sort.
	   */
	  @Override
	public void start() {
		  quicksort(0, intHolder - 1);
	  }

	  /**
	   * The main quick sort method that is used recursively.
	   * @param low The low element index.
	   * @param high The high element index.
	   */
	  private void quicksort(int low, int high) {
	    
		int i = low, j = high;
	    
	    // Get the pivot element from the middle of the list
	    int pivot = arrayToSort[low + (high-low)/2];

	    // Divide into two lists
	    while (i <= j) {
	      // If the current value from the left list is smaller then the pivot
	      // element then get the next element from the left list
	      while (arrayToSort[i] < pivot) {
	        i++;
	      }
	      // If the current value from the right list is larger then the pivot
	      // element then get the next element from the right list
	      while (arrayToSort[j] > pivot) {
	        j--;
	      }

	      // If we have found a values in the left list which is larger then
	      // the pivot element and if we have found a value in the right list
	      // which is smaller then the pivot element then we exchange the
	      // values.
	      // As we are done we can increase i and j
	      if (i <= j) {
	        exchange(i, j);
	        i++;
	        j--;
	      }
	    }
	    // Recursion
	    if (low < j)
	      quicksort(low, j);
	    if (i < high)
	      quicksort(i, high);
	  }

	  /**
	   * Exchanges to values in the integer list.
	   * @param i Index of value to swap.
	   * @param j Index of second value to swap.
	   */
	  private void exchange(int i, int j) {
	    int temp = arrayToSort[i];
	    arrayToSort[i] = arrayToSort[j];
	    arrayToSort[j] = temp;
	  }
	} 