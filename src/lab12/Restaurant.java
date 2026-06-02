package lab12;
public class Restaurant {

    private static Restaurant instance = new Restaurant();
    private int usedWater = 0;

    private Restaurant() {}

    public static Restaurant getRestaurant() {
        return instance;
    }


    public synchronized void washHands() {
        this.usedWater += 5;
    }

    public synchronized void washDishes() {
        this.usedWater += 10;
    }


    public synchronized int getUsedWater() {
        return this.usedWater;
    }
}