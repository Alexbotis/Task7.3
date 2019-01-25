package com.itstep.naumovich;

import com.itstep.naumovich.coffee.Espresso;
import com.itstep.naumovich.exceptions.CoffeeMachineException;
import com.itstep.naumovich.exceptions.NoCoffeeException;
import com.itstep.naumovich.machines.BusinessCoffeeMachine;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 15.01.2019.
 */
public class BusinessCoffeeMachineTest {

    @Test
    public void espressoPositiveTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(50);
        business.fillWithWater(200);
        business.enable();
        //When
        Espresso espresso = business.makeEspresso();
        //Then
        Assert.assertNotNull(espresso);
    }

    @Test
    public void espressoNegativeTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(10);
        business.fillWithWater(200);
        business.enable();
        //When
        Espresso espresso;
        try {
            espresso = business.makeEspresso();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoCoffeeException) {
                business.fillWithCoffee(100);
            }
            espresso = business.makeEspresso();
        }
        //Then
        Assert.assertNotNull(espresso);
    }

    @Test(expected = NoCoffeeException.class)
    public void espressoNegativeRealizedTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(10000);
        business.fillWithWater(200000);
        business.enable();
        //When
        Espresso espresso = null;
        int i = 0;
        while (i < 100000) {
            espresso = business.makeEspresso();
            i++;
        }
        //Then
        Assert.assertNull(espresso);
    }


}
