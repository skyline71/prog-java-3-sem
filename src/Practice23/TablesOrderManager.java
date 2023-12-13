package Practice23;

public class TablesOrderManager {
    private int size;
    private Order[] orders;

    public TablesOrderManager() {
        orders = null;
    }

    public TablesOrderManager(Order[] orders) {
        this.size = orders.length;
        this.orders = new Order[size];
        for(int i = 0; i < size; i++) {
            this.orders[i] = orders[i];
        }
    }

    public void add(Order order, Item item) {
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

    public void remove(Order order, String itemTitle) {
        for(int i = 0; i < size; i++) {
            if(orders[i] == order) {
                if(!orders[i].removeDish(itemTitle)) {
                    orders[i].removeDrink(itemTitle);
                }
            }
        }
    }

    public void removeAll(Order order, String itemTitle) {
        for(int i = 0; i < size; i++) {
            if(orders[i] == order) {
                if(orders[i].removeAllDish(itemTitle) == 0) {
                    orders[i].removeAllDrink(itemTitle);
                }
            }
        }
    }

    public Item[] getList(Order order) {
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

    public double getPrice(Order order) {
        double price = 0;
        for(int i = 0; i < size; i++) {
            if(orders[i] == order) {
                price = orders[i].getTotalPrice();
            }
        }
        return price;
    }

    public int getQuantity(Order order) {
        return order.dishQuantity() + order.drinkQuantity();
    }

    public String[] getTitles(Order order) {
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

    public Item[] getSorted(Order order) {
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

    @Override
    public String toString() {
        StringBuilder ordersString = new StringBuilder();
        for(int i = 0; i < orders.length; i++) {
            ordersString.append("Order #").append(i+1).append(":\n").append(orders[i].toString());
        }
        return ordersString.toString();
    }
}
