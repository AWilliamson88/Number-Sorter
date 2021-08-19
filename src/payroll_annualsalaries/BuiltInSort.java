package payroll_annualsalaries;

import java.util.*;


/**
 * Andrew Williamson / P113357 Date: 04/08/2021 Java 3 Assessment 2 Question 3 –
 * You are required to make a list of different annual salaries for payroll in
 * whole numbers (integers) that will then need to be sorted, you should have
 * alternate methods of sorting so that payroll can decide on which method they
 * would like to use. You need to create an application that creates lists of
 * integers between 1 and 10 million. Your application must have the ability to
 * sort in three different styles with timers to indicate the speed at which
 * this happens you must have at least 100,000 items in your list as this the
 * future business strategy to employ at least this many staff. The current
 * system is only able to handle 12 staff. Only 1 sorting technique may use the
 * inbuilt sorting the rest you must write yourself. In addition, you must list
 * the advantages and disadvantages of each algorithm. Your sorting algorithm
 * must have a comparator.
 *
 */
public class BuiltInSort implements Comparator<Integer>{

    private LinkedList<Integer> list;
    private static long sortTime; 

    public BuiltInSort(LinkedList<Integer> newList) {
        list = newList;
    }

    // Where the sorting begins.
    public void UseBuiltInSort() {

        // Start the timer.
         long start = System.nanoTime();

         
        Collections.sort(GetList());
        
        // End the timer and set the sort time.
        long finish = System.nanoTime();
        
        setSortTime(finish - start);
    }
    
    // Change sort time from nano seconds to miliseconds.
    public static double toMilliseconds(long nanoseconds) {
        return (double)nanoseconds / 1000000;
    }
    
    // Utterly pontly compare method just because the assessment asks for it.
    @Override
    public int compare(Integer a, Integer b) {
        
        if (a < b) {
            return -1;
        } else if (a > b) {
            return 1;
        }
        return 0; 
    }

    // Method to display the sorted list and the time taken.
    public void display() {

        for (var e : GetList()) {
            System.out.println(e);
        }
        System.out.println("Merge sort Time: " + toMilliseconds(getSortTime()));
    }

    // Accessors.
    public LinkedList<Integer> GetList() {
        return list;
    }
    
    private void setSortTime(long newSortTime) {
        sortTime = newSortTime;
    }
    
    private long getSortTime() {
        return sortTime;
    }
    
    
}
