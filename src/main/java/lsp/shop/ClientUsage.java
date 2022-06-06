package lsp.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientUsage {
    public static void main(String[] args) {
        List<Food> foods = new ArrayList<>();
        foods.add(new Milk("milk", new Date(122, 5, 15), new Date(122, 5, 1), 50, 0.25));
        foods.add(new Meat("pork", new Date(122, 5, 20), new Date(122, 5, 1), 50, 0.25));
        foods.add(new Bread("bread", new Date(122, 5, 6), new Date(122, 5, 1), 30, 0.3));
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControllQuality controllQuality = new ControllQuality(warehouse, shop, trash);
        foods.forEach(controllQuality::control);
        foods.removeAll(trash.getStore());
    }
}
