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
        List<Store> stores = List.of(new Warehouse(), new Shop(), new Trash());
        ControllQuality controllQuality = new ControllQuality(stores);
        foods.forEach(controllQuality::control);
        while (true) {
            controllQuality.resort();
            stores.forEach(store -> System.out.println(store.getStore().size()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
