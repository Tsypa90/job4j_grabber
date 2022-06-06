package lsp.shop;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private final List<Food> store = new ArrayList<>();
    @Override
    public boolean add(Food food) {
        return store.add(food);
    }

    @Override
    public List<Food> getStore() {
        return store;
    }
}
