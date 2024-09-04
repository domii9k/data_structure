package sorting_algorithms;

import java.util.Random;

public class QuickSort {

    public static void quickSort(int[] myArray) {
        quickSort(myArray, 0, myArray.length - 1);
    }

    /*
     * Here, the method actually needs three parameters. Since the array will place
     * all elements lower than the pivot on the left and all elements higher than
     * the pivot on the right, it creates two subarrays: left and right. Later on,
     * we will need to recursively quicksort each of these subarrays, which is why
     * we need lowIndex and highIndex!
     */
    private static void quickSort(int[] myArray, int lowIndex, int highIndex) {
        // If the method needs to sort a subarray with only one element, we simply
        // return because there's nothing else to do.
        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = myArray[pivotIndex]; // choosing our pivot based on the random element
        swap(myArray, pivotIndex, highIndex); // we swap the random pivot so it can be at the end of the array

        int leftPointer = partition(myArray, lowIndex, highIndex, pivot);

        // recursively quicksorting the subarrays
        quickSort(myArray, lowIndex, leftPointer - 1);
        quickSort(myArray, leftPointer + 1, highIndex);
    }

    /*
     * This method will help us put all the higher elements on the
     * right and all the lower elements on the left of the pivot.
     */
    private static int partition(int[] myArray, int lowIndex, int highIndex, int pivot) {
        /*
         * These variables will help us traverse the array (excluding the pivot) and
         * determine which elements are higher or lower than the pivot.
         */
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        /*
         * Here, we'll traverse the array until we find the pointers that are greater
         * and lower than the pivot, and then we'll swap them.
         * In the end, if both pointers are pointing to the same index, we swap it with
         * the pivot, which finally ensures that all the higher elements are on the
         * right and all the lower elements are on the left of the pivot.
         */
        while (leftPointer < rightPointer) {
            while (myArray[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (myArray[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(myArray, leftPointer, rightPointer);
        }

        if (myArray[leftPointer] > myArray[highIndex]) {
            swap(myArray, leftPointer, highIndex);
        } else {
            leftPointer = highIndex;
        }
        return leftPointer;
    }

    /*
     * This method will help us swap the left and right indexes after we determine
     * which element is greater and which is lower than the pivot.
     */
    private static void swap(int[] myArray, int index1, int index2) {
        int helper = myArray[index1];
        myArray[index1] = myArray[index2];
        myArray[index2] = helper;
    }
}
