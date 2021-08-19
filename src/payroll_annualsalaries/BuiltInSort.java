package payroll_annualsalaries;

import java.util.*;
import static payroll_annualsalaries.MergeSort.toMilliseconds;

/**
 *
 * @author Andrew
 */
public class BuiltInSort {

    private LinkedList<Integer> list;
    private static long sortTime; // Need method to start the timer and method to stop the timer and return the time.

    public BuiltInSort(LinkedList<Integer> newList) {
        list = newList;

    }

    public void UseBuiltInSort() {

        // Start the timer.
         long start = System.nanoTime();

         
        Collections.sort(list);
        
        // End the timer and set the sort time.
        long finish = System.nanoTime();
        
        setSortTime(finish - start);
    }

    public LinkedList<Integer> GetList() {
        return list;
    }

    public void display() {

        for (var e : GetList()) {
            System.out.println(e);
        }
        System.out.println("Merge sort Time: " + toMilliseconds(getSortTime()));
    }

    private void setSortTime(long newSortTime) {
        sortTime = newSortTime;
    }
    
    private long getSortTime() {
        return sortTime;
    }
    
    // Change sort time from nano seconds to miliseconds.
    public static double toMilliseconds(long nanoseconds) {
        return (double)nanoseconds / 1000000;
    }
}
