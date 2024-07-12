package xyz.lastcoderslab.sortmaster.manager.sorter;

import java.util.List;

public class StrandSorter implements Sorter {

    @Override
    public void sort(List<Integer> array) {
        int left = 0;
        int right = array.size() - 1;

        while (left < right) {
            int i = left;
            int j = right;

            while (i < j) {
                if (array.get(i) > array.get(j)) {
                    swap(array, i, j);
                    i++;
                    j--;
                } else {
                    break;
                }
            }

            right = j;
        }
    }

    private void swap(List<Integer> array, int i, int j) {
        Integer temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
