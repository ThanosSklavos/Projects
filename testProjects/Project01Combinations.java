package gr.aueb.cf.projects.testProjects;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

 /**
 * Reads from file integers and prints at output txt file
 * all possible combinations after filtering each one.
 */
public class Project01Combinations {

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new FileReader("C:\\tmp\\Project01\\IntegerNumbers.txt"));
             PrintStream ps = new PrintStream("C:\\tmp\\Project01\\IntegerNumbersOutput.txt")) {

            int[] intArray = intArrayFromFile(bf);
            Arrays.sort(intArray);
            filteredCombinations(intArray, ps);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayStoreException e){
            e.printStackTrace();
            System.out.println("File has less than 7 integers, values not in range 1-49 or is empty");
        }
    }

    public static int[] intArrayFromFile(BufferedReader bf) throws IOException, ArrayStoreException {
        ArrayList<Integer> intList = new ArrayList<>();
        String line;
        String[] tokens;
        int[] intArr;

        while ((line = bf.readLine()) != null){
            tokens = line.split(" ");
            for (String token : tokens) {
                intList.add(Integer.parseInt(token));
            }
        }
       intArr = new int[intList.size()];

       for (int i = 0; i < intList.size(); i++) {
           intArr[i] = intList.get(i);

           if ((intArr[i] > 49) || (intArr[i] < 1)) throw new ArrayStoreException();
       }
       if (intList.size() <= 6) throw new ArrayStoreException();

       return intArr;
    }

    public static void filteredCombinations(int[] intArray, PrintStream ps) {
        final int N = 6;
        int[] row = new int[6];

        for (int i = 0; i <= intArray.length - N; i++) {
            for (int j = i + 1; j <= intArray.length - N + 1; j++) {
                for (int k = j + 1; k <= intArray.length - N + 2; k++) {
                    for (int l = k + 1; l <= intArray.length - N + 3; l++) {
                        for (int m = l + 1; m <= intArray.length - N + 4; m++) {
                            for (int n = m + 1; n < intArray.length; n++) {
                                row[0] = intArray[i];
                                row[1] = intArray[j];
                                row[2] = intArray[k];
                                row[3] = intArray[l];
                                row[4] = intArray[m];
                                row[5] = intArray[n];

                                if (maxEvenNumbers(row, 4) && maxOddNumbers(row, 4)
                                    && maxContinuousNumbers(row, 2) && maxSameLastNumNumbers(row, 3)
                                    && maxNumbersInSameDecade(row, 3)) {

                                    printToOutput(row, ps);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void printToOutput(int[] arr, PrintStream ps) {
        for (int item : arr) {
            ps.print(item + " ");
            System.out.print(item + " ");  //for testing purposes only
        }
        ps.println();
        System.out.println();  //for testing purposes only
    }

    public static boolean maxEvenNumbers(int[] row, int threshold) {
        int cnt = 0;

        for (int num : row) {
            if (num % 2 == 0) cnt++;
        }
        return cnt <= threshold;
    }

    public static boolean maxOddNumbers(int[] row, int threshold) {
        int cnt = 0;

        for (int num : row) {
            if (num % 2 != 0) cnt++;
        }
        return cnt <= threshold;
    }

    public static boolean maxContinuousNumbers(int [] row, int threshold) {
        int cnt = 0;

        for (int i = 0; i < row.length; i++) {
            for (int j = i; j < row.length; j++) {
                if ((row[i] + 1 == j) || (row[i] - 1 == j)) cnt++;
            }
        }
        return cnt <= threshold;
    }

    public static boolean maxSameLastNumNumbers(int [] row, int threshold) {
        int cnt = 0;

        for (int i = 0; i < row.length; i++) {
            for (int j = i + 1; j < row.length; j++) {
                if ((row[i] % 10) == (row[j] % 10)) cnt++;
            }
        }
        return cnt <= threshold;
    }

    public static boolean maxNumbersInSameDecade(int [] row, int threshold) {
        int cnt = 0;

        for (int i = 0; i < row.length; i++) {
            for (int j = i + 1; j < row.length; j++) {
                if ((row[i] / 10) == (row[j] / 10)) cnt++;
            }
        }
        return cnt <= threshold;
    }
}