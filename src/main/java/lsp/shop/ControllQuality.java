package lsp.shop;

import java.util.List;

public class ControllQuality {
    private List<Store> stores;

    public ControllQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void control(Food food) {
        stores.forEach(s -> s.add(food));
    }
}
