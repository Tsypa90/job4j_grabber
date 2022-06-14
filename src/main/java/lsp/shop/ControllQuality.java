package lsp.shop;

import java.util.List;

public class ControllQuality {
    private List<Store> stores;

    public ControllQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void resort() {
        stores.forEach(store -> {
            store.getStore().forEach(this::control);
        });
    }

    public void control(Food food) {
        stores.forEach(s -> {
            if (s.accept(food)) {
                s.add(food);
            }
        });
    }
}
