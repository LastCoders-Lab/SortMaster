package xyz.lastcoderslab.sortmaster.manager.sorter;

import java.util.ArrayList;
import java.util.List;

public interface Sorter {
    public List<Integer> sort(List<Integer> inputList);

    public int[] sort(int[] inputArray);
}
