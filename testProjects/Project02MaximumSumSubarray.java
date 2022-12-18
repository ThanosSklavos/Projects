package gr.aueb.cf.projects.testProjects;

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
