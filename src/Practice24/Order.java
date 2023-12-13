package Practice24;

public interface Order {
    public boolean addItem(Item item);
    public boolean removeItem(String itemTitle);
    public int removeAllItem(String itemTitle);
    public int itemQuantity();
    public Item[] getItemList();
    public double getTotalPrice();
    public int itemQuantity(String itemTitle);
    public String[] getItemTitles();
    public Item[] getSortedByPrice();
}
