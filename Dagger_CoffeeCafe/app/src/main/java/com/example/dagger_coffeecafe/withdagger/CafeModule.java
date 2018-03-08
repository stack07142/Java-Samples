package com.example.dagger_coffeecafe.withdagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = CoffeeSuite.class)
public class CafeModule {

    private String cafeName;

    public CafeModule() {

    }

    public CafeModule(String cafeName) {

        this.cafeName = cafeName;
    }

    @Singleton
    @Provides
    CafeInfo provideCafeInfo() {

        if (cafeName == null || cafeName.isEmpty()) {

            return new CafeInfo();
        } else {

            return new CafeInfo(cafeName);
        }
    }
}
