package xyz.lastcoderslab.sortmaster.manager.sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySorter implements Sorter {
    private long startTime;
    private long endTime;
    private long swapCount;

//    @Override
//    public List<Integer> sort(List<Integer> inputList) {
//        if (inputList.size() <= 1) {
//            return inputList;
//        }
//        List<Integer> result = new ArrayList<>(inputList);
//
//        for (int i = 1; i < result.size(); i++) {
//            Integer selected = result.get(i);
//            int j = i - 1;
//            int location = binarySearch(result, selected, 0, j);
//            while (j >= location) {
//                result.set(j + 1, result.get(j));
//                j--;
//            }
//            result.set(j + 1, selected);
//        }
//
//        return result;
//    }
//
//    private static int binarySearch(List<Integer> inputList, Integer item, int left, int right) {
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (item.equals(inputList.get(mid))) {
//                return mid + 1;
//            } else if (item.compareTo(inputList.get(mid)) > 0) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//
//        return left;
//    }

    @Override
    public int[] sort(int[] inputArray) {
        swapCount = 0;
        startTime = System.nanoTime();
        int[] sortedArray = innerSort(inputArray.clone());
        endTime = System.nanoTime();
        return sortedArray;
    }

    private int[] innerSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        for (int i = 1; i < array.length; i++) {
            int selected = array[i];
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

    static int binarySearch(int[] array, int item, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (item == array[mid])
                return mid + 1;
            else if (item > array[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }

    public long getSortingTime() {
        return endTime - startTime;
    }

    public long getSwapCount() {
        return swapCount;
    }

    public static void main(String[] args) {
        BinarySorter sorter = new BinarySorter();
//        ArrayList<Integer> inputList = new ArrayList<>();
//        inputList.add(37);
//        inputList.add(23);
//        inputList.add(0);
//        inputList.add(17);
//        inputList.add(12);
//        inputList.add(72);
//        inputList.add(31);
//        inputList.add(46);
//        inputList.add(100);
//        inputList.add(88);
//        inputList.add(54);
//
//
//        List<Integer> sortedList = sorter.sort(inputList);
//        System.out.println("Original List: " + inputList);
//        System.out.println("Sorted List: " + sortedList);
//
//        System.out.println("-----------------------");

//        int[] inputArray = {37, 23, 0, 0, 0, 54, 31, 46, 54, 88, 54};
//        int[] inputArray = {2, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] inputArray = {4, 3, 2, 1, 0, -1};

//        int[] inputArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] sortedArray = sorter.sort(inputArray);
        System.out.println("Original Array: " + Arrays.toString(inputArray));
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        System.out.println("Swap Count: " + sorter.getSwapCount());
        System.out.println("Sorting Time (nanoseconds): " + sorter.getSortingTime());
    }
}
