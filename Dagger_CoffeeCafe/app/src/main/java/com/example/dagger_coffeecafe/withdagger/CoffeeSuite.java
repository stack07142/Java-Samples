package com.example.dagger_coffeecafe.withdagger;

import dagger.Subcomponent;

@CoffeeScope
@Subcomponent(modules = CoffeeModule.class)
public interface CoffeeSuite {

    CoffeeMaker getCoffeeMaker();
    CoffeeBean getCoffeeBean();

    @Subcomponent.Builder
    interface Builder {

        CoffeeSuite build();
    }
}
