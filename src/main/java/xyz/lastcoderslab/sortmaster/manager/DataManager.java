package xyz.lastcoderslab.sortmaster.manager;

import net.datafaker.Faker;
import xyz.lastcoderslab.sortmaster.entity.CompareMe;

import java.util.Random;

public class DataManager {
    private int maxNumber = 1000;
    private Comparable[] data;

    public Comparable[] createIntArray(int size) {
        Comparable[] dataArray = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++){
            dataArray[i] = rand.nextInt(maxNumber);
        }
        setData(dataArray);
        return dataArray;
    }

    public Comparable[] createObjectsArray(int size) {
        Faker faker = new Faker();
        Comparable[] dataObjects = new CompareMe[size];
        for(int i = 0; i < size; i++) {
            dataObjects[i] = CompareMe.builder()
                    .name(faker.name().name())
                    .score(faker.number().numberBetween(0, 1000))
                    .boss(Math.random() < 0.2 ? true : false)
                    .build();
        }
        for(Comparable obj : dataObjects) {
            System.out.println(obj);
        }
        setData(dataObjects);
        return dataObjects;
     }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Comparable[] getData() {
        return data;
    }

    public void setData(Comparable[] data) {
        this.data = data;
    }
}
