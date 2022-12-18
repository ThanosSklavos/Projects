package gr.aueb.cf.projects;
import java.util.Arrays;

/**
 * shows difference between shallow copy and deep copy.
 */
public class Project03ArrayCopy {

    public static void main(String[] args) {
        int[][] array = {
                        {1, 2, 3},
                        {4, 5, 6},
                        };

        int[][] arrayShall = shallowCopy(array);
        int[][] arrayDeep = deepCopy(array);

        System.out.println("Original array: " + Arrays.deepToString(array));
        System.out.println("Shallow copy array: " + Arrays.deepToString(arrayShall));
        System.out.println("Deep copy array: " +  Arrays.deepToString(arrayDeep));

        System.out.println("\nChange value at original array[1][1] = 200\n");

        array[1][1] = 200;

        System.out.println("Original array: " + Arrays.deepToString(array));
        System.out.println("Shallow copy array: " + Arrays.deepToString(arrayShall));
        System.out.println("Deep copy array: " +  Arrays.deepToString(arrayDeep));
    }

    public static int[][] shallowCopy(int[][] array) {
        int[][] arr;
        return arr = Arrays.copyOf(array, array.length);
    }

    public static int[][] deepCopy(int[][] array) {
        int[][] arr = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                arr[i][j] = array[i][j];
            }
        }
        return arr;
    }
}
