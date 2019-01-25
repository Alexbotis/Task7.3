package com.itstep.naumovich.machines;

import com.itstep.naumovich.CoffeeMachine;
import com.itstep.naumovich.exceptions.CoffeeMachineException;
import com.itstep.naumovich.exceptions.NoTankCapacityException;

/**
 * Created by admin on 15.01.2019.
 */
public abstract class AbstractCoffeeMachine implements CoffeeMachine {

    private int currentCoffee;
    private int currentWater;
    private int mudTank;
    private boolean isRunning = false;

    public static final int TANK_CAPACITY = 500;

    /**
     * Creates EMPTY coffee machine.
     */
    public AbstractCoffeeMachine() {
        this.currentCoffee = 0;
        this.currentWater = 0;
    }

    {
        mudTank = 0;
    }

    public AbstractCoffeeMachine(int coffee, int water) {
        if (coffee > this.getCoffeeLimit()) {
            this.currentCoffee = this.getCoffeeLimit();
        }
        if (water > this.getWaterLimit()) {
            this.currentWater = this.getWaterLimit();
        }
    }

    public void enable() {
        if (isRunning == false) {
            isRunning = true;
        }
    }

    public void disable() {
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void cleanUp() {
        mudTank = 0;
    }

    public void fillWithWater(int quantityInMl) {
        if (quantityInMl + currentWater > getWaterLimit()) {
            currentWater = getWaterLimit();
        } else {
            currentWater += quantityInMl;
        }
    }

    public void fillWithCoffee(int quantityInGrams) {
        if (quantityInGrams + currentWater > getCoffeeLimit()) {
            currentCoffee = getCoffeeLimit();
        } else {
            currentCoffee += quantityInGrams;
        }
    }

    abstract int getWaterLimit();

    abstract int getCoffeeLimit();

    boolean availableTankCapacity(int valueToAdd) {
        return mudTank + valueToAdd < TANK_CAPACITY;
    }

    void collectGarbage(int valueToAdd) throws CoffeeMachineException {
        if (availableTankCapacity(valueToAdd)) {
            mudTank += valueToAdd;
        } else {
            throw new NoTankCapacityException();
        }

    }

    public int getCurrentCoffee() {
        return currentCoffee;
    }

    public int getCurrentWater() {
        return currentWater;
    }

    public void setCurrentCoffee(int currentCoffee) {
        this.currentCoffee = currentCoffee;
    }

    public void setCurrentWater(int currentWater) {
        this.currentWater = currentWater;
    }
}
