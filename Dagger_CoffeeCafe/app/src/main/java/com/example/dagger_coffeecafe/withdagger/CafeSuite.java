package com.example.dagger_coffeecafe.withdagger;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = CafeModule.class)
public interface CafeSuite {

    CafeInfo getCafeInfo();
    CoffeeSuite.Builder coffeeSuite();

    @Component.Builder
    interface Builder {

        Builder module(CafeModule cafeModule);

        CafeSuite build();
    }
}
