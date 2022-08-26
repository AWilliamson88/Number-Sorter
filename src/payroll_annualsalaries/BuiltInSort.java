package payroll_annualsalaries;

import java.util.*;

/**
 * Andrew Williamson / P113357 
 * Date: 04/08/2021 
 * Java 3 Assessment 2 Question 3 –
 * 
 * You are required to make a list of different annual salaries for payroll in
 * whole numbers that will then need to be sorted, 
 * You should have alternate methods of sorting so that payroll can decide 
 *  on which method they would like to use.
 * 
 * Requirements:
 * You need to create an application that creates lists of integers 
 *  between 1 and 10 million. 
 * Sort in three different styles with timers to indicate the speed at which
 *  this happens. 
 * You must have at least 100,000 items in your list as the future business 
 *  strategy is to employ at least this many staff. 
 * Your sorting algorithm must have a comparator.
 * 1 sorting technique should use the inbuilt sorting the rest you 
 *  must write yourself. 
 *
 */
public class BuiltInSort implements Comparator<Integer> {

    private ArrayList<Integer> list;
    private static long sortTime;

    public BuiltInSort(ArrayList<Integer> newList) {
        list = newList;
    }

    // Where the sorting begins.
    public void UseBuiltInSort() {

        // Start the timer.
        long start = System.nanoTime();

        Collections.sort(getList());

        // End the timer and set the sort time.
        long finish = System.nanoTime();

        setSortTime(finish - start);
    }

    // Change sort time from nanoseconds to milliseconds.
    private static double toMilliseconds(long nanoseconds) {
        return (double) nanoseconds / 1000000;
    }

    // Overridden compare method.
    @Override
    public int compare(Integer a, Integer b) {
        return Integer.compare(a, b);
    }

    // Method to display the sorted list and the time taken.
    public void display() {

        for (var e : getList()) {
            System.out.println(e);
        }
        System.out.println("Built-in sort Time: " + toMilliseconds(getSortTime()) + " milliseconds.");
    }

    // Accessors.
    public ArrayList<Integer> getList() {
        return list;
    }

    private void setSortTime(long newSortTime) {
        sortTime = newSortTime;
    }

    private long getSortTime() {
        return sortTime;
    }
}
