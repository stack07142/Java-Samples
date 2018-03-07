package com.example.kakao.dagger_coffeemaker.withdagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CoffeeMakerModule {

    @Singleton
    @Provides
    Heater provideHeater() {

        return new A_Heater();
    }

    @Singleton
    @Provides
    Pump providePump(Heater heater) {

        return new A_Pump(heater);
    }
}
