package com.itstep.naumovich;

import com.itstep.naumovich.coffee.Americano;
import com.itstep.naumovich.coffee.Capucinno;
import com.itstep.naumovich.coffee.Espresso;
import com.itstep.naumovich.coffee.Latter;
import com.itstep.naumovich.exceptions.CoffeeMachineException;

/**
 * Created by admin on 15.01.2019.
 */
public interface CoffeeMachine {

    void enable(); // кнопка вкл

    void disable();// кнопка выкл.

    Espresso makeEspresso() throws CoffeeMachineException;// кнопка сделать экспрессо
    Americano makeAmericano() throws CoffeeMachineException;// сделать американо
    Latter makeLatter() throws CoffeeMachineException;// сделать латте
    Capucinno makeCapucinno() throws CoffeeMachineException;// сделать капучинно

    void cleanUp();// очистить бак

    void fillWithWater(int quantityInMl);// наполнить водой

    void fillWithCoffee(int quantityInGrams);// наполнить кофе

    void fillWithMilk(int quantityInMl);// залить молоко
}
