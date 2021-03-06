package com.synappi.sorting.algorithms;

/**
 * Merge sort algorithm adapted from Lars Vogel.
 * Divide the unsorted list into n sublists, each containing 1 element (a list of 1 element is considered sorted).
 * Repeatedly merge sublists to produce new sorted sublists until there is only 1 sublist remaining. This will be the sorted list.
 * Best, Average and Worst Case: O(n log(n))
 * @author Lars Vogel, Jeremy Wallace
 * @website http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html
 * @website http://www.synappi.com/
 */
public class MergeSort extends Sort {
  
  private int[] helper;

  /**
   * Constructor to set the integer array to sort.
   * @param arrayToSort the array to sort.
   */
  public MergeSort(int[] arrayToSort) {
	  super("Merge Sort", arrayToSort);
	  this.helper = new int[intHolder];
  }
  
  /**
   * This method will run the merge sort.
   */
  @Override
  public void start() {
	  mergeSort(0,intHolder-1);
  }

  /**
   * This is the main merge sort method, which is used recursively.
   * @param low The low index value.
   * @param high The high index value.
   */
  public void mergeSort(int low, int high) {
    // check if low is smaller then high, if not then the array is sorted
    if (low < high) {
      // Get the index of the element which is in the middle
      int middle = low + (high - low) / 2;
      // Sort the left side of the array
      mergeSort(low, middle);
      // Sort the right side of the array
      mergeSort(middle + 1, high);
      // Combine them both
      merge(low, middle, high);
    }
  }

  /**
   * The low, middle and high 
   * @param low
   * @param middle
   * @param high
   */
  private void merge(int low, int middle, int high) {

    // Copy both parts into the helper array
    for (int i = low; i <= high; i++) {
      helper[i] = arrayToSort[i];
    }

    int i = low;
    int j = middle + 1;
    int k = low;
    // Copy the smallest values from either the left or the right side back
    // to the original array
    while (i <= middle && j <= high) {
      if (helper[i] <= helper[j]) {
        arrayToSort[k] = helper[i];
        i++;
      } else {
        arrayToSort[k] = helper[j];
        j++;
      }
      k++;
    }
    // Copy the rest of the left side of the array into the target array
    while (i <= middle) {
      arrayToSort[k] = helper[i];
      k++;
      i++;
    }

  }
} 
