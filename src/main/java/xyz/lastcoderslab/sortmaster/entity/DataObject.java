package xyz.lastcoderslab.sortmaster.entity;

public class DataObject implements Comparable{

    private final String stringValue;

    private final int intValue;

    private final boolean booleanValue;

    public DataObject(int intValue, String stringValue, boolean booleanValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
        this.booleanValue = booleanValue;
    }

    @Override
    public int compareTo(Object o) {
        //ToDo
        return 0;
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    public static DataObjectBuilder builder() {
        return new DataObjectBuilder();
    }

    public static class DataObjectBuilder {
        private int intValue;
        private String stringValue;
        private boolean booleanValue;

        public DataObjectBuilder intValue(int intValue) {
            this.intValue = intValue;
            return this;
        }

        public DataObjectBuilder stringValue(String stringValue) {
            this.stringValue = stringValue;
            return this;
        }

        public DataObjectBuilder booleanValue(boolean booleanValue) {
            this.booleanValue = booleanValue;
            return this;
        }

        public DataObject build() {
            return new DataObject(intValue, stringValue, booleanValue);
        }
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "stringValue='" + stringValue + '\'' +
                ", intValue=" + intValue +
                ", booleanValue=" + booleanValue +
                '}';
    }
}
