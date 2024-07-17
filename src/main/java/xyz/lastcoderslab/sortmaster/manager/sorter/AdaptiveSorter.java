package xyz.lastcoderslab.sortmaster.manager.sorter;

public interface AdaptiveSorter {
    long getSortingTime();

    long getSwapCount();

    Integer[] getInputArray();

    Integer[] getOutputArray();

    void sort(Integer[] inputArray, int mode);
}
