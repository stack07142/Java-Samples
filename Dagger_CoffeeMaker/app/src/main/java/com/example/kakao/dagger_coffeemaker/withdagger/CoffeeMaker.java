package com.example.kakao.dagger_coffeemaker.withdagger;


import javax.inject.Inject;

public class CoffeeMaker {

    @Inject
    Heater heater;
    @Inject
    Pump pump;

    public CoffeeMaker() {
    }

    @Inject
    public CoffeeMaker(Heater heater, Pump pump) {
        this.heater = heater;
        this.pump = pump;
    }

    public void brew() {

        heater.on();
        pump.pump();
        System.out.println(" [_]P coffee! [_]P ");
        heater.off();
    }

    /*
    public Heater getHeater() {
        return heater;
    }

    public Pump getPump() {
        return pump;
    }
    */
}
