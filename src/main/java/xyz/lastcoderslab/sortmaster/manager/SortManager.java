package xyz.lastcoderslab.sortmaster.manager;

public class SortManager {
    private DataManager dataManager;

    //private Map<String, Sorter> sorts = new HashMap<>();

    //private List<SortResult> sortResultList; // или Map, если понадобятся ключи для отбора

    public SortManager(DataManager dataManager) {
        this.dataManager = dataManager;

        //sorts.put("BinarySort", new BinarySorter());
        //sorts.put("StrandSort", new StrandSorter());
    }
}
