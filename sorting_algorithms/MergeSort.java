package sorting_algorithms;

class MergeSort {

    static void mergeSort(int[] myArray) {
        int arrayLength = myArray.length; // Starting by setting the input length of my array

        // Since we are trying to sort an array with merge sort,
        // it is correct that when the array is split into single elements,
        // we just assume that each element is already sorted, so we return.
        if (arrayLength < 2) {
            return;
        }

        // So, if our array ends up having two or more elements, we continue:
        // First, we have to split the array into two arrays.
        int midIndex = arrayLength / 2;
        // Then, we create two arrays based on the midIndex.
        int[] leftHalf = new int[midIndex]; // This one has the length of the first half of the array.
        int[] rightHalf = new int[arrayLength - midIndex]; // This one has the length of the second half of the array.

        // Now, we are going to fill the left and right arrays with the left half and
        // right half of the original array, respectively.
        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = myArray[i];
        }
        for (int i = midIndex; i < arrayLength; i++) {
            rightHalf[i - midIndex] = myArray[i];
        }

        // So now we need to merge sort the array until it is completely split and each
        // element is sorted.
        // So we simply call the method itself recursively.
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // all we have to do now is merge the array completely
        merge(myArray, leftHalf, rightHalf);

    }

    // In this method, we need to walk through the left and right halves, compare
    // both, and then merge them into our merged array.
    private static void merge(int[] myArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i <= leftSize && j <= rightSize) {
            if (leftHalf[i] <= rightHalf[j]) { // If the element on the left is less than or equal to the element on the
                                               // right
                myArray[k] = leftHalf[i]; // Place the element from the left half in the merged array
                i++;
            } else {
                myArray[k] = rightHalf[j]; // Otherwise, place the element from the right half in the merged array
                j++;
            }
            k++;
        }

        // Now we need to sort the remaining elements that were not merged from both
        // sides
        while (i < leftSize) {
            myArray[k] = leftHalf[i];//fixed
            i++;
            k++;
        }
        while (j < rightSize) {
            myArray[k] = rightHalf[j];//fixed
            j++;
            k++;
        }
    }
}
