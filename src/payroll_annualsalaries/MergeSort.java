package payroll_annualsalaries;

import java.util.*;

/**
 *
 * @author Andrew
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
    private static long sortTime; // Need method to start the timer and method to stop the timer and return the time.


    public MergeSort() {}

    public void sort(LinkedList<Integer> sortList) {

        if (!(sortList == null || sortList.isEmpty())) {
            
            long start = System.nanoTime();
            
            list = sortList;
            mergeSort(list, 0, list.size() - 1);
            
            // End the timer and set the sort time.
            long finish = System.nanoTime();

            setSortTime(start - finish);
        }

    }

    private void mergeSort(LinkedList<Integer> sortList, int left, int right) {

        int mid;
        if (left < right) {
            mid = (left + right) / 2;

            mergeSort(sortList, left, mid);
            mergeSort(sortList, mid + 1, right);

            merge(sortList, left, mid, right);
        }

    }

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
    
    public LinkedList<Integer> GetList() {
        return list;
    }
    
    public void display() {
        
        for (var e : GetList()) {
            System.out.println(e);
        }
    }
    
    private void setSortTime(long newSortTime) {
        sortTime = newSortTime;
    }
}
