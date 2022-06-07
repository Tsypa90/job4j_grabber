package lsp.shop;

import java.util.Calendar;
import java.util.List;

public class ControllQuality {
    private final Calendar date = Calendar.getInstance();
    private List<Food> foods;

    public ControllQuality(List<Food> foods) {
        this.foods = foods;
    }

    public void control(Warehouse warehouse, Shop shop, Trash trash) {
        for (Food food : foods) {
            if (warehouse.accept(food)) {
                warehouse.add(food);
            } else if (shop.accept(food)) {
                shop.add(food);
            } else {
                trash.add(food);
            }
        }
    }
}
