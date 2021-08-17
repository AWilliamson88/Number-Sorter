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
public class Payroll_AnnualSalaries {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

// Must have a comparator.
// Must list the advantages and disadvantages of each sorting method.
        // List of random integers.
// List of integers between 1 and 10,000,000.
// At lease 100,000 Items in the list.
        LinkedList<Integer> payroll = new LinkedList<>();
        LinkedList<Integer> clone = new LinkedList<>();
        
        
        
        Random rnd = new Random();

        for (int i = 0; i <= 20; i++) {
            payroll.add(rnd.nextInt(10) + 1);
        }

        System.out.println("Finished");
        
        
        try {
// Payroll to decide  which sorting method they want to use.
            System.out.println("Wilcome to the Payroll Sorting Application.\n"
                    + "For Built-In sort enter B.\n"
                    + "For Merge sort enter M.\n"
                    + "For Quick sort enter Q.");

            String response = sc.next();

           
            
            
            switch (response) {
                case "b":
                case "B":
                    System.out.println("Built-In");
                    clone = (LinkedList) payroll.clone();
                    BuiltInSort bi = new BuiltInSort(clone);
                    
                    bi.UseBuiltInSort();
                    
                    bi.display();
                    break;
                case "m":
                case "M":
                    System.out.println("Merge sort");
                    MergeSort ms = new MergeSort();
                    clone = (LinkedList) payroll.clone();
                    ms.sort(clone);
                    ms.display();
                    break;
                case "q":
                case "Q":
                    System.out.println("Quick Sort");
                    QuickSort quickSort = new QuickSort();
                    clone = (LinkedList) payroll.clone();
                    quickSort.sort(clone);
                    quickSort.display();
                    break;
                default:
                    System.out.println("Please enter either A, M or Q.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("There was an exception " + e);
        }

// Sort in Style one with timer.
// Sort in style two with timer.
// Sort in style three with timer.
// Output the results.
    }

}
