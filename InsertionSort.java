//Christopher Jackson
//CS3130 - Project 1

/* array: integer array that will hold the original array of 1000 elements before either sort is performed.
 * linear_array: integer array that has been sorted using the Linear Sort method.
 * binary_array: integer array that has been sorted using the Binary Sort method
 * i,j: iterative values to initialize and print the arrays. 
 * random: random number generator to produce numbers between 1 - 1000.
 * LinearSort: method that takes in the unsorted array and sorts it using linear sort then returns the sorted array.
 * BinarySort: method that takes in the unsorted array and sorts it using binary sort then returns the sorted array
 * start_time: starts the timer that logs how long linear sort and binary sort takes (in nano seconds).
 * stop_time: stops the timer that logs how long linear sort and binary sort takes (in nano seconds).
 * running: calculates the time it takes for each sort to perform by subtracting the stop_time - start_time.
 * comparisons: counter that keeps track of how many times a comparison is made. 
 * assignments: counter that keeps track of how many times an assignment is made.
 * BinarySearch: binary search method that performs the binary search to perform the binary sort method.
 * low: low integer.
 * high: high integer.
 * key: key integer.
 * mid:  middle integer.
 *************************************************************************************************************************/

import java.util.*;

public class InsertionSort 
{
	public static void main(String [] args)
	{		
		int array[] = new int[1000];
		int linear_array[] = new int[1000];
		int binary_array[] = new int[1000];

		//Prints the array before it is sorted. 
		System.out.println("Array before insertion: ");
	    for(int i = 0; i < 1000; i++)
	    {
	    	Random rand = new Random();
		    int random = rand.nextInt(1001 - 1) + 1;
	    	array[i] = random;
	    	
	    	System.out.print(array[i] + ", ");
	    	if((i+1) % 20 == 0)
	    	{
	    		System.out.print("\n");
	    	}
	    }
	    System.out.println("\n");
	    
	    //Prints the array after the linear sort is performed. 
	    System.out.println("Array after linear sort: ");
	    linear_array = LinearSort(array);
	    for(int j = 0; j < 1000; j++)
	    {
	    	System.out.print(linear_array[j] + ", ");
	    	if((j+1) % 20 == 0)
	    	{
	    		System.out.print("\n");
	    	}
	    }
	    
	    //Prints the array after the binary sort is performed. 
	    System.out.print("\n");
	    System.out.println("Array after binary sort: ");
	    binary_array = BinarySort(array);
	    for(int j = 0; j < 1000; j++)
	    {
	    	System.out.print(binary_array[j] + ", ");
	    	if((j+1) % 20 == 0)
	    	{
	    		System.out.print("\n");
	    	}
	    }
	}
	
	//Method to perform the linear sort on the unsorted array that is passed.
	public static int [] LinearSort(int [] array)
	{	
		long start_time;
		long running;
		long stop_time;

		int key = 0, comparisons = 0, assignments = 0;
		
		//Starts timer.
		start_time = System.nanoTime();
		for (int i = 1; i < 1000; i++) 
		{
			for(int j = i ; j > 0 ; j--)
			{
				comparisons++;
				if(array[j] < array[j-1])
				{
					key = array[j];
					array[j] = array[j-1];
					array[j-1] = key;
					assignments++;
				}
			}
		}
		//Stops timer the calculates difference.
		stop_time = System.nanoTime();
		running = (stop_time - start_time);
	
		//Prints out how the linear sort performed. 
		 System.out.print("Comparissons: " + comparisons);
		 System.out.print("\n");
		 System.out.print("Assignments: " + assignments);
		 System.out.print("\n");
		 System.out.print("Time: " + running + " nanoseconds");
		 System.out.print("\n");
		 return array;
	}
	
	//Method to perform the binary sort on the unsorted array passed in.
	public static int [] BinarySort(int [] array)
	{
		long start_time;
		long running;
		long stop_time;
		
	    int ins, i, j;
	    int tmp, comparisons = 0, assignments = 0;
	    
	    //Starts timer.
	    start_time = System.nanoTime();
	    for (i = 1; i < 1000; i++) 
	    {
	    	//Call to the binary search method.
	        ins = BinarySearch (array, 0, i, array[i]);
	        comparisons++;
	        if (ins < i) 
	        {
	            tmp = array[i];
	            for (j = i - 1; j >= ins; j--)
	            {
	                array[j + 1] = array[j];
	                array[ins] = tmp;
	                assignments++;
	            }
	        }
	    }
	    //Stops timer and calculates the difference.
	    stop_time = System.nanoTime();
		running = (stop_time - start_time);
		
		//Prints how the binary sort perfoemed. 
		System.out.print("Comparissons: " + comparisons);
		System.out.print("\n");
		System.out.print("Assignments: " + assignments);
		System.out.print("\n");
		System.out.print("Time: " + running + " nanoseconds");
		System.out.print("\n");
	    return array;
	}
	
	//Method to perform the binary search for the binary sort performance.
	static int BinarySearch (int array[], int low, int high, int key)
	{
	    int mid;

	    if (low == high)
	        return low;

	    mid = low + ((high - low) / 2);

	    if (key > array[mid])
	        return BinarySearch (array, mid + 1, high, key);
	    else if (key < array[mid])
	        return BinarySearch (array, low, mid, key);

	    return mid;
	}
}
