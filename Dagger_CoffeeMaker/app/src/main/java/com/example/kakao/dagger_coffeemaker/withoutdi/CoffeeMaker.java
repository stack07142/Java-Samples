package com.example.kakao.dagger_coffeemaker.withoutdi;

public class CoffeeMaker {

    private final Heater heater;
    private final Pump pump;

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
}
