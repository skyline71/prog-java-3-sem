package Practice23;

import java.util.Random;

public class RestaurantTest {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(3);
        restaurant.setOrders(1,2);
        Order[] orders = restaurant.getOrders();
        TablesOrderManager orderManager = new TablesOrderManager(orders);
        System.out.println(orderManager);
        orderManager.remove(orders[0],"dish1");
        orderManager.add(orders[0], new Dish(500,"new dish","info1"));
        System.out.println("New Order #1:\n" + orders[0]);
        Item[] sortedOrder = orderManager.getSorted(orders[0]);
        System.out.println("Sorted Order #1:");
        orderManager.showOrder(sortedOrder);
        System.out.println("\nOrder #3 total price: " + orderManager.getPrice(orders[2]));
    }
}

class Restaurant {
    private int size;
    private Order[] orders;

    public Restaurant(int size) {
        this.size = size;
        orders = new Order[size];
        for(int i = 0; i < size; i++) {
            orders[i] = null;
        }
    }

    public void setOrders(int dishSize, int drinkSize) {
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            orders[i] = new Order(dishSize,drinkSize);
            for(int j = 0; j < dishSize; j++) {
                orders[i].addDish(new Dish(random.nextInt(1,1000),"dish" + (j+1),"info" + (j+1)));
            }
            for(int j = 0; j < drinkSize; j++) {
                orders[i].addDrink(new Drink(random.nextInt(1,1000),"drink" + (j+1),"info" + (j+1)));
            }
        }
    }

    public Order[] getOrders() {
        return orders;
    }
}
