package lsp.shop;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {
    private List<Store> stores;

    public ControllQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void resort() {
        List<Food> temp = new ArrayList<>();
        stores.forEach(store -> {
            temp.addAll(store.getStore());
            store.clear();
        });
        temp.forEach(this::control);
    }

    public void control(Food food) {
        stores.forEach(s -> {
            if (s.accept(food)) {
                s.add(food);
            }
        });
    }
}
