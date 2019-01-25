package com.itstep.naumovich.machines;

import com.itstep.naumovich.coffee.Americano;
import com.itstep.naumovich.coffee.Capucinno;
import com.itstep.naumovich.coffee.Espresso;
import com.itstep.naumovich.coffee.Latter;
import com.itstep.naumovich.exceptions.CoffeeMachineException;
import com.itstep.naumovich.exceptions.NoCoffeeException;
import com.itstep.naumovich.exceptions.NoWaterException;

/**
 * Created by admin on 15.01.2019.
 */
public class BusinessCoffeeMachine extends AbstractCoffeeMachine {

    private static final int WATER_LIMIT = 10000;
    private static final int COFFEE_LIMIT = 2000;
    private static final int Milk_LIMIT = 700;
    private int quantityMilk;

    public BusinessCoffeeMachine() {
        super();
    }

    public BusinessCoffeeMachine(int coffee, int water, int milk ) {
        super(coffee, water,milk);
        this.quantityMilk=quantityMilk;
    }

    int getWaterLimit() {
        return WATER_LIMIT;
    }

    int getCoffeeLimit() {
        return COFFEE_LIMIT;
    }
    int getMilkLimit() {
        return Milk_LIMIT;

    }

    int  getQuantityMilk (){

        return quantityMilk;
    }


    public Espresso makeEspresso() throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        if (getCurrentCoffee() < 50) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 50) {
            throw new NoWaterException();
        }
        // use 50 gramm coffee
        // use 50 ml water
        collectGarbage(50);
        setCurrentCoffee(getCurrentCoffee() - 50);
        setCurrentWater(getCurrentWater() - 50);
        return new Espresso();
    }

    public Americano makeAmericano() throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 50 gramm coffee
        // use 150 ml water
        if (getCurrentCoffee() < 50) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 150) {
            throw new NoWaterException();
        }
        collectGarbage(50);
        setCurrentCoffee(getCurrentCoffee() - 50);
        setCurrentWater(getCurrentWater() - 150);
        return new Americano();
    }
    public Latter makeLatter() throws CoffeeMachineException {

        if (!isRunning()) {
            return null;
        }
        // use 22 gramm coffee
        // use 30 ml water
        // use milk quantityMilk;

        if (getCurrentCoffee() < 22) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 30) {
            throw new NoWaterException();
        }
        if (getCurrentMilk() < this.getQuantityMilk ()) {
            throw new NoWaterException();
        }
        collectGarbage(22);
        setCurrentCoffee(getCurrentCoffee() - 22);
        setCurrentWater(getCurrentWater() - 30);
        setCurrentMilk(getCurrentMilk() - this.getQuantityMilk ());
        return new Latter();
    }
    public Capucinno makeCapucinno() throws CoffeeMachineException {

        if (!isRunning()) {
            return null;
        }
        // use 22 gramm coffee
        // use 30 ml water
        // use milk quantityMilk;

        if (getCurrentCoffee() < 22) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 30) {
            throw new NoWaterException();
        }
        if (getCurrentMilk() < this.getQuantityMilk ()) {
            throw new NoWaterException();
        }
        collectGarbage(22);
        setCurrentCoffee(getCurrentCoffee() - 22);
        setCurrentWater(getCurrentWater() - 30);
        setCurrentMilk(getCurrentMilk() - this.getQuantityMilk ());
        return new Capucinno();
    }


}
