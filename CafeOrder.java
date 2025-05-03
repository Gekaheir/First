import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CafeOrder {
    private Menu menu;
    private List<Order> orders;
    private Scanner scanner;

    public CafeOrder() {
        menu = new Menu();
        orders = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeMenu();
    }

    public static void main(String[] args) {
        CafeOrder system = new CafeOrder();
        system.start();
    }

    private void initializeMenu() {
        menu.addDish(new Dish("Суп дня", 250, "Свежий суп по рецепту шеф-повара"));
        menu.addDish(new Dish("Салат Цезарь", 350, "Классический салат с курицей"));
        menu.addDish(new Dish("Паста Карбонара", 420, "Спагетти с беконом и соусом"));
        menu.addDish(new Dish("Чизкейк", 280, "Десерт из творожного сыра"));
        menu.addDish(new Dish("Кофе латте", 180, "Ароматный кофе с молоком"));
    }

    public void start() {
        while (true) {
            System.out.println("\n1. Показать меню");
            System.out.println("2. Создать новый заказ");
            System.out.println("3. Просмотреть все заказы");
            System.out.println("4. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    menu.displayMenu();
                    break;
                case 2:
                    createNewOrder();
                    break;
                case 3:
                    displayAllOrders();
                    break;
                case 4:
                    System.out.println("Выход из системы...");
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private void createNewOrder() {
        System.out.print("Введите имя клиента: ");
        String customerName = scanner.nextLine();

        Order order = new Order(customerName);
        List<Dish> dishes = menu.getDishes();

        while (true) {
            menu.displayMenu();
            System.out.println("0. Завершить заказ");
            System.out.print("Выберите блюдо (номер): ");

            int dishChoice = scanner.nextInt();
            if (dishChoice == 0) {
                break;
            }

            if (dishChoice < 1 || dishChoice > dishes.size()) {
                System.out.println("Неверный номер блюда!");
                continue;
            }

            System.out.print("Введите количество: ");
            int quantity = scanner.nextInt();

            Dish selectedDish = dishes.get(dishChoice - 1);
            order.addItem(new OrderItem(selectedDish, quantity));

            System.out.println("Блюдо добавлено в заказ!");
        }

        if (!order.getItems().isEmpty()) {
            orders.add(order);
            System.out.println("\nЗаказ создан:");
            order.displayOrder();
        } else {
            System.out.println("Заказ отменен (нет выбранных блюд).");
        }
    }

    private void displayAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("Нет активных заказов.");
            return;
        }

        System.out.println("\n=== ВСЕ ЗАКАЗЫ ===");
        for (Order order : orders) {
            order.displayOrder();
        }
    }
}