package com.example.kakao.dagger_coffeemaker;

import com.example.kakao.dagger_coffeemaker.withdagger.DaggerSuite;
import com.example.kakao.dagger_coffeemaker.withdi.Injection;
import com.example.kakao.dagger_coffeemaker.withoutdi.A_Heater;
import com.example.kakao.dagger_coffeemaker.withoutdi.A_Pump;
import com.example.kakao.dagger_coffeemaker.withoutdi.Heater;
import com.example.kakao.dagger_coffeemaker.withoutdi.Pump;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n\n\n[ without DI ] -------------------------------------\n");
        // without DI
        {
            Heater heater = new A_Heater();
            Pump pump = new A_Pump(heater);
            com.example.kakao.dagger_coffeemaker.withoutdi.CoffeeMaker coffeeMaker = new com.example.kakao.dagger_coffeemaker.withoutdi.CoffeeMaker(heater, pump);
            coffeeMaker.brew();
        }

        System.out.println("\n\n\n[ with DI ] ----------------------------------------\n");
        // with DI
        {
            Injection.provideCoffeeMaker().brew();
        }

        System.out.println("\n\n\n[ with Dagger ] ------------------------------------\n");
        // with Dagger
        {

            // 방법 1. provision method
            DaggerSuite.create().getCoffeMaker().brew();

            System.out.println();

            // 방법 2. members-injection method
            com.example.kakao.dagger_coffeemaker.withdagger.CoffeeMaker coffeeMaker = new com.example.kakao.dagger_coffeemaker.withdagger.CoffeeMaker();
            DaggerSuite.create().inject(coffeeMaker);
            coffeeMaker.brew();
        }
    }
}
