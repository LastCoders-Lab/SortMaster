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
}
