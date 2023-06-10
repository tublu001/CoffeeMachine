package coffeeMachine.entity;

import lombok.Data;

@Data
public class Container {

    int id;
    private int maxCapacity;
    private int minCapacity;
    private int currentCapacity;

    public Container(int maxCapacity, int minCapacity, int currentCapacity) {
        this.maxCapacity = maxCapacity;
        this.minCapacity = minCapacity;
        this.currentCapacity = currentCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getMinCapacity() {
        return minCapacity;
    }

    public void setMinCapacity(int minCapacity) {
        this.minCapacity = minCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    @Override
    public String toString() {
        return "Container{" +
                "maxCapacity=" + maxCapacity +
                ", minCapacity=" + minCapacity +
                ", currentCapacity=" + currentCapacity +
                '}';
    }
}
