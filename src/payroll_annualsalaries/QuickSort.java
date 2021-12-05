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
public class QuickSort {

    private ArrayList<Integer> list;
    private int length;
    private long sortTime;

    public QuickSort() {

    }

    // Where the sorting starts.
    public void sort(ArrayList<Integer> unsortedList) {

        if (unsortedList != null || !unsortedList.isEmpty()) {

            long start = System.nanoTime();

            setList(unsortedList);
            length = list.size();
            UseQuickSort(0, length - 1);

            long finish = System.nanoTime();

            setSortTime(finish - start);
        }
    }

    // Does the actual sorting.
    private void UseQuickSort(int low, int high) {

        int i = low;
        int j = high;

        ArrayList<Integer> sortList = GetList();
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
    }

    // Does the swapping 
    private void exchange(int i, int j) {

        ArrayList<Integer> sortList = GetList();

        int temp = sortList.get(i);
        sortList.set(i, sortList.get(j));
        sortList.set(j, temp);
    }

    // Change sort time from nano seconds to miliseconds.
    private static double toMilliseconds(long nanoseconds) {
        return (double) nanoseconds / 1000000;
    }

    // Display the sorted list and the sort time.
    public void display() {

        for (var e : GetList()) {
            System.out.println(e);
        }
        System.out.println("Quick sort Time: " + toMilliseconds(getSortTime()));
    }

    // Accessor
    public ArrayList<Integer> GetList() {
        return list;
    }

    public void setList(ArrayList<Integer> newList) {
        list = newList;
    }

    private void setSortTime(long newSortTime) {
        sortTime = newSortTime;
    }
    
    private long getSortTime() {
        return sortTime;
    }
}
