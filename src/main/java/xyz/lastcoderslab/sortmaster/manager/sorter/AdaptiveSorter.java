package xyz.lastcoderslab.sortmaster.manager.sorter;

public interface AdaptiveSorter {
    public long getSortingTime();

    public long getSwapCount();

    public Integer[] getInputArray();

    public Integer[] getOutputArray();

    void sort(Integer[] inputArray, int mode);
}
