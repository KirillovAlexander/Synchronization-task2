package ru.netology;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        CarShop carShop = new CarShop(new ReentrantLock(true));
        Manufacturer manufacturer = new Manufacturer(carShop);
        Customer customer = new Customer(carShop);

        new Thread(null, customer, "Иван").start();
        Thread.sleep(100);
        new Thread(null, customer, "Александр").start();
        Thread.sleep(100);
        new Thread(null, customer, "Петр").start();
        Thread.sleep(100);
        new Thread(null, customer, "Юрий").start();
        Thread.sleep(100);
        new Thread(null, customer, "Максим").start();
        Thread.sleep(100);
        new Thread(null, customer, "Анатолий").start();
        Thread.sleep(100);
        new Thread(null, customer, "Роман").start();

        new Thread(null, manufacturer, "Производитель").start();
    }
}
