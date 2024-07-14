package xyz.lastcoderslab.sortmaster.manager;

import java.util.Random;

public class DataManager {
    private int[] dataArray;
    private int maxNumber = 1000;

    public void createBySize(int size) {
        dataArray = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++){
            dataArray[i] = rand.nextInt(maxNumber);
        }
    }

    public int[] getDataArray() {
        return dataArray;
    }

    public void setDataArray(int[] dataArray) {
        this.dataArray = dataArray;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
}
