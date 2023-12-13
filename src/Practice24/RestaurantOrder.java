package Practice24;

import java.util.Objects;
import java.util.Arrays;
import java.util.Comparator;

public class RestaurantOrder implements Order {
    private int dishSize;
    private int drinkSize;
    private Dish[] dishList;
    private Drink[] drinkList;

    public RestaurantOrder(int dishSize, int drinkSize) {
        this.dishSize = dishSize;
        this.drinkSize = drinkSize;
        try {
            dishList = new Dish[dishSize];
            drinkList = new Drink[drinkSize];
            for(int i = 0; i < dishSize; i++) {
                dishList[i] = null;
            }
            for(int i = 0; i < drinkSize; i++) {
                drinkList[i] = null;
            }
        }
        catch (Exception e) {
            System.out.println("Wrong Array's size");
        }
    }

    public boolean addDish(Dish dish) {
        if(dishQuantity() < dishSize) {
            for(int i = 0; i < dishSize; i++) {
                if(Objects.equals(dishList[i], null)) {
                    dishList[i] = dish;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addDrink(Drink drink) {
        if(drinkQuantity() < drinkSize) {
            for(int i = 0; i < drinkSize; i++) {
                if(Objects.equals(drinkList[i], null)) {
                    drinkList[i] = drink;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeDish(String dishTitle) {
        for(int i = dishSize - 1; i >= 0; i--) {
            if(Objects.equals(dishList[i].getTitle(), dishTitle)) {
                dishList[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean removeDrink(String drinkTitle) {
        for(int i = drinkSize - 1; i >= 0; i--) {
            if(Objects.equals(drinkList[i].getTitle(), drinkTitle)) {
                drinkList[i] = null;
                return true;
            }
        }
        return false;
    }

    public int removeAllDish(String dishTitle) {
        int count = 0;
        for(int i = 0; i < dishSize; i++) {
            if(Objects.equals(dishList[i].getTitle(), dishTitle)) {
                dishList[i] = null;
                count++;
            }
        }
        return count;
    }

    public int removeAllDrink(String drinkTitle) {
        int count = 0;
        for(int i = 0; i < drinkSize; i++) {
            if(Objects.equals(drinkList[i].getTitle(), drinkTitle)) {
                drinkList[i] = null;
                count++;
            }
        }
        return count;
    }

    public int dishQuantity() {
        int count = 0;
        for(int i = 0; i < dishSize; i++) {
            if(Objects.equals(dishList[i], null)) {
                count++;
            }
        }
        return dishSize - count;
    }

    public int dishQuantity(String dishTitle) {
        int count = 0;
        for(int i = 0; i < dishSize; i++) {
            if(Objects.equals(dishList[i].getTitle(), dishTitle)) {
                count++;
            }
        }
        return count;
    }

    public int drinkQuantity() {
        int count = 0;
        for(int i = 0; i < drinkSize; i++) {
            if(Objects.equals(drinkList[i], null)) {
                count++;
            }
        }
        return drinkSize - count;
    }

    public int drinkQuantity(String drinkTitle) {
        int count = 0;
        for(int i = 0; i < drinkSize; i++) {
            if(Objects.equals(drinkList[i].getTitle(), drinkTitle)) {
                count++;
            }
        }
        return count;
    }

    public Dish[] getDishList() {
        return dishList;
    }

    public Drink[] getDrinkList() {
        return drinkList;
    }

    @Override
    public double getTotalPrice() {
        double total = 0;
        for(int i = 0; i < dishSize; i++) {
            if(!Objects.equals(dishList[i], null)) {
                total += dishList[i].getPrice();
            }
        }
        for(int i = 0; i < drinkSize; i++) {
            if(!Objects.equals(drinkList[i], null)) {
                total += drinkList[i].getPrice();
            }
        }
        return total;
    }

    public String[] getDishTitles() {
        int size = dishQuantity();
        String[] titles = new String[size];
        int k = 0;
        for(int i = 0; i < dishSize; i++) {
            if(!Objects.equals(dishList[i], null)) {
                titles[k++] = dishList[i].getTitle();
            }
        }
        return titles;
    }

    public String[] getDrinkTitles() {
        int size = drinkQuantity();
        String[] titles = new String[size];
        int k = 0;
        for(int i = 0; i < drinkSize; i++) {
            if(!Objects.equals(drinkList[i], null)) {
                titles[k++] = drinkList[i].getTitle();
            }
        }
        return titles;
    }

    @Override
    public Item[] getSortedByPrice() {
        Item[] items = new Item[dishQuantity() + drinkQuantity()];
        int k = 0;
        for(int j = 0; j < dishQuantity(); j++) {
            items[k++] = dishList[j];
        }
        for(int j = 0; j < drinkQuantity(); j++) {
            items[k++] = drinkList[j];
        }
        Arrays.sort(items, Comparator.comparing(Item::getPrice).reversed());
        return items;
    }
    
    @Override
    public boolean addItem(Item item) {
        if(item.getClass().equals(Dish.class)) {
            return addDish((Dish)item);
        }
        else if(item.getClass().equals(Drink.class)) {
            return addDrink((Drink)item);
        }
        return false;
    }
    
    @Override
    public boolean removeItem(String itemTitle) {
        return removeDish(itemTitle) || removeDrink(itemTitle);
    }
    
    @Override
    public int removeAllItem(String itemTitle) {
        return removeAllDish(itemTitle) + removeAllDrink(itemTitle);
    }
    
    @Override
    public int itemQuantity() {
        return dishQuantity() + drinkQuantity();
    }
    
    @Override
    public Item[] getItemList() {
        int dishCount = dishQuantity();
        int drinkCount = drinkQuantity();
        Item[] items = new Item[dishCount + drinkCount];
        Dish[] dishes = getDishList();
        Drink[] drinks = getDrinkList();
        int k = 0;
        for(int j = 0; j < dishCount; j++) {
            items[k++] = dishes[j];
        }
        for(int j = 0; j < drinkCount; j++) {
            items[k++] = drinks[j];
        }
        return items; 
    }

    @Override
    public int itemQuantity(String itemTitle) {
        return dishQuantity(itemTitle) + drinkQuantity(itemTitle);
    }

    @Override
    public String[] getItemTitles() {
        int dishCount = dishQuantity();
        int drinkCount = drinkQuantity();
        String[] items = new String[dishCount + drinkCount];
        String[] dishes = getDishTitles();
        String[] drinks = getDrinkTitles();
        int k = 0;
        for(int j = 0; j < dishCount; j++) {
            items[k++] = dishes[j];
        }
        for(int j = 0; j < drinkCount; j++) {
            items[k++] = drinks[j];
        }
        return items;
    }
    
    @Override
    public String toString() {
        StringBuilder order = new StringBuilder();
        Dish[] dishItems = getDishList();
        Drink[] drinkItems = getDrinkList();
        for(int i = 0; i < dishItems.length; i++) {
            if(!Objects.equals(dishItems[i], null)) {
                order.append(dishItems[i].toString()).append("\n");
            }
        }
        for(int i = 0; i < drinkItems.length; i++) {
            if(!Objects.equals(drinkItems[i], null)) {
                order.append(drinkItems[i].toString()).append("\n");
            }
        }
        return order.toString();
    }
}