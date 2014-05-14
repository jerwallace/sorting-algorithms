package com.synappi.sorting.sortalgorithms;

public class InsertionSort extends Sort {

	public InsertionSort( int [ ] arrayToSort )
	{
		super("Insertion Sort",arrayToSort);
	}
	
	public void start() {
		insertionSort();
	}
	
	private void insertionSort() {
		
		 int j;                  
	     int key;
	     int i;  

	     for (j = 1; j < arrayToSort.length; j++)    // Start with 1 (not 0)
	    {
	           key = arrayToSort[ j ];
	           for(i = j - 1; (i >= 0) && (arrayToSort[ i ] < key); i--)   // Smaller values are moving up
	          {
	        	   arrayToSort[ i+1 ] = arrayToSort[ i ];
	          }
	           arrayToSort[ i+1 ] = key;    // Put the key in its proper location
	     }
	}
}
