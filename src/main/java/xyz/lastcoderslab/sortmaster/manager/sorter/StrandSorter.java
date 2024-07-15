package xyz.lastcoderslab.sortmaster.manager.sorter;

import java.util.ArrayList;
import java.util.List;

public class StrandSorter implements Sorter {

    @Override
    public List<Integer> sort(List<Integer> inputList) {
        if (inputList.size() <= 1) {
            return inputList;
        }
        List<Integer> sublist = new ArrayList<>();
        sublist.add(inputList.remove(0));
        int i = 0;
        while (i < inputList.size()) {
            if(inputList.get(i) > sublist.get(sublist.size() - 1)) {
                sublist.add(inputList.remove(i));
            } else {
                i++;
            }
        }

        List<Integer> sortedSublist = new ArrayList<>(sublist);
        List<Integer> remainingList = sort(inputList);

        return mergeLists(sortedSublist, remainingList);
    }

    private static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        while (!list1.isEmpty() && !list2.isEmpty()) {
            if (list1.get(0).compareTo(list2.get(0)) <= 0) {
                result.add(list1.remove(0));
            } else {
                result.add(list2.remove(0));
            }
        }
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }

    public static void main(String[] args) {
        StrandSorter sorter = new StrandSorter();
        ArrayList<Integer> inputList = new ArrayList<>();
        inputList.add(14);
        inputList.add(73);
        inputList.add(28);
        inputList.add(42);
        inputList.add(91);
        inputList.add(19);
        inputList.add(85);
        inputList.add(67);
        inputList.add(31);
        inputList.add(56);
        inputList.add(98);

        System.out.println("Original List: " + inputList);
        List<Integer> sortedList = sorter.sort(inputList);
        System.out.println("Original List: " + inputList);
        System.out.println("Sorted List: " + sortedList);
    }
}
