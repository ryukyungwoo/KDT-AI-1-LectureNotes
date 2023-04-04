package zproblem;

import zproblem.utility.Random;

public class Apple {
    int applePrice;
    int apple; // 사과 갯수

    public int applePriceGet() {
        Random appleRandom = new Random();
        this.applePrice = appleRandom.generateNumber(5000, 10000);
        return applePrice;

    }

    public int appleHarvest() {
        Random appleRandom2 = new Random();
        this.apple = appleRandom2.generateNumber(3, 5);
        return apple;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "applePrice=" + applePrice +
                ", apple=" + apple +
                '}';
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.applePriceGet();
        apple.appleHarvest();
        System.out.println(apple);
    }
}
