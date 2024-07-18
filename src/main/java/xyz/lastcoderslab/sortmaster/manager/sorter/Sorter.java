package xyz.lastcoderslab.sortmaster.manager.sorter;

public interface Sorter<T extends Comparable<? super T>> {
    String getName();
    long getSortingTime();

    long getSwapCount();

    T[] getInputArray();

    T[] getOutputArray();

    void sort(T[] inputArray, int mode);
}