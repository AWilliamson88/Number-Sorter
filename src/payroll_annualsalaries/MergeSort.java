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
 *
 * Merge Sort code by: 
 * https://favtutor.com/blogs/sorting-algorithms-java Date: 04/02/2021
 * Modifications by 
 * Name: Andrew Williamson  Date: 14/08/2021
 * 
 */
public class MergeSort {

    private static LinkedList<Integer> list;
    private static long sortTime; 

    public MergeSort() {}

    // Where the sorting starts.
    public void sort(LinkedList<Integer> unsortedList) {

        if (!(unsortedList == null || unsortedList.isEmpty())) {
            
            long start = System.nanoTime();
            
            setList(unsortedList);
            mergeSort(list, 0, list.size() - 1);
            
            // End the timer and set the sort time.
            long finish = System.nanoTime();

            setSortTime(finish - start);
        }

    }

    // Separates this list into sub lists.
    private void mergeSort(LinkedList<Integer> sortList, int left, int right) {

        int mid;
        if (left < right) {
            mid = (left + right) / 2;

            mergeSort(sortList, left, mid);
            mergeSort(sortList, mid + 1, right);

            merge(sortList, left, mid, right);
        }

    }

    // Does the sorting and merging.
    private void merge(
            LinkedList<Integer> sortList, int left, int mid, int right) {

        int low = mid - left + 1;
        int high = right - mid;
        
        LinkedList<Integer> l = new LinkedList<>();
        LinkedList<Integer> r = new LinkedList<>();
        int i = 0;
        int j = 0;
        
        for (i = 0; i < low; i++) {
            
            if (i >= l.size()) {
                l.add(i, sortList.get(left + i));
            } else {
             l.set(i, sortList.get(left + i));   
            }
        }
        
        for (j = 0; j < high; j++) {
            
            if (j >= r.size()) {
                r.add(j, sortList.get(mid + 1 + j));
            } else {
                r.set(j, sortList.get(mid + 1 + j));
            }
        }
        
        int k = left;
        i = 0;
        j = 0;
        
        while (i < low && j < high) {
            
            if (l.get(i) <= r.get(j)) {
                sortList.set(k, l.get(i));
                i++;
            }
            else {
                sortList.set(k, r.get(j));
                j++;
            }
            
            k++;
        }
        while (i < low) {
            sortList.set(k, l.get(i));
            i++;
            k++;
        }
        while (j < high) {
            sortList.set(k, r.get(j));
            j++;
            k++;
        }
    }
    
    // Change sort time from nano seconds to miliseconds.
    public static double toMilliseconds(long nanoseconds) {
        return (double)nanoseconds / 1000000;
    }
    
    // Display the sorted list and the time taken.
    public void display() {
        
        for (var e : GetList()) {
            System.out.println(e);
        }

        System.out.println("Merge sort Time: " + toMilliseconds(getSortTime()));
    }
    
    // Accessors
    public LinkedList<Integer> GetList() {
        return list;
    }
    
    public void setList(LinkedList<Integer> newList) {
        list = newList;
    }
    
    private void setSortTime(long newSortTime) {
        sortTime = newSortTime;
    }
    private long getSortTime() {
        return sortTime;
    }
}
