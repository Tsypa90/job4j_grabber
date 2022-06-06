package lsp.shop;

import java.util.Calendar;
import java.util.List;

public class ControllQuality {
    private final Calendar date = Calendar.getInstance();
    private final Warehouse warehouse;
    private final Shop shop;
    private final Trash trash;

    public ControllQuality(Warehouse warehouse, Shop shop, Trash trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public void control(Food food) {
            int expiryDays = food.getExpiryDate().getDate() - food.getCreateDate().getDate();
            int percentage = date.getTime().getDate() - food.getCreateDate().getDate();
            var percent = (double) percentage / expiryDays;
            if (percent < 0.25) {
            warehouse.add(food);
        } else if (percent >= 0.25 && percent < 1) {
                food.setPrice();
                shop.add(food);
            } else {
            trash.add(food);
        }
    }
}
