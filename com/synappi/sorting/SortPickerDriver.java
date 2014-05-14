package com.synappi.sorting;

import com.synappi.sorting.SortPicker.SortType;

public class SortPickerDriver {
	
	public final static int DEFAULT_ARRAY_SIZE = 50,
							DEFAULT_MAX = 100,
							DEFAULT_MIN = 0;
	public final static SortType DEFAULT_SORT_TYPE = SortType.MERGE_SORT;

	
	/**
	 * Main method that parses the parameters and runs the sort.
	 * @param args
	 */
	public static void main(String args[]) {
		
		SortPicker sp = null;
		
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
		
		if (sp == null) {
			sp = new SortPicker(DEFAULT_ARRAY_SIZE,
					DEFAULT_SORT_TYPE,
					DEFAULT_MIN, DEFAULT_MAX);
		}
		
		System.out.println("The unsorted list: \n { "+sp.getListString()+" }");
		System.out.println(sp.getSortInfo());
		System.out.println("Running the sorting algorithm...");
		
		sp.runSort();
		
		System.out.println("Elapsed time: "+sp.getElapsedTime());
		System.out.println("The sorted list: \n { "+sp.getListString());
	}
	
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
