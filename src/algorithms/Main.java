package algorithms;

public class Main {

    public static void main(String[] args) {

        /**  initialize unsorted array with assigned elements **/
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };


        //  for printing only
        for (int num: intArray) { System.out.print(num + "  "); }
        System.out.print("\n");


        /**     calls mergeSort method      **/
        mergeSort(intArray, 0, intArray.length);


        //  for printing only
        for (int num: intArray) { System.out.print(num + "  "); }
        System.out.print("\n");
    }

/**
 * MERGE SORT ALGORITHM
 **/
    public static void mergeSort(int[] input, int start, int end) {

        /**     { 20, 35, -15, 7, 55, 1, -22 }   **/

        /**
         *      BASECASE:
         *          When end - start < 2 it means the array is 1 element in length and further division isn't
         *          possible.
         **/
        if (end - start < 2) { return; }

        /**
         *      --int mid sets the index of the mid point in the array to be divided
         *          initially: (0 + 7) / 2 = 3
         **/
        int mid = (start + end) / 2;

        /**
         *      RECURSIVE CALLS
         *          mergeSort(input, start, mid) -- recursively calls the left partition of the array
         *          mergeSort(input, mid, end)   -- recursively calls the right partition of the array
         **/
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);

        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end) {

        /**     { 20, 35, -15, 7, 55, 1, -22 }   **/

        /**
         *      BASECASE
         *          At this point the array partitions are sorted and they are being merged as left/right
         *          partitions. If the rightmost element in the left array is <= to the leftmost element in
         *          the right array, the combined arrays are sorted.
         **/
        if (input[mid - 1] <= input[mid]) { return; }


        /**
         *      VARIABLES
         *          --int start     -- the first element of the array
         *          --int end       -- the last element of the array
         *          --int tempIndex -- index placeholder
         *          --int[] temp    -- temporary array to copy ordered elements from sub arrays
         **/
        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        System.out.print(i + " || " + j + " || " + end + "\n");


        /**
         *      WHILE LOOP, given { 20, 35, -15, 7, 55, 1, -22 }
         *
         *      { __ | __ }
         *
         **/
        while (i < mid && j < end) {
            System.out.print(temp[tempIndex] + "  " + input[i] + "  " + input[j]);
            System.out.print("\n");

            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];

            for (int num: temp) { System.out.print(num + "  "); }
        }

        System.out.println("\n");
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

/** END **/
}
