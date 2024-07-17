package xyz.lastcoderslab.sortmaster.manager.sorter;

import java.lang.reflect.Array;

public class StrandSorter<T extends Comparable<? super T>> implements Sorter<T> {
    private long startTime;
    private long endTime;
    private long swapCount;
    private T[] inputArray;
    private T[] sortedArray;

    public long getSortingTime() {
        return endTime - startTime;
    }

    public long getSwapCount() {
        return swapCount;
    }

    public T[] getInputArray() {
        return inputArray;
    }

    public T[] getOutputArray() {
        return sortedArray;
    }

    @Override
    public void sort(T[] inputArray) {
        this.inputArray = inputArray;
        swapCount = 0;
        startTime = System.nanoTime();
        sortedArray = innerSort(inputArray.clone());
        endTime = System.nanoTime();
    }

    @SuppressWarnings("unchecked")
    private T[] innerSort(T[] array) {
        if (array.length <= 1) {
            return array;
        }

        T[] subarray = (T[]) Array.newInstance(array.getClass().getComponentType(), 0);
        subarray = addElement(subarray, array[0]);
        array = removeElement(array, 0);
        int i = 0;
        while (i < array.length) {
            if (array[i].compareTo(subarray[subarray.length - 1]) >= 0) {
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
        T[] newArray = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), array.length + 1);
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;
        return newArray;
    }

    @SuppressWarnings("unchecked")
    private T[] removeElement(T[] array, int index) {
        T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length - 1);
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        return newArray;
    }

    @SuppressWarnings("unchecked")
    private T[] mergeArrays(T[] array1, T[] array2) {
        T[] result = (T[]) Array.newInstance(array1.getClass().getComponentType(), array1.length + array2.length);
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

}
