package com.synappi.sorting.algorithms;

/**
 * Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time.
 * Best case: O(n)
 * Average case: O(n^2)
 * Worst case: O(n^2)
 * @author Jeremy Wallace
 * @organization SYNAPPI apps
 * @website http://www.synappi.com
 *
 */
public class InsertionSort extends Sort {

	/**
	 * Constructor sets up the array to sort and initializes the variables.
	 * @param arrayToSort
	 */
	public InsertionSort( int[] arrayToSort )
	{
		super("Insertion Sort",arrayToSort);
	}
	
	@Override
	public void start() {
		insertionSort();
	}
	
	/**
	 * The main insertion sort method.
	 */
	private void insertionSort() {
		
		 int j;                  
	     int key;
	     int i;  

	    // Nested for loop to compare all of the values below the key value
	    // one at a time.
	    for (j = 1; j < arrayToSort.length; j++)
	    {
	           key = arrayToSort[ j ];
	           // Larger values are moving up
	           for(i = j - 1; (i >= 0) && (arrayToSort[i] > key); i--)
	           {
	        	   arrayToSort[ i+1 ] = arrayToSort[i];
	           }
	           
	           // Set the key to it's intended location.
	           arrayToSort[ i+1 ] = key;    
	     }
	}
}
