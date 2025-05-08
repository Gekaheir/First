public class MenuItem {
    private String name;  //название блюда
    private double price;   //цена блюда

    public MenuItem(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
            return name + " -" + price + " рублей.";
    }
}
