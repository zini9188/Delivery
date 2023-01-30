package app.shop;

public class Menu {
    private String name;

    private int price;

    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
