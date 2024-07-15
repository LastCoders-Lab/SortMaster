package xyz.lastcoderslab.sortmaster.manager;

import xyz.lastcoderslab.sortmaster.entity.DataObject;
import xyz.lastcoderslab.sortmaster.manager.sorter.BinarySorter;
import xyz.lastcoderslab.sortmaster.manager.sorter.Sorter;
import xyz.lastcoderslab.sortmaster.manager.sorter.StrandSorter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortManager {
    private DataManager dataManager;

    private Map<String, Sorter> sorts = new HashMap<>();

    private List<Sorter> result;

    public SortManager(DataManager dataManager) {
        this.dataManager = dataManager;

        sorts.put("BinarySort", new BinarySorter());
        sorts.put("StrandSort", new StrandSorter());
    }

    public void doSort(String type) {
        Sorter sorter = sorts.get(type);
        //sorter.sort(dataManager.getData());
        int[]  ints = new int[10];
        Object[] objects = new DataObject[10];


        Comparable[] comparables = new DataObject[10];

        result.add(sorter);
    }

    public Map<String, Sorter> getSorts() {
        return sorts;
    }
}

