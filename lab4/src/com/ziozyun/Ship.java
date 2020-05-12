package com.ziozyun;

public class Ship implements Runnable {
    private String name;
    private int numberOfBoxes;
    private Dock[] docks;

    public Ship(String name, int numberOfBoxes, Dock[] docks) {
        super();
        this.name = name;
        this.numberOfBoxes = numberOfBoxes;
        this.docks = docks;
    }

    public Ship() {
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

    public Dock[] getDocks() {
        return docks;
    }

    public void setDocks(Dock[] docks) {
        this.docks = docks;
    }

    @Override
    public String toString() {
        return "Корабель [Назва=" + name + ", Кількість коробок=" + numberOfBoxes + "]";
    }

    @Override
    public void run() {
        Thread thr = Thread.currentThread();
        int indexOfDock = Integer.parseInt("" + thr.getName().charAt(thr.getName().length() - 1));
        System.out.println(name + " заплив у " + docks[indexOfDock - 1] + ".");

        for (; numberOfBoxes > 0;) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException x) {
                x.printStackTrace();
            }
            numberOfBoxes -= 1;
            docks[indexOfDock - 1].setNumberOfBoxes(docks[indexOfDock - 1].getNumberOfBoxes() + 1);
        }

        System.out.println(name + " вивантажив у " + docks[indexOfDock - 1] + ".");
        System.out.println(name + " покинув " + docks[indexOfDock - 1] + ".");
    }

}
