package xyz.lastcoderslab.sortmaster.manager.sorter;

import java.util.ArrayList;
import java.util.List;

public interface Sorter {
    List<Integer> sort(List<Integer> inputList);

    int[] sort(int[] inputArray);
}
