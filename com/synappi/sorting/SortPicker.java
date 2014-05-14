package com.synappi.sorting;

import com.synappi.sorting.sortalgorithms.InsertionSort;
import com.synappi.sorting.sortalgorithms.MergeSort;
import com.synappi.sorting.sortalgorithms.QuickSort;
import com.synappi.sorting.sortalgorithms.Sort;

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
	 * First record is 
	 * @param args
	 */
	public SortPicker(int arraySize, SortType sortType, int min, int max) {
		
		if (arraySize==0) {
			System.err.println("No array size entered. Using default:"+this.arraySize);
		} else {
			this.arraySize = arraySize;
		}
		
		if (sortType==null) {
			System.err.println("No sorting type entered. Using default: "+this.sortType);
		} else {
			this.arraySize = arraySize;
		}

		if (max <= min) {
			System.err.println("Max must be greater than min. Using defaults.");
		}
		
		array = new int[arraySize];
		
		for (int i = 0; i < this.arraySize; i++) {
			array[i] = getRandomNumber(min,max);
		}
		
		switch(sortType) {
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
	
	public String getSortInfo() {
		return sort.getInfo();
	}

	public void runSort() {

		startTime = System.currentTimeMillis();
		sort.start();
		endTime = System.currentTimeMillis();
	    elapsedTime = endTime - startTime;
	    
	}
	
	private int getRandomNumber(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	
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

	public String getElapsedTime() {
		return String.valueOf(elapsedTime)+" ms";
	}

}
