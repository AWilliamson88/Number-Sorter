package payroll_annualsalaries;

import java.util.*;

public class QuickSort {

    private LinkedList<Integer> list;
    private int length;
    private long sortTime; // Need method to start the timer and method to stop the timer and return the time.

    public QuickSort() {

    }

    public void sort(LinkedList<Integer> sortList) {

        if (sortList != null || !sortList.isEmpty()) {

            long start = System.nanoTime();

            list = sortList;
            length = list.size();
            UseQuickSort(0, length - 1);

            // End the timer and set the sort time.
            long finish = System.nanoTime();

            setSortTime(finish - start);

        }

    }

    private void UseQuickSort(int low, int high) {

        int i = low;
        int j = high;

        LinkedList<Integer> sortList = GetList();
        int pivot = sortList.get(low + (high - low) / 2);

        while (i <= j) {

            while (sortList.get(i) < pivot) {
                i++;
            }

            while (sortList.get(j) > pivot) {
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            UseQuickSort(low, j);
        }
        if (i < high) {
            UseQuickSort(i, high);
        }

        // Start the timer.
        // Stop the timer.
        // Display the details.
    }

    private void exchange(int i, int j) {

        LinkedList<Integer> sortList = GetList();

        int temp = sortList.get(i);
        sortList.set(i, sortList.get(j));
        sortList.set(j, temp);
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

    // Method to 
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
