package com.synappi.sorting;

import com.synappi.sorting.algorithms.InsertionSort;
import com.synappi.sorting.algorithms.MergeSort;
import com.synappi.sorting.algorithms.QuickSort;
import com.synappi.sorting.algorithms.Sort;

/**
 * SortPicker will pick from various types of sorting algorithms.
 * @author Jeremy Wallace
 * @organization SYNAPPI apps
 * @website http://www.synappi.com
 *
 */
public class SortPicker {
	
	private int arraySize = SortPickerDriver.DEFAULT_ARRAY_SIZE;
	private SortType sortType = SortPickerDriver.DEFAULT_SORT_TYPE;
	
	// To measure time / compare sorting algorithms.
	long startTime, endTime, elapsedTime;
	
	public Sort sort;
	int[] array;
	
	/**
	 * Enumerated types of sorting algorithms to use.
	 */
	public enum SortType {
		MERGE_SORT,QUICK_SORT,INSERTION_SORT
	}
	
	/**
	 * Initialize the variables and set to defaults if type is null.
	 * @param args
	 */
	public SortPicker(int arraySize, SortType sortType, int min, int max) {
		
		// Error checking 
		
		if (arraySize!=0) {
			this.arraySize = arraySize;
		}
		
		if (sortType!=null) {
			this.sortType = sortType;
		}

		if (max <= min) {
			System.err.println("Max must be greater than min. Using defaults.");
		}
		
		// Populate the array with random numbers.
		array = new int[arraySize];
		for (int i = 0; i < this.arraySize; i++) {
			array[i] = getRandomNumber(min,max);
		}
		
		// Initialize the sorting algorithm.
		switch(this.sortType) {
			case MERGE_SORT:
				sort = new MergeSort(array);
				break;
			case QUICK_SORT: 
				sort = new QuickSort(array);
				break;
			case INSERTION_SORT: 
				sort = new InsertionSort(array);
				break;
			default:
				sort = null;
				break;
		}
	
	}
	
	/**
	 * Returns the information about the sorting algorithm chosen.
	 * @return General information about the sorting algorithm.
	 */
	public String getSortInfo() {
		return sort.getInfo();
	}

	/**
	 * Start the timer and run the sorting algorithm.
	 */
	public void runSort() {

		startTime = System.currentTimeMillis();
		sort.start();
		endTime = System.currentTimeMillis();
	    elapsedTime = endTime - startTime;
	    
	}
	
	/**
	 * Helper method: Get a random number between any minimum and maximum integer value.
	 * @param min Minimum integer value in random number range.
	 * @param max Maximum integer value in random number range.
	 * @return A random integer between the min and max values.
	 */
	private int getRandomNumber(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	
	/**
	 * @return The integer array as a string.
	 */
	public String getListString() {
		
		if (array.length > 0) {
		    StringBuilder nameBuilder = new StringBuilder();

		    for (Integer in : array) {
		        nameBuilder.append(String.valueOf(in)).append(",");
		    }

		    nameBuilder.deleteCharAt(nameBuilder.length() - 1);

		    return nameBuilder.toString();
		} else {
		    return "";
		}
		
	}

	/**
	 * @return The elapsed time in ms for the sorting algorithm to complete.
	 */
	public String getElapsedTime() {
		return String.valueOf(elapsedTime)+" ms";
	}

}
