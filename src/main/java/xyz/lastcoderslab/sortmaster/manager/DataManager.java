package xyz.lastcoderslab.sortmaster.manager;

import net.datafaker.Faker;
import xyz.lastcoderslab.sortmaster.entity.CompareMe;

import java.util.Arrays;
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

    public String dataToPrint(Comparable[] data) {

        if(data[0] instanceof Integer) {
            return Arrays.toString(getData());
        }

        String string = "";
        int last = data.length - 3;
        if(data.length > 10) {
            last = 5;
        }
        for(int i=0; i < last; i++) {
            string += "[" + i + "] " + data[i] + "\n";
        }
        if(data.length > 10) string += "...\n";
        for(int i= data.length-3; i < data.length; i++) {
            string += "[" + i + "] " + data[i] + "\n";
        }
       return string;
    }

    public String dataToPrint() {
        return dataToPrint(data);
    }

    public String dataToPrintFull(Comparable[] data) {
        if(data[0] instanceof Integer) {
            return Arrays.toString(getData());
        }

        String string = "";
        for(int i=0; i < data.length; i++) {
            string += "[" + i + "] " + data[i] + "\n";
        }
        return string;
    }

    public String dataToPrintFull() {
        return dataToPrintFull(data);
    }
}
