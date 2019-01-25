package com.itstep.naumovich.machines;

import com.itstep.naumovich.CoffeeMachine;
import com.itstep.naumovich.coffee.Americano;
import com.itstep.naumovich.coffee.Espresso;
import com.itstep.naumovich.exceptions.CoffeeMachineException;
import com.itstep.naumovich.exceptions.NoCoffeeException;
import com.itstep.naumovich.exceptions.NoWaterException;

/**
 * Created by admin on 15.01.2019.
 */
public class EconomCoffeeMachine extends AbstractCoffeeMachine {

    private static final int WATER_LIMIT = 1000;
    private static final int COFFEE_LIMIT = 200;

    public EconomCoffeeMachine() {
        super();
    }

    public EconomCoffeeMachine(int coffee, int water) {
        super(coffee, water);
    }

    int getWaterLimit() {
        return WATER_LIMIT;
    }

    int getCoffeeLimit() {
        return COFFEE_LIMIT;
    }

    public Espresso makeEspresso() throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 20 gramm coffee
        // use 30 ml water
        if (getCurrentCoffee() < 20) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 30) {
            throw new NoWaterException();
        }
        collectGarbage(20);
        setCurrentCoffee(getCurrentCoffee() - 20);
        setCurrentWater(getCurrentWater() - 30);
        return new Espresso();
    }

    public Americano makeAmericano() throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 20 gramm coffee
        // use 100 ml water
        if (getCurrentCoffee() < 20) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 100) {
            throw new NoWaterException();
        }
        collectGarbage(20);
        setCurrentCoffee(getCurrentCoffee() - 20);
        setCurrentWater(getCurrentWater() - 100);
        return new Americano();
    }
}
