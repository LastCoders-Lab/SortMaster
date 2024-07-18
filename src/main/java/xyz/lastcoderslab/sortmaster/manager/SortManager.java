package xyz.lastcoderslab.sortmaster.manager;

import xyz.lastcoderslab.sortmaster.entity.CompareMe;
import xyz.lastcoderslab.sortmaster.manager.sorter.BinarySorter;
import xyz.lastcoderslab.sortmaster.manager.sorter.Sorter;
import xyz.lastcoderslab.sortmaster.manager.sorter.StrandSorter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortManager {
    private DataManager dataManager;

    private Map<String, Sorter> sorts = new HashMap<>();

    private List<Sorter> result = new ArrayList<>();

    private static SortManager instance = null;

    private SortManager(DataManager dataManager) {
        this.dataManager = dataManager;

        sorts.put("BinarySort", new BinarySorter<>());
        sorts.put("StrandSort", new StrandSorter<>());
    }

    public static SortManager getInstance(DataManager dataManager) {
        if(instance == null) {
            instance = new SortManager(dataManager);
        }
        return instance;
    }

    public Sorter doSort(String type, int flag) {
        if(!sorts.containsKey(type)) {
            throw new IllegalArgumentException("Invalid argument");
        }
        Sorter sorter = sorts.get(type);
        sorter.sort(dataManager.getData(), flag);
        result.add(sorter);
        return sorter;
    }


    public Map<String, Sorter> getSorts() {
        return sorts;
    }
}

