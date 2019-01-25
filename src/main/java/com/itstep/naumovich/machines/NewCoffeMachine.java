package com.itstep.naumovich.machines;

import com.itstep.naumovich.coffee.Americano;
import com.itstep.naumovich.coffee.Capucinno;
import com.itstep.naumovich.coffee.Espresso;
import com.itstep.naumovich.coffee.Latter;
import com.itstep.naumovich.exceptions.*;

public class NewCoffeMachine extends AbstractCoffeeMachine  {
    private static final  int WATER_LIMIT=10000 ;
    private static final int COFFEE_LIMIT=2000 ;
    private static final  int Milk_LIMIT =700;
    private static final int ZerCoffe_LIMIT=2000 ;
    private static final int quantityMilk=10; // количество молока для одной порции
    private int currentZerCoffee; // текущее кол-во зернового кофе

    public NewCoffeMachine () {// конструктор 1
        super();
    }// конструктор

    public NewCoffeMachine (int coffee, int water, int milk, int zernoCoffee) {// конструктор 2
        super(coffee, water,milk);

        if (zernoCoffee > this.getZerCoffeeLimit()) {
            this.currentZerCoffee = this.getZerCoffeeLimit();
        } else {
            this.currentZerCoffee=zernoCoffee;
        }

    }

    public void fillWithZerCoffee(int quantityInGrams) { // добавить зерн. кофе в бак вместимостью getZerCoffeeLimit
        if (quantityInGrams + currentZerCoffee > getZerCoffeeLimit()) {
            setCurrentZerCoffee(getCoffeeLimit());
        } else {
            setCurrentZerCoffee(getCurrentCoffee() + quantityInGrams);
        }
    }

    //gettery
    public int getWaterLimit() {
        return WATER_LIMIT;
    }
    public int getCoffeeLimit() {
        return COFFEE_LIMIT;
    }
    public  int getMilkLimit() {
        return Milk_LIMIT;
    }
    public int getZerCoffeeLimit() {
        return ZerCoffe_LIMIT;
    }
    public int  getQuantityMilk (){ return quantityMilk;}
    public int getCurrentZerCoffee() {
        return currentZerCoffee;
    }

    // setter
    public void setCurrentZerCoffee(int currentZerCoffee) {
        this.currentZerCoffee = currentZerCoffee;
    }

    public void molotCoffee() throws CoffeeMachineException{// добавляем зерновой кофе если молотого не хватает

        if (getCurrentZerCoffee() <= 0){
            throw new NoZernCoffeeException();
        }
        int currentCoffee= getCurrentCoffee();// зафиксируем сколько перемолотого кофе было

        int maxCoffeeNeeded = COFFEE_LIMIT-currentCoffee; // максимальное кол-во кофе которое можно засыпать в бак

        fillWithCoffee(getCurrentZerCoffee()); // перемелем и добавим зернового перемолотого кофе

        if ((getCurrentZerCoffee() - maxCoffeeNeeded)<=0) {// если зернового кофе не хватает
            setCurrentZerCoffee(0);// то полностью опусташаем бак зернового кофе
        } else {
            setCurrentZerCoffee(getCurrentZerCoffee() - maxCoffeeNeeded);// иначе уменьшаем на (COFFEE_LIMIT-currentCoffee)
        }
    }


    public Espresso makeEspresso() throws CoffeeMachineException {
        throw new CoffeeMachineException();// машина не делает экспрессо
    }


    public Americano makeAmericano() throws CoffeeMachineException {
        if (!isRunning()) {
            return null;   //
        }
        // use 20 gramm coffee
        // use 100 ml water

       // int currentCoffee=0; // инициализируем вспомогательную переменную
        if (getCurrentCoffee() <20){ // если перемолотого кофе не хватает на порцию
            molotCoffee(); // добавляем перемолотого зернового кофе
        }
        if ( getCurrentCoffee() < 20){ // делаем повторную проверку на содержание кофе и если его не хватает
            throw new NoCoffeeException(); //выбрасываем исключение
        }
        if (getCurrentWater() < 100) {
            throw new NoWaterException();
        }
        collectGarbage(20 );
        setCurrentCoffee(getCurrentCoffee() - 20);
        setCurrentWater(getCurrentWater() - 100);

        return new Americano();
    }

    public Latter makeLatter() throws CoffeeMachineException {

        if (!isRunning()) {
            return null;
        }
        // use 22 gramm coffee
        // use 30 ml water
        // use milk quantityMilk;

       // int currentCoffee=0; // инициализируем вспомогательную переменную
        if (getCurrentCoffee() <22){ // если кофе не хватает
            molotCoffee();// добавляем перемолотого зернового кофе
        }
        if ( getCurrentCoffee() <20) { // делаем повторную проверку на содержание кофе и если его не хватает
            throw new NoCoffeeException(); //выбрасываем исключение
        }
        if (getCurrentWater() < 30) {
            throw new NoWaterException();
        }
        if (getCurrentMilk() < this.getQuantityMilk ()) {
            throw new NoMilkException();
        }
        collectGarbage(22);
        setCurrentCoffee(getCurrentCoffee() - 22);
        setCurrentWater(getCurrentWater() - 30);
        setCurrentMilk(getCurrentMilk() - this.getQuantityMilk ());

        return new Latter();
    }

    public Capucinno makeCapucinno() throws CoffeeMachineException {// машина не делает Capucinno
         throw new CoffeeMachineException();
    }
}
