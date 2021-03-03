package ru.netology;

public class Customer implements Runnable {
    CarShop carShop;

    public Customer(CarShop carShop) {
        this.carShop = carShop;
    }

    @Override
    public void run() {
        carShop.sellCar();
    }
}
