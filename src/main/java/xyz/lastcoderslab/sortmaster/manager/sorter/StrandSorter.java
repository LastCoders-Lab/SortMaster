package xyz.lastcoderslab.sortmaster.manager.sorter;

import java.util.Arrays;

public class StrandSorter<T extends Comparable<T>> implements Sorter<T> {
    private long startTime;
    private long endTime;
    private long swapCount;

    public long getSortingTime() {
        return endTime - startTime;
    }

    public long getSwapCount() {
        return swapCount;
    }

    @Override
    public T[] sort(T[] inputArray) {
        swapCount = 0;
        startTime = System.nanoTime();
        T[] sortedArray = innerSort(inputArray.clone());
        endTime = System.nanoTime();
        return sortedArray;
    }

    @SuppressWarnings("unchecked")
    private T[] innerSort(T[] array) {
        if (array.length <= 1) {
            return array;
        }

        T[] subarray = (T[]) new Object[0];
        subarray = addElement(subarray, array[0]);
        array = removeElement(array, 0);
        int i = 0;
        while (i < array.length) {
            if (array[i].compareTo(subarray[subarray.length - 1]) > 0) {
                subarray = addElement(subarray, array[i]);
                array = removeElement(array, i);
            } else {
                i++;
            }
        }

        return mergeArrays(subarray, innerSort(array));
    }

    @SuppressWarnings("unchecked")
    private T[] addElement(T[] array, T element) {
        swapCount++;
//        T[] newArray = new T[array.length - 1];
        T[] newArray = (T[]) new Object[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;
        return newArray;
    }

    @SuppressWarnings("unchecked")
    private T[] removeElement(T[] array, int index) {
//        T[] newArray = new T[array.length - 1];
        T[] newArray = (T[]) new Object[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        return newArray;
    }

    @SuppressWarnings("unchecked")
    private T[] mergeArrays(T[] array1, T[] array2) {
//        T[] result = new T[array1.length + array2.length];
        T[] result = (T[]) new Object[array1.length + array2.length];
        int i = 0, j = 0, k = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i].compareTo(array2[i]) <= 0) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }
        while (i < array1.length) {
            result[k++] = array1[i++];
        }
        while (j < array2.length) {
            result[k++] = array2[j++];
        }
        return result;
    }

    public static void main(String[] args) {
        BinarySorter<Integer> sorter = new BinarySorter<>();

//        int[] inputArray = {37, 23, 0, 0, 0, 54, 31, 46, 54, 88, 54};
//        int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Integer[] inputArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        Integer[] sortedArray = sorter.sort(inputArray);

        System.out.println("Original Array: " + Arrays.toString(inputArray));
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        System.out.println("Swap Count: " + sorter.getSwapCount());
        System.out.println("Sorting Time (nanoseconds): " + sorter.getSortingTime());
    }
}
