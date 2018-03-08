package com.example.dagger_coffeecafe;


import com.example.dagger_coffeecafe.withdagger.CafeModule;
import com.example.dagger_coffeecafe.withdagger.CoffeeBean;
import com.example.dagger_coffeecafe.withdagger.CafeSuite;
import com.example.dagger_coffeecafe.withdagger.CoffeeSuite;
import com.example.dagger_coffeecafe.withdagger.DaggerCafeSuite;

public class Main {

    public static void main(String[] args) {

        // DaggerSuite.create().getCoffeeMaker().brew(new CoffeeBean("BBB"));

        CafeSuite cafeSuite = DaggerCafeSuite.builder()
                .module(new CafeModule())
                .build();

        CoffeeSuite coffeeSuite1 = cafeSuite.coffeeSuite().build();
        coffeeSuite1.getCoffeeMaker().brew(new CoffeeBean("Pangyo"));

        CoffeeSuite coffeeSuite2 = cafeSuite.coffeeSuite().build();
        coffeeSuite2.getCoffeeMaker().brew(new CoffeeBean("Sampyung"));

        System.out.println("\n\n");

        /**
         * Scope Check : CafeApp (=CafeInfo), CoffeeMaker(=Heater)
         */

        if (cafeSuite.getCafeInfo().equals(cafeSuite.getCafeInfo())) {

            System.out.println("Cafe info : equal");
        } else {

            System.out.println("Cafe info : NOT equal");
        }

        if (coffeeSuite1.getCoffeeMaker().equals(coffeeSuite1.getCoffeeMaker())) {

            System.out.println("Coffee Maker : equal");
        } else {

            System.out.println("Coffee Maker : NOT equal");
        }

        if (coffeeSuite1.getCoffeeMaker().equals(coffeeSuite2.getCoffeeMaker())) {

            System.out.println("Coffee Maker : equal");
        } else {

            System.out.println("Coffee Maker : NOT equal");
        }

        if (coffeeSuite1.getCoffeeBean().equals(coffeeSuite1.getCoffeeBean())) {

            System.out.println("Coffee Bean : equal");
        } else {

            System.out.println("Coffee Bean : NOT equal");
        }
    }
}
