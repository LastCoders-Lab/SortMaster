package xyz.lastcoderslab.sortmaster.manager.sorter;

public interface Sorter<T extends Comparable<T>> {
    T[] sort(T[] inputArray);
}
