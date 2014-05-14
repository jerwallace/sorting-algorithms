package com.synappi.sorting.sortalgorithms;

public abstract class Sort {

	protected int[] arrayToSort;
	protected int intHolder;
	protected String name;
	  
	public Sort(String name, int[] arrayToSort) {
		// check for empty or null array
	    if (arrayToSort ==null || arrayToSort.length==0){
	      return;
	    }
	    this.arrayToSort = arrayToSort;
	    intHolder = arrayToSort.length;
	    this.name = name;
	}
	
	public abstract void start();
	
	 /**
	   * Returns the information about the string
	   * @return The information about this type of sort.
	   */
	public String getInfo() {
		  return "SORTING ALGORITHM: "+name;
	}  
	
}
