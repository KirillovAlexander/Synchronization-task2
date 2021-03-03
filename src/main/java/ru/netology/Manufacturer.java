package ru.netology;

public class Manufacturer implements Runnable {
    public static final long TIME_TO_PRODUCT_MILLIS = 2000;
    public static final int AMOUNT_OF_CARS = 10;
    private CarShop carShop;

    public Manufacturer(CarShop carShop) {
        this.carShop = carShop;
    }

    @Override
    public void run() {
        carShop.getNewCar();
    }
}
