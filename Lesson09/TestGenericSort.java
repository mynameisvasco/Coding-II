import static java.lang.System.*;
import java.util.Scanner;
import java.util.Arrays;

import static p2utils.Sorting.*;  // import sorting methods

public class TestGenericSort {

  static final Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    // Read integers from input into an array:
    String[] array = args;

    // Make a copy of the array:
    String[] array2 = array.clone();

    // Sort the first n elements in the array with our algorithm:
    mergeSort(array, 0, array.length);
    
    // Print the result:
    out.println(Arrays.toString(array));

    // Sort the second array with Java's sort method and use it to check ours:
    Arrays.sort(array2);
    assert Arrays.equals(array, array2);
  }
}

