package com.itstep.naumovich.machines;

import com.itstep.naumovich.CoffeeMachine;
import com.itstep.naumovich.exceptions.CoffeeMachineException;
import com.itstep.naumovich.exceptions.NoTankCapacityException;

/**
 * Created by admin on 15.01.2019.
 */
public abstract class AbstractCoffeeMachine implements CoffeeMachine {

    private int currentCoffee;// текущее кол-во кофе
    private int currentWater; // текущее кол-во воды
    private int currentMilk;  // текущее кол-во молока
    private int mudTank; // текущее кол-во отходов в баке
    private boolean isRunning = false; // состояние машины вкл.выкл

    public static final int TANK_CAPACITY = 500; // емкость бака

    /**
     * Creates EMPTY coffee machine.
     */
    public AbstractCoffeeMachine() {// конструктор 1
        this.currentCoffee = 0;
        this.currentWater = 0;
        this.currentMilk = 0;
    }

    {
        mudTank = 0;
    }

    public AbstractCoffeeMachine(int coffee, int water, int milk) {// конструктор2
        if (coffee > this.getCoffeeLimit()) {
            this.currentCoffee = this.getCoffeeLimit();
        }else{
            this.currentCoffee= coffee;
        }
        if (water > this.getWaterLimit()) {
            this.currentWater = this.getWaterLimit();
        }else{
            this.currentWater = water;
        }
        if (milk > this.getMilkLimit()) {
            this.currentMilk = this.getMilkLimit();
        }else {
            this.currentMilk= milk;
        }
    }

    public void enable() {         // включить машину
        if (isRunning == false) {
            isRunning = true;
        }
    }

    public void disable() {
        isRunning = false;
    } // выкл. машину

    public boolean isRunning() {
        return isRunning;
    } // ссстояние машины

    public void cleanUp() {
        mudTank = 0;
    } // очистить бак

    public void fillWithWater(int quantityInMl) { // долить воды
        if (quantityInMl + currentWater > getWaterLimit()) {
            currentWater = getWaterLimit();
        } else {
            currentWater += quantityInMl;
        }
    }

    public void fillWithCoffee(int quantityInGrams) { //добавить кофе
        if (quantityInGrams + currentCoffee > getCoffeeLimit()) {
            currentCoffee = getCoffeeLimit();
        } else {
            currentCoffee += quantityInGrams;
        }
    }

    public void fillWithMilk ( int quantityInMl) { // добавить молока
        if (quantityInMl + currentMilk > getWaterLimit()) {
            currentMilk = getWaterLimit();
        } else {
            currentMilk += quantityInMl;
        }
    }

    abstract int getWaterLimit();// абстрактный метод получить лимит воды в кофеварке

    abstract int getMilkLimit ();

    abstract int getCoffeeLimit();

   // abstract int getZerCoffeeLimit();

    abstract int  getQuantityMilk ();

    boolean availableTankCapacity(int valueToAdd) {// проверяем достаточности места в баке  после добавления int valueToAdd
        return mudTank + valueToAdd < TANK_CAPACITY;
    }

    void collectGarbage(int valueToAdd) throws CoffeeMachineException {
        if (availableTankCapacity(valueToAdd)) {// проверяем вместимость бака
            mudTank += valueToAdd; // если ее хватает
        } else {
            throw new NoTankCapacityException();// иначе выбрасываем исключение
        }

    }
    // gettery
    public int getCurrentCoffee() {
        return currentCoffee;
    }

    public int getCurrentWater() {
        return currentWater;
    }
    public int getCurrentMilk() {
        return currentMilk;
    }

    // settery
    public void setCurrentCoffee(int currentCoffee) {
        this.currentCoffee = currentCoffee;
    }

    public void setCurrentWater(int currentWater) {
        this.currentWater = currentWater;
    }

    public void setCurrentMilk(int currentMilk) {
        this.currentWater = currentWater;
    }
}
