package fi.arcada.codechallenge;

public class DataItem {
    private String name;
    private double value;

    public DataItem(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}
