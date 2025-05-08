import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Dish> dishes;

    public Menu() {
        dishes = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public void removeDish(Dish dish) {
        dishes.remove(dish);
    }

    public List<Dish> getDishes() {
        return new ArrayList<>(dishes);
    }

    public void displayMenu() {
        System.out.println("=== МЕНЮ КАФЕ ===");
        for (int i = 0; i < dishes.size(); i++) {
            System.out.println((i + 1) + ". " + dishes.get(i));
        }
        System.out.println("================");
    }
}

