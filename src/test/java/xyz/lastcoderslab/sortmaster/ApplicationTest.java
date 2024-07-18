package xyz.lastcoderslab.sortmaster;

import org.junit.jupiter.api.Test;
import xyz.lastcoderslab.sortmaster.manager.DataManager;
import xyz.lastcoderslab.sortmaster.manager.SortManager;
import xyz.lastcoderslab.sortmaster.manager.sorter.BinarySorter;
import xyz.lastcoderslab.sortmaster.manager.sorter.Sorter;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void mainTest() {
        DataManager dataManager = new DataManager();
        SortManager sortManager = new SortManager(dataManager);

        Sorter sorter;

//        dataManager.createIntArray(10);
//        System.out.println(dataManager.dataToPrint());
//
//        sorter = sortManager.doSort("BinarySort");
//        System.out.println(DataManager.dataToPrint(sorter.getOutputArray()));

        dataManager.createObjectsArray(10);
        System.out.println(dataManager.dataToPrint());

        sorter = sortManager.doSort("StrandSort", 0);
        System.out.println(DataManager.dataToPrint(sorter.getOutputArray()));

    }
}