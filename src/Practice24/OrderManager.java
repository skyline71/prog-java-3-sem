package Practice24;

import java.util.HashMap;

public class OrderManager {
    private int size;
    private RestaurantOrder[] orders;
    private HashMap<String, Order> addressOrderMap = new HashMap<>();


    public OrderManager() {
        orders = null;
    }

    public OrderManager(RestaurantOrder[] orders) {
        this.size = orders.length;
        this.orders = new RestaurantOrder[size];
        for(int i = 0; i < size; i++) {
            this.orders[i] = orders[i];
        }
    }

    public void add(RestaurantOrder order, Item item) {
        for(int i = 0; i < size; i++) {
            if(orders[i] == order) {
                if(item.getClass().equals(Dish.class)) {
                    orders[i].addDish((Dish)item);
                }
                else if(item.getClass().equals(Drink.class)) {
                    orders[i].addDrink((Drink)item);
                }
            }
        }
    }

    public void remove(RestaurantOrder order, String itemTitle) {
        for(int i = 0; i < size; i++) {
            if(orders[i] == order) {
                if(!orders[i].removeDish(itemTitle)) {
                    orders[i].removeDrink(itemTitle);
                }
            }
        }
    }

    public void removeAll(RestaurantOrder order, String itemTitle) {
        for(int i = 0; i < size; i++) {
            if(orders[i] == order) {
                if(orders[i].removeAllDish(itemTitle) == 0) {
                    orders[i].removeAllDrink(itemTitle);
                }
            }
        }
    }

    public Item[] getList(RestaurantOrder order) {
        int dishCount = order.dishQuantity();
        int drinkCount = order.drinkQuantity();
        Item[] items = new Item[dishCount + drinkCount];
        Dish[] dishes = new Dish[dishCount];
        Drink[] drinks = new Drink[drinkCount];
        for(int i = 0; i < size; i++) {
            if(orders[i] == order) {
                dishes = order.getDishList();
                drinks = order.getDrinkList();
            }
        }
        int k = 0;
        for(int j = 0; j < dishCount; j++) {
            items[k++] = dishes[j];
        }
        for(int j = 0; j < drinkCount; j++) {
            items[k++] = drinks[j];
        }
        return items;
    }

    public double getPrice(RestaurantOrder order) {
        double price = 0;
        for(int i = 0; i < size; i++) {
            if(orders[i] == order) {
                price = orders[i].getTotalPrice();
            }
        }
        return price;
    }

    public int getQuantity(RestaurantOrder order) {
        return order.dishQuantity() + order.drinkQuantity();
    }

    public String[] getTitles(RestaurantOrder order) {
        int dishCount = order.dishQuantity();
        int drinkCount = order.drinkQuantity();
        String[] items = new String[dishCount + drinkCount];
        String[] dishes = new String[dishCount];
        String[] drinks = new String[drinkCount];
        for(int i = 0; i < size; i++) {
            if(orders[i] == order) {
                dishes = order.getDishTitles();
                drinks = order.getDrinkTitles();
            }
        }
        int k = 0;
        for(int j = 0; j < dishCount; j++) {
            items[k++] = dishes[j];
        }
        for(int j = 0; j < drinkCount; j++) {
            items[k++] = drinks[j];
        }
        return items;
    }

    public Item[] getSorted(RestaurantOrder order) {
        Item[] items = new Item[order.dishQuantity() + order.drinkQuantity()];
        for(int i = 0; i < size; i++) {
            if(orders[i] == order) {
                items = orders[i].getSortedByPrice();
            }
        }
        return items;
    }

    public void showOrder(Item[] order) {
        for(int i = 0; i < order.length; i++) {
            if(order[i] != null) {
                System.out.println(order[i]);
            }
        }
    }

    public void add(String address, Order order) throws OrderAlreadyAddedException {
        if(addressOrderMap.putIfAbsent(address, order) != null) {
            throw new OrderAlreadyAddedException();
        }
    }

    public Order get(String address) {
        Order order = addressOrderMap.get(address);
        if(order == null) {
            throw new IllegalAddressNumber();
        }
        return order;
    }

    public void remove(String address) {
        if(addressOrderMap.remove(address) == null) {
            throw new IllegalAddressNumber();
        }
    }

    public void addItem(String address, Item item) {
        Order order = addressOrderMap.get(address);
        if(order != null) {
            add((RestaurantOrder)order, item);
        }
        throw new IllegalAddressNumber();
    }

    public Order[] getOrders() {
        return addressOrderMap.values().toArray(new Order[addressOrderMap.size()]);
    }

    public double getOrdersPrice() {
        Order[] orders = addressOrderMap.values().toArray(new Order[addressOrderMap.size()]);
        double price = 0;
        for(int i = 0; i < orders.length; i++) {
            price += orders[i].getTotalPrice();
        }
        return price;
    }

    public int getItemCount(String itemTitle) {
        Order[] orders = addressOrderMap.values().toArray(new Order[addressOrderMap.size()]);
        int count = 0;
        for(int i = 0; i < orders.length; i++) {
            count += orders[i].itemQuantity(itemTitle);
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder ordersString = new StringBuilder();
        for(int i = 0; i < orders.length; i++) {
            ordersString.append("Order #").append(i+1).append(":\n").append(orders[i].toString());
        }
        return ordersString.toString();
    }
}
