package xyz.lastcoderslab.sortmaster.manager.sorter;

public class BinarySorter<T extends Comparable<? super T>> implements Sorter<T> {

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

    private int binarySearch(T[] array, T item, int left, int right) {
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

}