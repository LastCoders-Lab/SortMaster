package xyz.lastcoderslab.sortmaster.manager.sorter;

public interface Sorter<T extends Comparable<? super T>> {
    public long getSortingTime();

    public long getSwapCount();

    public T[] getInputArray();

    public T[] getOutputArray();

    void sort(T[] inputArray);
}