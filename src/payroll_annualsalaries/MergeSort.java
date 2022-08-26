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
public class MergeSort {

    private static ArrayList<Integer> list;
    private static long sortTime;

    public MergeSort() {
    }

    // Where the sorting starts.
    public void sort(ArrayList<Integer> unsortedList) {

        if (!(unsortedList == null || unsortedList.isEmpty())) {

            long start = System.nanoTime();

            setList(unsortedList);
            mergeSort(0, GetList().size() - 1);

            // End the timer and set the sort time.
            long finish = System.nanoTime();

            setSortTime(finish - start);
        }

    }

    // Separates this list into sub lists.
    private void mergeSort(int startIndex, int endIndex) {

        if (startIndex < endIndex && (endIndex - startIndex) >= 1) {

            int mid = (endIndex + startIndex) / 2;

            mergeSort(startIndex, mid);
            mergeSort(mid + 1, endIndex);

            merge(startIndex, mid, endIndex);
        }

    }

    // Does the sorting and merging.
    private void merge(int startIndex, int midIndex, int endIndex) {

        ArrayList<Integer> sortedArray = new ArrayList<>();

        int leftIndex = startIndex;
        int rightIndex = midIndex + 1;

        while (leftIndex <= midIndex && rightIndex <= endIndex) {

            if (GetList().get(leftIndex) <= GetList().get(rightIndex)) {
                sortedArray.add(GetList().get(leftIndex));
                leftIndex++;
            } else {
                sortedArray.add(GetList().get(rightIndex));
                rightIndex++;
            }
        }

        while (leftIndex <= midIndex) {
            sortedArray.add(GetList().get(leftIndex));
            leftIndex++;
        }
        while (rightIndex <= endIndex) {
            sortedArray.add(GetList().get(rightIndex));
            rightIndex++;
        }

        int j = startIndex;
        for (int i = 0; i < sortedArray.size(); i++) {
            GetList().set(j, sortedArray.get(i));
            j++;
        }
    }

    // Change sort time from nano seconds to miliseconds.
    private static double toMilliseconds(long nanoseconds) {
        return (double) nanoseconds / 1000000;
    }

    // Display the sorted list and the time taken.
    public void display() {

        for (var e : GetList()) {
            System.out.println(e);
        }

        System.out.println("Merge sort Time: " + toMilliseconds(getSortTime()) + " milliseconds.");
    }

    // Accessors
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
