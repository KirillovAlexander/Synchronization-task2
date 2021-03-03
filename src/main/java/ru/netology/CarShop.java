package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CarShop {
    private static final int TIME_TO_SELL = 500;
    private List<Car> carList = new ArrayList<>();
    private ReentrantLock locker;
    private Condition condition;

    public CarShop(ReentrantLock locker) {
        this.locker = locker;
        condition = locker.newCondition();
    }

    public void sellCar() {
        locker.lock();
        try {
            Thread.sleep(TIME_TO_SELL);
            while (carList.size() == 0) {
                System.out.println("В магазине отсутствуют автомобили!");
                condition.await();
            }
            carList.remove(0);
            System.out.println(Thread.currentThread().getName() + ": купил новенький автомобиль!");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            locker.unlock();
        }
    }

    public void getNewCar() {
        try {
            for (int i = 0; i < Manufacturer.AMOUNT_OF_CARS; i++) {
                Thread.sleep(Manufacturer.TIME_TO_PRODUCT_MILLIS);
                locker.lock();
                System.out.println("В магазин поступил новый автомобиль от производителя!");
                carList.add(new Car());
                condition.signal();
                locker.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (locker.isLocked()) locker.unlock();
        }
    }
}
