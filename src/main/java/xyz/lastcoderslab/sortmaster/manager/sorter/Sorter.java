package xyz.lastcoderslab.sortmaster.manager.sorter;

public interface Sorter<T extends Comparable<? super T>> {
    long getSortingTime();

    long getSwapCount();

    T[] getInputArray();

    T[] getOutputArray();

    void sort(T[] inputArray);
}