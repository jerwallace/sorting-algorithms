package com.synappi.sorting;

import com.synappi.sorting.SortPicker.SortType;

/**
 * SortPickerDriver holds the main class and runs the program.
 * @author Jeremy Wallace
 * @organization SYNAPPI apps
 * @website http://www.synappi.com
 *
 */
public class SortPickerDriver {
	
	public final static int DEFAULT_ARRAY_SIZE = 50,
							DEFAULT_MAX = 100,
							DEFAULT_MIN = 0;
	public final static SortType DEFAULT_SORT_TYPE = SortType.MERGE_SORT;

	
	/**
	 * Main method that parses the parameters and runs the sort.
	 * @param args Command line arguments. 4 required. 
	 * [0] = List length, 
	 * [1] = Sorting Algorithm (0 = Merge Sort, 1 = Quick Sort, 2 = Insertion Sort)
	 * [2] = Random number range minimum value.
	 * [3] = Random number range maximum value.
	 */
	public static void main(String args[]) {
		
		SortPicker sp = null;
		
		// Error checking.
		if (args.length!=4) {
			System.err.println("Invalid number of arguments. Using defaults.");
		} else {
			try {
				
				sp = new SortPicker(Integer.valueOf(args[0]),
								    getSortType(Integer.valueOf(args[1])),
								    Integer.valueOf(args[2]),
									Integer.valueOf(args[3]));
				
			} catch (NumberFormatException ex) {
				System.err.println("Error parsing values. Using defaults.");
			}
		}	
		
		// If there was an error, use the defaults.
		if (sp == null) {
			sp = new SortPicker(DEFAULT_ARRAY_SIZE,
					DEFAULT_SORT_TYPE,
					DEFAULT_MIN, DEFAULT_MAX);
		}
		
		// Run the sorting algorithm.
		System.out.println("The unsorted list: \n { "+sp.getListString()+" }");
		System.out.println(sp.getSortInfo());
		System.out.println("Running the sorting algorithm...");
		
		sp.runSort();
		
		System.out.println("Elapsed time: "+sp.getElapsedTime());
		System.out.println("The sorted list: \n { "+sp.getListString());
	}
	
	/**
	 * Get the enumerated SortType value from the entered command line integer.
	 * @param sortType The integer entered in the command line.
	 * @return An enumerated SortType value (MERGE_SORT,QUICK_SORT,INSERTION_SORT).
	 */
	public static SortType getSortType(int sortType) {
		switch (sortType) {
		case 0:
			return SortType.MERGE_SORT;
		case 1:
			return SortType.QUICK_SORT;
		case 2:
			return SortType.INSERTION_SORT;
		default:
			return null;
		}
	}
}
