package xyz.lastcoderslab.sortmaster.manager.sorter;

import java.util.Arrays;

public class BinaryAdaptiveSorter implements AdaptiveSorter {
    private long startTime;
    private long endTime;
    private long swapCount;
    private Integer[] inputArray;
    private Integer[] sortedArray;

    public long getSortingTime() {
        return endTime - startTime;
    }

    public long getSwapCount() {
        return swapCount;
    }

    public Integer[] getInputArray() {
        return inputArray;
    }

    public Integer[] getOutputArray() {
        return sortedArray;
    }

    @Override
    public void sort(Integer[] inputArray, int mode) {
        this.inputArray = inputArray;
        swapCount = 0;
        startTime = System.nanoTime();
        int[] sortedArrayPrimitive;
        switch (mode) {
            case 0:
                sortedArrayPrimitive = innerSort(Arrays.stream(inputArray).mapToInt(Integer::intValue).toArray());
                sortedArray = Arrays.stream(sortedArrayPrimitive).boxed().toArray(Integer[]::new);
                break;
            case 1:
            case 2:
                sortedArrayPrimitive = adaptiveInnerSort(Arrays.stream(inputArray).mapToInt(Integer::intValue).toArray(), 2 - mode);
                sortedArray = Arrays.stream(sortedArrayPrimitive).boxed().toArray(Integer[]::new);
                break;
            default:
                break;
        }
        endTime = System.nanoTime();
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

    private int binarySearch(int[] inputArray, int item, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (item == inputArray[mid])
                return mid + 1;
            else if (item > inputArray[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }

    private int[] adaptiveInnerSort(int[] array, int mode) {
        int[] subarray = {};
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == mode) {
                subarray = addElement(subarray, array[i]);
                System.out.println(Arrays.toString(subarray));
                ;
            }
        }
        subarray = innerSort(subarray);
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == mode) {
                array[i] = subarray[j++];
            }
        }
        return array;
    }

    private int[] addElement(int[] array, int element) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;
        return newArray;
    }

}
