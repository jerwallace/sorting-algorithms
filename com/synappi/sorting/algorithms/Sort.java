package com.synappi.sorting.algorithms;

/**
 * Abstract sorting algorithm class that holds the common functionality and
 * variables of all of the sorting algorithms
 * @author Jeremy Wallace
 * @website http://www.synappi.com/
 *
 */
public abstract class Sort {

	protected int[] arrayToSort;
	protected int intHolder;
	protected String name;
	 
	/**
	 * Initializes the list of integers and sets the name of the sorting algorithm.
	 * @param name The name of the sorting algorithm.
	 * @param arrayToSort The list of integers to sort.
	 */
	public Sort(String name, int[] arrayToSort) {
		// check for empty or null array
	    if (arrayToSort ==null || arrayToSort.length==0){
	      return;
	    }
	    this.arrayToSort = arrayToSort;
	    intHolder = arrayToSort.length;
	    this.name = name;
	}
	
	/**
	 * Method used in all sorting algorithms to initiate the sorting process.
	 */
	public abstract void start();
	
	 /**
	   * Returns the information about the string
	   * @return The information about this type of sort.
	   */
	public String getInfo() {
		  return "SORTING ALGORITHM: "+name;
	}  
	
}
