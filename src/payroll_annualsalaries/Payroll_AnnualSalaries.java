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
public class Payroll_AnnualSalaries {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Linked list for the payroll and the clone list for sorting.
        ArrayList<Integer> payroll = new ArrayList<>();
        ArrayList<Integer> clone = new ArrayList<>();

        Random rnd = new Random();

        // Fill the payroll list with numbers between 1 and 10,000,000
        for (int i = 0; i <= 100000; i++) {
            payroll.add(rnd.nextInt(10000000) + 1);
        }

        // Get the using input and start the sorting process.
        // user to decide  which sorting method they want to use.
        System.out.println("Wilcome to the Payroll Sorting Application.\n");

        String response;
        do {
            System.out.println("For Built-In sort enter B.\n"
                    + "For Merge sort enter M.\n"
                    + "For Quick sort enter Q.");
            // Get the user input
            response = sc.next();

            switch (response) {
                case "b":
                case "B":
                    System.out.println("Built-In");
                    clone = (ArrayList) payroll.clone();
                    BuiltInSort bi = new BuiltInSort(clone);
                    bi.UseBuiltInSort();
                    bi.display();
                    break;
                case "m":
                case "M":
                    System.out.println("Merge sort");
                    MergeSort ms = new MergeSort();
                    clone = (ArrayList) payroll.clone();
                    ms.sort(clone);
                    ms.display();
                    break;
                case "q":
                case "Q":
                    System.out.println("Quick Sort");
                    QuickSort quickSort = new QuickSort();
                    clone = (ArrayList) payroll.clone();
                    quickSort.sort(clone);
                    quickSort.display();
                    break;
                default:
                    break;
            }
            System.out.println();

        } while (response.equalsIgnoreCase("quit") != true);

        System.out.println("Thank you for using The Payroll Sorting Application.");
        System.out.println("Have a nice day.");
    }
}
