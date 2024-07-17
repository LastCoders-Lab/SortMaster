package xyz.lastcoderslab.sortmaster.manager.sorter;

import java.util.Arrays;

public class StrandAdaptiveSorter implements AdaptiveSorter {
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

        int[] subarray = {};
        subarray = addElement(subarray, array[0]);
        array = removeElement(array, 0);
        int i = 0;
        while (i < array.length) {
            if (array[i] > subarray[subarray.length - 1]) {
                subarray = addElement(subarray, array[i]);
                array = removeElement(array, i);
            } else {
                i++;
            }
        }

        return mergeArrays(subarray, innerSort(array));
    }

    private int[] addElement(int[] array, int element) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;
        return newArray;
    }

    private int[] removeElement(int[] array, int index) {
        swapCount++;
        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        return newArray;
    }

    private int[] mergeArrays(int[] array1, int[] array2) {
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

    private int[] adaptiveInnerSort(int[] array, int mode) {
        int[] subarray = {};
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == mode) {
                subarray = addElement(subarray, array[i]);
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

}
