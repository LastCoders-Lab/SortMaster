package xyz.lastcoderslab.sortmaster.manager.sorter;

import java.util.ArrayList;
import java.util.List;

public class BinarySorter implements Sorter {
    @Override
    public List<Integer> sort(List<Integer> inputList) {
        if (inputList.size() <= 1) {
            return inputList;
        }
        List<Integer> result = new ArrayList<>(inputList);

        for (int i = 1; i < result.size(); i++) {
            Integer selected = result.get(i);
            int j = i - 1;
            int location = binarySearch(result, selected, 0, j);
            while (j >= location) {
                result.set(j + 1, result.get(j));
                j--;
            }
            result.set(j + 1, selected);
        }

        return result;
    }

    private static int binarySearch(List<Integer> inputList, Integer item, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (item.equals(inputList.get(mid))) {
                return mid + 1;
            } else if (item.compareTo(inputList.get(mid)) > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        BinarySorter sorter = new BinarySorter();
        ArrayList<Integer> inputList = new ArrayList<>();
        inputList.add(37);
        inputList.add(23);
        inputList.add(0);
        inputList.add(17);
        inputList.add(12);
        inputList.add(72);
        inputList.add(31);
        inputList.add(46);
        inputList.add(100);
        inputList.add(88);
        inputList.add(54);


        List<Integer> sortedList = sorter.sort(inputList);
        System.out.println("Original List: " + inputList);
        System.out.println("Sorted List: " + sortedList);
    }
}