package me.myattaw.gameapp.options;

public enum NumberOption {

    NUMBER_VALUE("Number Value", 0, 100, 10, 45);

    private String label;
    private int minimum, maximum, increment, value;

    NumberOption(String label, int minimum, int maximum, int increment, int value) {
        this.label = label;
        this.minimum = minimum;
        this.maximum = maximum;
        this.increment = increment;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public int getIncrement() {
        return increment;
    }

    public int getValue() {
        return value;
    }
}
