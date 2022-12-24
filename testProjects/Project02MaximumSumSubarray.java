package gr.aueb.cf.projects.testProjects;

/** Η πολυπλοκότητα χρόνου είναι O(n) γιατί χρησιμοποιούμε μόνο μία for.
 *  Διατρέχουμε τον πίνακα από την αρχή κρατόντας το μέγιστο άθροισμα από την αρχή μέχρι το σημείο που
 *  βρίσκεται το i και συγκρίνουμε με τον επόμενο αριθμό στον πίνακα
 */
public class Project02MaximumSumSubarray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int max = arr[0];
        int localMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            localMax = Math.max(localMax + arr[i], arr[i]);
            if (localMax > max) max = localMax;
        }

        System.out.println("The highest max value of each subarray is: " + max);
    }
}
