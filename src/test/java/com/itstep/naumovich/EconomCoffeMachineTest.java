package com.itstep.naumovich;

import com.itstep.naumovich.coffee.Americano;
import com.itstep.naumovich.coffee.Espresso;
import com.itstep.naumovich.coffee.Latter;
import com.itstep.naumovich.exceptions.*;
import com.itstep.naumovich.machines.AbstractCoffeeMachine;
import com.itstep.naumovich.machines.BusinessCoffeeMachine;
import com.itstep.naumovich.machines.EconomCoffeeMachine;
import com.itstep.naumovich.machines.NewCoffeMachine;
import org.junit.Assert;
import org.junit.Test;

public class EconomCoffeMachineTest {
    @Test
    public void getCurrentTest() throws Exception {
        //Given
        AbstractCoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(20);
        econom.fillWithWater(170);
        econom.enable();
        //When
        Americano americano ;

        americano = econom.makeAmericano();

        //Then
        Assert.assertEquals(0, econom.getCurrentCoffee());
        Assert.assertEquals(70, econom.getCurrentWater());

    }

    @Test
    public void espressoPositiveTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(22);
        econom.fillWithWater(100);
        econom.enable();
        //When
        Espresso espresso = econom.makeEspresso();
        //Then
        Assert.assertNotNull(espresso);
    }

    @Test
    public void espressoNullTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(22);
        econom.fillWithWater(100);
        //econom.enable();
        //When
        Espresso espresso = econom.makeEspresso();
        //Then
        Assert.assertNull(espresso);
    }


    @Test
    public void espressoNegativeTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(22);
        econom.fillWithWater(10);
        econom.enable();
        //When
        Espresso espresso;
        try {
            espresso = econom.makeEspresso();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoWaterException) {
                econom.fillWithWater(100);
            }
            espresso = econom.makeEspresso();
        }
        //Then
        Assert.assertNotNull(espresso);
    }

    @Test(expected = NoCoffeeException.class)
    public void espressoNegativeRealizedTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(50);
        econom.fillWithWater(10000);
        econom.enable();
        //When
        Espresso espresso = null;
        int i = 0;
        while (i < 100000) {
            espresso = econom.makeEspresso();
            i++;
        }
        //Then
        Assert.assertNull(espresso);
    }
    @Test
    public void latterNegaitiveTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(50);
        econom.fillWithWater(10000);
        econom.fillWithMilk(10);
        econom.enable();

        //When
        Latter latter = null;
        try {
            latter = econom.makeLatter();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoMilkException) {
                econom.fillWithMilk(100);
                latter = econom.makeLatter();
            }

            //Then
            Assert.assertNotNull(latter);
        }
    }

        @Test
        public void latterPozitiveTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(50);
        econom.fillWithWater(10000);
        econom.fillWithMilk(10);
        econom.enable();
        Latter  latter = econom.makeLatter();

        //Then
        Assert.assertNotNull(latter);

    }
    @Test
    public void latterNullTest() throws Exception {
        //Given
        CoffeeMachine econom = new EconomCoffeeMachine();
        econom.fillWithCoffee(50);
        econom.fillWithWater(10000);
        econom.fillWithMilk(10);
        //econom.enable();
        Latter  latter = econom.makeLatter();

        //Then
        Assert.assertNull(latter);

    }



}



