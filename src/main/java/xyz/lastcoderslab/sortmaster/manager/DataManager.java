package xyz.lastcoderslab.sortmaster.manager;

import net.datafaker.Faker;
import xyz.lastcoderslab.sortmaster.entity.CompareMe;

import java.util.Random;

public class DataManager {
    private int maxNumber = 1000;
    private Comparable[] data;

    public void createIntArray(int size) {
        Comparable[] dataArray = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++){
            dataArray[i] = rand.nextInt(maxNumber);
        }
        setData(dataArray);
    }

    public void createObjectsArray(int size) {
        Faker faker = new Faker();
        Comparable[] dataObjects = new CompareMe[size];
        for(int i = 0; i < size; i++) {
            dataObjects[i] = CompareMe.builder()
                    .name(faker.name().name())
                    .score(faker.number().numberBetween(0, 1000))
                    .boss(faker.random().nextBoolean())
                    .build();
        }
        setData(dataObjects);
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
