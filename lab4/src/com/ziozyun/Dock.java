package com.ziozyun;

public class Dock {
    private String name;
    private int numberOfBoxes;

    public Dock(String name, int numberOfBoxes) {
        super();
        this.name = name;
        this.numberOfBoxes = numberOfBoxes;
    }

    public Dock() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBoxes() {
        return numberOfBoxes;
    }

    public void setNumberOfBoxes(int numberOfBoxes) {
        this.numberOfBoxes = numberOfBoxes;
    }

    @Override
    public String toString() {
        return "Причал [Назва=" + name + ", Кількість коробок=" + numberOfBoxes + "]";
    }
}
