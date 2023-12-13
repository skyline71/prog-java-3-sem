package Practice24;

import java.util.Random;

public class RestaurantTest {
    public static void main(String[] args) throws OrderAlreadyAddedException {
        Restaurant restaurant = new Restaurant(3);
        restaurant.setOrders(1,2);
        RestaurantOrder[] orders = restaurant.getOrders();
        OrderManager orderManager = new OrderManager(orders);
        orderManager.add("street1", orders[0]);
        orderManager.add("street2", orders[1]);
        orderManager.add("street3", orders[2]);
        System.out.println(orderManager);
        System.out.println("Total Order Price: " + orderManager.getOrdersPrice());
    }
}

class Restaurant {
    private int size;
    private RestaurantOrder[] orders;

    public Restaurant(int size) {
        this.size = size;
        orders = new RestaurantOrder[size];
        for(int i = 0; i < size; i++) {
            orders[i] = null;
        }
    }

    public void setOrders(int dishSize, int drinkSize) {
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            orders[i] = new RestaurantOrder(dishSize,drinkSize);
            for(int j = 0; j < dishSize; j++) {
                orders[i].addDish(new Dish(random.nextInt(1,1000),"dish" + (j+1),"info" + (j+1)));
            }
            for(int j = 0; j < drinkSize; j++) {
                orders[i].addDrink(new Drink(random.nextInt(1,1000),"drink" + (j+1),"info" + (j+1)));
            }
        }
    }

    public RestaurantOrder[] getOrders() {
        return orders;
    }
}
