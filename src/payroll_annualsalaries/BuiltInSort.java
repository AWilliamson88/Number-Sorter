package payroll_annualsalaries;

import java.util.*;


/**
 *
 * @author Andrew
 */
public class BuiltInSort implements Comparator<Integer>{

    private LinkedList<Integer> list;
    private static long sortTime; 

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
    @Override
    public int compare(Integer a, Integer b) {
        
        if (a < b) {
            return -1;
        } else if (a > b) {
            return 1;
        }
        return 0; 
    }
    
}
