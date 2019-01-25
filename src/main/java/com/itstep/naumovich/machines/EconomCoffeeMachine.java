package com.itstep.naumovich.machines;

import com.itstep.naumovich.CoffeeMachine;
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
public class EconomCoffeeMachine extends AbstractCoffeeMachine {

    private static final int WATER_LIMIT = 1000;
    private static final int COFFEE_LIMIT = 200;
      private static final int Milk_LIMIT = 500;
    private int quantityMilk;// кол-во кофе для разовой порции кофе

    public EconomCoffeeMachine() {// конструктор 1
        super();
    }

    public EconomCoffeeMachine(int coffee, int water,int milk,int quantityMilk ) {// конструктор 2
        super(coffee, water,milk);// зерновой кофе отсутствует
        this.quantityMilk=quantityMilk;
    }

    int getWaterLimit() {
        return WATER_LIMIT;
    } // gettery

    int getCoffeeLimit() {
        return COFFEE_LIMIT;
    }

    int getMilkLimit() {
        return Milk_LIMIT;

    }

     int  getQuantityMilk (){

         return quantityMilk;
     }


    public Espresso makeEspresso() throws CoffeeMachineException {// делаем порцию экспрессо
        if (!isRunning()) {
            return null;
        }
        // use 20 gramm coffee
        // use 30 ml water
        if (getCurrentCoffee() < 20) { // если кофе недостаточно
            throw new NoCoffeeException();// то выбрасываем исключение
        }
        if (getCurrentWater() < 30) {
            throw new NoWaterException();
        }
        collectGarbage(20);// добавляем в бак использованный кофе
        setCurrentCoffee(getCurrentCoffee() - 20);// уменьшаем кол-во кофе
        setCurrentWater(getCurrentWater() - 30);// уменьшаем кол-во воды
        return new Espresso();
    }

    public Americano makeAmericano() throws CoffeeMachineException {// делаем порцию американо
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

    public Latter makeLatter() throws CoffeeMachineException {// делаем латте

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
    public Capucinno makeCapucinno() throws CoffeeMachineException {// делаем капучинно

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
