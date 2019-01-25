package com.itstep.naumovich;

import com.itstep.naumovich.coffee.Americano;
import com.itstep.naumovich.coffee.Capucinno;
import com.itstep.naumovich.coffee.Espresso;
import com.itstep.naumovich.coffee.Latter;
import com.itstep.naumovich.exceptions.*;
import com.itstep.naumovich.machines.BusinessCoffeeMachine;
import com.itstep.naumovich.machines.NewCoffeMachine;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 15.01.2019.
 */
public class NewCoffeeMachineTest {

    @Test(expected = NoZernCoffeeException.class)
    public void noZernCoffeeTest() throws Exception {
        //Given
        NewCoffeMachine newCoffeeMachine = new NewCoffeMachine();
        newCoffeeMachine.fillWithZerCoffee(0);
        newCoffeeMachine.fillWithCoffee(0);
        newCoffeeMachine.fillWithWater(200000);
        newCoffeeMachine.enable();
        //When
        Americano americano = null;
        int i = 0;
        while (i < 100000) {
            americano = newCoffeeMachine.makeAmericano();
            i++;
        }
        //Then
        Assert.assertNull(americano);
    }


    @Test

    public void getTest() throws Exception {
        //Given
        NewCoffeMachine newCoffeeMachine = new NewCoffeMachine();
        newCoffeeMachine.fillWithZerCoffee(30);
        newCoffeeMachine.fillWithCoffee(0);
        newCoffeeMachine.fillWithWater(200);
        newCoffeeMachine.enable();
        //When
        Americano americano ;

        americano = newCoffeeMachine.makeAmericano();

        //Then
        Assert.assertEquals(10, newCoffeeMachine.getCurrentCoffee());
        Assert.assertEquals(100, newCoffeeMachine.getCurrentWater());
         Assert.assertEquals(0, newCoffeeMachine.getCurrentZerCoffee());
    }


    @Test
    public void fillIngredientsTest() {
        //Given
        NewCoffeMachine newCoffeeMachine = new NewCoffeMachine();
        newCoffeeMachine.fillWithZerCoffee(22);
        newCoffeeMachine.fillWithCoffee(44);
        newCoffeeMachine.fillWithWater(200);

        //Then


        Assert.assertEquals(44, newCoffeeMachine.getCurrentCoffee());
        Assert.assertEquals(200, newCoffeeMachine.getCurrentWater());
         Assert.assertEquals(22, newCoffeeMachine.getCurrentZerCoffee());
    }

    @Test
    public void americanoPositiveTest() throws Exception {
        //Given
        NewCoffeMachine newCoffeeMachine = new NewCoffeMachine();
        newCoffeeMachine.fillWithZerCoffee(30);
        newCoffeeMachine.fillWithCoffee(0);
        newCoffeeMachine.fillWithWater(200);
        newCoffeeMachine.enable();

        //When
        Americano americano;
        americano = newCoffeeMachine.makeAmericano();
        //Then
        Assert.assertNotNull(americano);
    }

    @Test
    public void americanoNegativeTest() throws Exception {
        //Given
        NewCoffeMachine newCoffeeMachine = new NewCoffeMachine();
        newCoffeeMachine.fillWithZerCoffee(9);
        newCoffeeMachine.fillWithCoffee(10);
        newCoffeeMachine.fillWithWater(200);
        newCoffeeMachine.enable();

        //When
        Americano americano;
        try {
            americano = newCoffeeMachine.makeAmericano();

        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoCoffeeException) {
                newCoffeeMachine.fillWithCoffee(100);
            }
            americano = newCoffeeMachine.makeAmericano();
        }
        //Then
        Assert.assertNotNull(americano);
    }


    @Test
    public void latterPositiveTest() throws Exception {
        //Given
        NewCoffeMachine newCoffeeMachine = new NewCoffeMachine();
        newCoffeeMachine.fillWithZerCoffee(30);
        newCoffeeMachine.fillWithMilk(10);
        newCoffeeMachine.fillWithCoffee(20);
        newCoffeeMachine.fillWithWater(200);
        newCoffeeMachine.enable();

        //When
        Latter latter = null;
        latter = newCoffeeMachine.makeLatter();
        //Then
        Assert.assertNotNull(latter);
    }
    @Test
    public void latterNegativeTest() throws Exception {
        //Given
        NewCoffeMachine newCoffeeMachine = new NewCoffeMachine();
        newCoffeeMachine.fillWithZerCoffee(10);
        newCoffeeMachine.fillWithMilk(0);
        newCoffeeMachine.fillWithCoffee(20);
        newCoffeeMachine.fillWithWater(200);
        newCoffeeMachine.enable();

        //When
        Latter latter = null;
        try {
            latter = newCoffeeMachine.makeLatter();


        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoMilkException) {
                newCoffeeMachine.fillWithMilk(20);
            }
            latter = newCoffeeMachine.makeLatter();
        }
        //Then
        Assert.assertNotNull(latter);
    }

    @Test(expected = CoffeeMachineException.class)
    public void espressoNegativeTest() throws Exception {

        NewCoffeMachine newCoffeeMachine = new NewCoffeMachine();
        Espresso espresso = newCoffeeMachine.makeEspresso();
    }
    @Test(expected = CoffeeMachineException.class)
    public void capucinoNegativeTest() throws Exception {

        NewCoffeMachine newCoffeeMachine = new NewCoffeMachine();
        Capucinno capucinno = newCoffeeMachine.makeCapucinno();
    }

}











