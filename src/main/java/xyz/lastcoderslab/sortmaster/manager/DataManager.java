package xyz.lastcoderslab.sortmaster.manager;

import net.datafaker.Faker;
import xyz.lastcoderslab.sortmaster.entity.DataObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataManager {
    private int[] dataArray;
    private int maxNumber = 1000;
    private Comparable data;

    public void createIntArray(int size) {
        dataArray = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++){
            dataArray[i] = rand.nextInt(maxNumber);
        }
    }

    public void createObjectsArray(int size) {
        Faker faker = new Faker();
        DataObject[] dataObjects = new DataObject[size];
        for(int i = 0; i < size; i++) {
            dataObjects[i] = DataObject.builder()
                    .stringValue(faker.name().name())
                    .intValue(faker.number().numberBetween(0, 1000))
                    .booleanValue(faker.random().nextBoolean())
                    .build();
        }
        //System.out.println(new ArrayList<>(List.of(dataObjects)));
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
