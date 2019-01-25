package com.itstep.naumovich;

import com.itstep.naumovich.coffee.Americano;
import com.itstep.naumovich.coffee.Espresso;
import com.itstep.naumovich.exceptions.CoffeeMachineException;

/**
 * Created by admin on 15.01.2019.
 */
public interface CoffeeMachine {

    void enable();

    void disable();

    Espresso makeEspresso() throws CoffeeMachineException;

    Americano makeAmericano() throws CoffeeMachineException;

    void cleanUp();

    void fillWithWater(int quantityInMl);

    void fillWithCoffee(int quantityInGrams);
}
