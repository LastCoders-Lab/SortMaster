package xyz.lastcoderslab.sortmaster.manager.sorter;

import java.util.Arrays;

public class BinarySorter<T extends Comparable<T>> implements Sorter<T> {
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

    private T[] innerSort(T[] array) {
        if (array.length <= 1) {
            return array;
        }

        for (int i = 1; i < array.length; i++) {
            T selected = array[i];
            int j = i - 1;
            int location = binarySearch(array, selected, 0, j);
            while (j >= location) {
                array[j + 1] = array[j];
                swapCount++;
                j--;
            }
            array[j + 1] = selected;
            swapCount++;
        }

        return array;
    }

    private <T extends Comparable<T>> int binarySearch(T[] array, T item, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (item.compareTo(array[mid]) == 0)
                return mid + 1;
            else if (item.compareTo(array[mid]) > 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }

    public static void main(String[] args) {
        BinarySorter<Integer> sorter = new BinarySorter<>();

//        int[] inputArray = {37, 23, 0, 0, 0, 54, 31, 46, 54, 88, 54};
//        int[] inputArray = {2, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Integer[] inputArray = {4, 3, 2, 1, 0, -1};
//        int[] inputArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        Integer[] sortedArray = sorter.sort(inputArray);

        System.out.println("Original Array: " + Arrays.toString(inputArray));
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        System.out.println("Swap Count: " + sorter.getSwapCount());
        System.out.println("Sorting Time (nanoseconds): " + sorter.getSortingTime());
    }
}
