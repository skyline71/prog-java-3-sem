package Practice23;

public final class Dish implements Item {
    private double price;
    private String title;
    private String info;

    public Dish(String title, String info) {
        this.price = 0;
        this.title = title;
        this.info = info;
    }

    public Dish(double price, String title, String info) {
        this.price = price;
        this.title = title;
        this.info = info;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public String getInfo() {
        return info;
    }
    @Override
    public String toString() {
        return "Dish: " + getTitle() + ", Info: " + getInfo() + ", Price: " + getPrice();
    }
}
