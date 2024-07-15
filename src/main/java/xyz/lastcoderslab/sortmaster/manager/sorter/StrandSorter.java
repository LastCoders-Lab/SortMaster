package xyz.lastcoderslab.sortmaster.manager.sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrandSorter implements Sorter {
    private long startTime;
    private long endTime;
    private long swapCount;

    @Override
    public List<Integer> sort(List<Integer> inputList) {
        return innerSort(new ArrayList<>(inputList));
    }

    private static List<Integer> innerSort(List<Integer> inputList) {
        if (inputList.size() <= 1) {
            return inputList;
        }
        List<Integer> sublist = new ArrayList<>();
        sublist.add(inputList.remove(0));
        int i = 0;
        while (i < inputList.size()) {
            if (inputList.get(i) > sublist.get(sublist.size() - 1)) {
                sublist.add(inputList.remove(i));
            } else {
                i++;
            }
        }
        return mergeLists(sublist, innerSort(inputList));
    }

    private static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        while (!list1.isEmpty() && !list2.isEmpty()) {
            if (list1.get(0).compareTo(list2.get(0)) <= 0) {
                result.add(list1.remove(0));
            } else {
                result.add(list2.remove(0));
            }
        }
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }


    @Override
    public int[] sort(int[] inputArray) {
        startTime = System.nanoTime();
        return innerSort(inputArray.clone());
    }

    public int[] innerSort(int[] inputArray) {
        if (inputArray.length <= 1) {
            endTime = System.nanoTime();
            return inputArray;
        }
        int[] subarray = new int[1];
        subarray[0] = inputArray[0];
        inputArray = removeElement(inputArray, 0);
        swapCount++;
        int i = 0;
        while (i < inputArray.length) {
            if (inputArray[i] > subarray[subarray.length - 1]) {
                subarray = addElement(subarray, inputArray[i]);
                inputArray = removeElement(inputArray, i);
                swapCount++;
            } else {
                i++;
            }
        }
        endTime = System.nanoTime();
        return mergeArrays(subarray, innerSort(inputArray));
    }

    private static int[] addElement(int[] array, int element) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;
        return newArray;
    }

    private static int[] removeElement(int[] array, int index) {
        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        return newArray;
    }

    private static int[] mergeArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
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

    public long getSortingTime() {
        return endTime - startTime;
    }

    public long getSwapCount() {
        return swapCount;
    }

    public static void main(String[] args) {
        BinarySorter sorter = new BinarySorter();
        ArrayList<Integer> inputList = new ArrayList<>();
        inputList.add(37);
        inputList.add(23);
        inputList.add(0);
        inputList.add(17);
        inputList.add(12);
        inputList.add(72);
        inputList.add(31);
        inputList.add(46);
        inputList.add(100);
        inputList.add(88);
        inputList.add(54);


        List<Integer> sortedList = sorter.sort(inputList);
        System.out.println("Original List: " + inputList);
        System.out.println("Sorted List: " + sortedList);

        System.out.println("-----------------------");

//        int[] inputArray = {37, 23, 0, 0, 0, 54, 31, 46, 54, 88, 54};
//        int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] inputArray = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] sortedArray = sorter.sort(inputArray);
        System.out.println("Original Array: " + Arrays.toString(inputArray));
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        System.out.println("Swap Count: " + sorter.getSwapCount());
        System.out.println("Sorting Time (nanoseconds): " + sorter.getSortingTime());
    }
}
