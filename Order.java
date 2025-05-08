import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextOrderId = 1;

    private int orderId;
    private List<OrderItem> items;
    private String customerName;

    public Order(String customerName) {
        this.orderId = nextOrderId++;
        this.items = new ArrayList<>();
        this.customerName = customerName;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getItemTotal();
        }
        return total;
    }

    public void displayOrder() {
        System.out.println("=== ЗАКАЗ #" + orderId + " ===");
        System.out.println("Клиент: " + customerName);
        System.out.println("Позиции:");
        for (OrderItem item : items) {
            System.out.println("  " + item);
        }
        System.out.println("Итого: " + calculateTotal() + " руб.");
        System.out.println("================");
    }

    public int getOrderId() {
        return orderId;
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(items);
    }

    public String getCustomerName() {
        return customerName;
    }
}
