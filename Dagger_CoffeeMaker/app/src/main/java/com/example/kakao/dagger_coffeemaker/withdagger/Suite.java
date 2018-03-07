package com.example.kakao.dagger_coffeemaker.withdagger;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = CoffeeMakerModule.class)
public interface Suite {

    // 방법 1. provision method
    CoffeeMaker getCoffeMaker();

    // 방법 2. member-injection method
    void inject(CoffeeMaker coffeeMaker);
}
