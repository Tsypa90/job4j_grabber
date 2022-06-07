package lsp.shop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientUsage {
    public static void main(String[] args) {
        List<Food> foods = new ArrayList<>();
        foods.add(new Milk("milk", LocalDate.now().plusDays(20), LocalDate.now().minusDays(5), 50, 0.25));
        foods.add(new Meat("pork", LocalDate.now().plusDays(15), LocalDate.now().minusDays(6), 50, 0.25));
        foods.add(new Bread("bread", LocalDate.now().plusDays(1), LocalDate.now().minusDays(5), 30, 0.3));
        foods.add(new Fruit("apple", LocalDate.now().minusDays(1), LocalDate.now().minusDays(10), 25, 0.2));
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(foods);
        controllQuality.control(warehouse, shop, trash);
        System.out.println("склад");
        warehouse.getStore().forEach(System.out::println);
        System.out.println("шоп");
        shop.getStore().forEach(System.out::println);
        System.out.println("треш");
        trash.getStore().forEach(System.out::println);
    }
}
